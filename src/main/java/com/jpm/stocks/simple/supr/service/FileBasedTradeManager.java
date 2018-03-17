package com.jpm.stocks.simple.supr.service;

import java.util.List;

import com.jpm.stocks.simple.supr.model.Trade;

public class FileBasedTradeManager implements ITradeManager {

	// These trades are injected from the Spring context XML spring-trade-config.xml
	private List<Trade> trades;

	@Override
	public List<Trade> getAllTrades() {
		// return the data injected from context xml.
		return trades;
	}
	
	// Setter to allow for injection from Spring context file.
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

}
