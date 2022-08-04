package com.jpmc.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.jpmc.dao.TradeDao;
import com.jpmc.entity.Trade;

@Path("/trade")
public class TradeResource {

	//URL : http://localhost:8080/JAX-RS-Proj/1.0/trade/12345
	@GET
	@Path("/{tradeId}")
	@Produces({ "application/json" , "application/xml" })
	public Trade getTradeById(@PathParam("tradeId") int tradeId) {
		TradeDao dao = new TradeDao();
		return dao.fetchTrade(tradeId);
	}

	//URL : http://localhost:8080/JAX-RS-Proj/1.0/trade/region/NY
	@GET
	@Path("/region/{region}")
	@Produces({ "application/json" , "application/xml" })
	public List<Trade> getTradesByRegion(@PathParam("region") String region) {
		TradeDao dao = new TradeDao();
		return dao.fetchAllTrades(region);
	}

	//URL : http://localhost:8080/JAX-RS-Proj/1.0/trade/all
	@GET
	@Path("/all")
	@Produces({ "application/json" , "application/xml" })
	public List<Trade> getAllTrades() {
		TradeDao dao = new TradeDao();
		return dao.fetchAllTrades();
	}

	@POST
	@Path("/add")
	@Consumes({ "application/json" , "application/xml" })
	@Produces("text/plain")
	public String postNewTrade(Trade trade) {
		TradeDao dao = new TradeDao();
		dao.newTrade(trade);
		
		return "Trade record created successfully!";
	}
	
}












