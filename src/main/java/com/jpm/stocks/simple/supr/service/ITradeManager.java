package com.jpm.stocks.simple.supr.service;

import java.util.List;

import com.jpm.stocks.simple.supr.model.Trade;

/**
 * Coding to an interface than an implementation to allow a different
 * implementation to be used in the application if required.
 */
public interface ITradeManager {

	// this could be any impl- from DB, file etc. Here in this case we will be
	// getting the data from the XML file spring-trade-config.xml.
	List<Trade> getAllTrades();
}
