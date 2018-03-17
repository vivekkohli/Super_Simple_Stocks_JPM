package com.jpm.stocks.simple.supr.model;

import java.util.Date;

/* This class holds data pertaining to an executed trade.*/
public class Trade {

	// Private data members to ensure encapsulation.
	private Date executionTimeStamp;
	
	// indicates the no of shares bought or sold
	private int quantityOfShares;

	private TradeDirection direction;

	private double price;
	
	//indicates the minutes by which the 
	private int minutesInPast;
	//the stock that was traded
	private Stock stock;

	public Date getExecutionTimeStamp() {
		return executionTimeStamp;
	}

	public void setExecutionTimeStamp(Date executionTimeStamp) {
		this.executionTimeStamp = executionTimeStamp;
	}
	
	public int getQuantityOfShares() {
		return quantityOfShares;
	}

	public void setQuantityOfShares(int quantityOfShares) {
		this.quantityOfShares = quantityOfShares;
	}


	public TradeDirection getDirection() {
		return direction;
	}

	public void setDirection(TradeDirection direction) {
		this.direction = direction;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return " [ "+ direction + " " + quantityOfShares + " of " + stock.getSymbol() +"]";
	}

}
