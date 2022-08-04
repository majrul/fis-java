package com.jpmc.dao;

import java.util.ArrayList;
import java.util.List;

import com.jpmc.entity.Trade;
import com.jpmc.exception.TradeException;

public class TradeDao {

	public Trade fetchTrade(int tradeId) {
		if(tradeId == 11111)
			throw new TradeException("No such record found for Trade ID 11111");
		
		Trade trade = new Trade();
		trade.setTradeId(tradeId);
		trade.setDate("21-09-2017");
		trade.setAmount(4500);
		trade.setRegion("NY");
		return trade;
	}
	
	public List<Trade> fetchAllTrades() {
		List<Trade> trades = new ArrayList<>();

		return trades;
	}

	public List<Trade> fetchAllTrades(String region) {
		List<Trade> trades = new ArrayList<>();

		Trade trade = new Trade();
		trade.setTradeId(12345);
		trade.setDate("21-09-2017");
		trade.setAmount(4500);
		trade.setRegion(region);
		trades.add(trade);

		trade = new Trade();
		trade.setTradeId(67890);
		trade.setDate("21-09-2017");
		trade.setAmount(5500);
		trade.setRegion(region);
		trades.add(trade);

		trade = new Trade();
		trade.setTradeId(11223);
		trade.setDate("21-09-2017");
		trade.setAmount(6500);
		trade.setRegion(region);
		trades.add(trade);

		return trades;		
	}

	public void newTrade(Trade trade) {
		
	}
	
}
