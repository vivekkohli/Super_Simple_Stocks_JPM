package com.jpm.stocks.simple.supr.helper;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.jpm.stocks.simple.supr.model.Stock;
import com.jpm.stocks.simple.supr.model.StockType;
import com.jpm.stocks.simple.supr.model.Trade;
import com.jpm.stocks.simple.supr.model.TradeDirection;
import com.jpm.stocks.simple.supr.service.ComputationService;

public class ComputationServiceTest {

	@Test
	public void testCalculateDividendYield_CommonStock() throws Exception {
		ComputationService computationService=new ComputationService();
		Trade trade= getTradeWithCommonStock();
		double result =computationService.calculateDividendYield(trade);
		//expected result=1000/500
		assertEquals(2.0, result,0.0);

	}
	
	private Trade getTradeWithCommonStock() {
		Trade trade= new Trade();
		trade.setDirection(TradeDirection.BUY);
		trade.setExecutionTimeStamp(new Date());
		trade.setPrice(500);
		trade.setQuantityOfShares(15);
		
		Stock commonStock= new Stock();
		commonStock.setSymbol("TEA");
		commonStock.setFixedDividend(100);
		commonStock.setLastDividend(1000);
		commonStock.setType(StockType.COMMON);
		commonStock.setParValue(100);
		
		trade.setStock(commonStock);
		
		return trade;
	}
	
	@Test
	public void testCalculateDividendYield_PreferredStock() throws Exception {
		ComputationService computationService=new ComputationService();
		Trade trade= getTradeWithCommonStock();
		Stock stock= trade.getStock();
		stock.setType(StockType.PREFERRED);
		double result =computationService.calculateDividendYield(trade);
		//expected result=100*100/500
		assertEquals(20.0, result,0.0);
	}

	@Test
	public void testCalculatePeRatio() throws Exception {
		ComputationService computationService=new ComputationService();
		Trade trade= getTradeWithCommonStock();
		double result =computationService.calculatePeRatio(trade);
		//expected result=500/1000
		assertEquals(0.5, result,0.0);
	}
	
	@Test
	public void testCalculateVolumeWtStockPrice() throws Exception {
		ComputationService computationService=new ComputationService();
		Trade trade1= getTradeWithCommonStock();
		Trade trade2= getTradeWithCommonStock();
		List<Trade> trades= new ArrayList<Trade>();
		trades.add(trade1);trades.add(trade2);
		double result =computationService.calculateVolumeWtStockPrice(trades);
		//expected result=(500*15 + 500*15)/30
		assertEquals(500.0, result,0.0);
	}
	
	@Test
	public void testCalculateGeometricMean() throws Exception {
		ComputationService computationService=new ComputationService();
		Trade trade1= getTradeWithCommonStock();
		Trade trade2= getTradeWithCommonStock();
		List<Trade> trades= new ArrayList<Trade>();
		trades.add(trade1);trades.add(trade2);
		double result =computationService.calculateGeometricMean(trades);
		//expected result=square root of (500*15 + 500*15) as trade size is 2
		DecimalFormat decimalFormat = new DecimalFormat("###.##");
		assertEquals("122.48", decimalFormat.format(result));
	}
	
}
