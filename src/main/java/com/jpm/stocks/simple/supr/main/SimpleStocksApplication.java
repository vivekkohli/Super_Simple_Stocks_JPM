package com.jpm.stocks.simple.supr.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpm.stocks.simple.supr.model.Trade;
import com.jpm.stocks.simple.supr.service.ComputationService;
import com.jpm.stocks.simple.supr.service.FileBasedTradeManager;

/*This is the main class of the application. It reads 2 Spring context 
 * XMLs to read the input data of Trades & their underlying stocks. The data is 
 * configured in the XMLs for ease of use. It then performs the computations required by 
 * the problem statement.*/
public class SimpleStocksApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-stock-config.xml",
				"spring-trade-config.xml");
		
		FileBasedTradeManager tradeManager = context.getBean("tradesManager", FileBasedTradeManager.class);
		List<Trade> allTrades = tradeManager.getAllTrades();
		ComputationService computationService = new ComputationService();
		
		// We got the trade data;perform computations now.
		for (Trade trade : allTrades) {
			computationService.calculateDividendYield(trade);
			computationService.calculatePeRatio(trade);
		}
		computationService.calculateVolumeWtStockPrice(allTrades);
		computationService.calculateGeometricMean(allTrades);
		//Close context at end.
		((ClassPathXmlApplicationContext) context).close();
	}

}
