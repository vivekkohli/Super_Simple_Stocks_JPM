package com.jpm.stocks.simple.supr.service;

import java.util.List;

import com.jpm.stocks.simple.supr.exception.IllegalStockTypeException;
import com.jpm.stocks.simple.supr.helper.TradeDateHelper;
import com.jpm.stocks.simple.supr.model.Stock;
import com.jpm.stocks.simple.supr.model.StockType;
import com.jpm.stocks.simple.supr.model.Trade;

/**
 * This is the class that performs all the computations mentioned in the
 * requirements.
 * 
 **/
public class ComputationService {

	// How much duration to consider in past for computing the Volume Wt Stock Price.
	private final int MINUTES_IN_PAST = 15;

	/**
	 * @param trade
	 * @return the dividend yield
	 * @throws Exception
	 */
	public double calculateDividendYield(Trade trade) throws Exception {
		double dividendYield = 0;
		Stock tradedStock = trade.getStock();
		double marketPrice = trade.getPrice();
		if (tradedStock.getType().equals(StockType.COMMON)) {
			dividendYield = tradedStock.getLastDividend() / marketPrice;
		} else if (tradedStock.getType().equals(StockType.PREFERRED)) {
			dividendYield = (tradedStock.getFixedDividend() * tradedStock.getParValue()) / marketPrice;
		} else {
			throw new IllegalStockTypeException(tradedStock.getType().name());
		}
		System.out.println("\nDividend yield for the trade" + trade + " is:" + dividendYield);
		return dividendYield;
	}

	/**
	 * @param trade
	 * @return the PE ratio
	 * @throws Exception
	 */
	public double calculatePeRatio(Trade trade) throws Exception {
		double peRatio = trade.getPrice() / trade.getStock().getLastDividend();
		System.out.println("PE Ratio for the trade" + trade + " is:" + peRatio);
		return peRatio;
	}

	/**
	 * @param the
	 *            trades for which Volume Wt Stock Price is to be computed
	 * @return the Volume weighted stock price
	 * @throws Exception
	 */
	public double calculateVolumeWtStockPrice(List<Trade> trades) throws Exception {
		double priceQty = 0.0;
		double qty = 0.0;
		int count = 0;
		for (Trade trade : trades) {
			if (TradeDateHelper.isWithinMinutes(trade.getExecutionTimeStamp(), MINUTES_IN_PAST)) {
				priceQty += (trade.getPrice() * trade.getQuantityOfShares());
				qty += trade.getQuantityOfShares();
				count++;
			}
		}
		double volWtStkPrc = priceQty / qty;
		System.out.println();
		System.out.println(count + " Trades that were booked in last " + MINUTES_IN_PAST + " minutes "
				+ "considered for computing Volume Wt Stock Price of: " + volWtStkPrc);
		return volWtStkPrc;
	}

	/**
	 * @param the
	 *            trades for which geometric mean is to be computed
	 * @return the geometric mean
	 */
	public double calculateGeometricMean(List<Trade> trades) {
		double priceOfAllStocks = 1.0;
		for (Trade trade : trades) {
			priceOfAllStocks += (trade.getPrice() * trade.getQuantityOfShares());
		}
		double geometricMean = Math.pow(priceOfAllStocks, 1.0 / trades.size());
		System.out.println("Geometric mean for trades is " + geometricMean);
		return geometricMean;
	}
}
