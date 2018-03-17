package com.jpm.stocks.simple.supr.model;

//Model object representing a Stock.It is composed inside a trade object.
public class Stock {

	private String symbol;

	private StockType type;

	private double lastDividend;

	private double fixedDividend;

	private double parValue;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public StockType getType() {
		return type;
	}

	public void setType(StockType type) {
		this.type = type;
	}

	public double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public double getParValue() {
		return parValue;
	}

	public void setParValue(double parValue) {
		this.parValue = parValue;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", type=" + type + ", lastDividend=" + lastDividend + ", fixedDividend="
				+ fixedDividend + ", parValue=" + parValue + "]";
	}

}
