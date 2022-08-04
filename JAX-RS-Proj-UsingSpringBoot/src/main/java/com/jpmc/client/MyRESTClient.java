package com.jpmc.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import com.jpmc.entity.Trade;
import com.jpmc.exception.TradeExceptionMapper.ErrorObj;

public class MyRESTClient {

	public static void main(String[] args) {
		//JAX-RS Client API
		Client client = ClientBuilder.newClient();
		
		//get trade by id
		WebTarget target = 
				client.target("http://localhost:8080/JAX-RS-Proj/1.0/trade/{tradeId}");
		
		String responseStr = target
								.resolveTemplate("tradeId", 12345) //substituting {tradeId}
								.request() //generating a request
								.accept("application/json") //setting Accept header
								.get(String.class); //sending request using GET of HTTP
		System.out.println(responseStr);
		
		//storing the response in an Object
		Trade tradeObj = target
				.resolveTemplate("tradeId", 12345) //substituting {tradeId}
				.request() //generating a request
				.accept("application/json") //setting Accept header
				.get(Trade.class); //sending request using GET of HTTP
		System.out.println(tradeObj.getAmount() + "," +tradeObj.getRegion());
		
		//handling error response
		Response response = target
							.resolveTemplate("tradeId", 11111) //substituting {tradeId}
							.request() //generating a request
							.accept("application/json") //setting Accept header
							.get(Response.class); //sending request using GET of HTTP
		if(response.getStatus() == 400) {
			ErrorObj errorObj = response.readEntity(ErrorObj.class);
			System.out.println(errorObj.getErrorCode() + " , " + errorObj.getErrorMessage());
		}
		else {
			Trade trade = response.readEntity(Trade.class);
			System.out.println(trade.getAmount() + " , " + trade.getRegion());
		}
		
		
		//----------------- getting trades by region -----------------//
		target = 
			client.target("http://localhost:8080/JAX-RS-Proj/1.0/trade/region/{region}");
		responseStr = target
				.resolveTemplate("region", "NY") //substituting {region}
				.request() //generating a request
				.accept("application/json") //setting Accept header
				.get(String.class); //sending request using GET of HTTP
		System.out.println(responseStr);
		
		//storing the response in a List
		List<Trade> listOfTrades = target
						.resolveTemplate("region", "NY") //substituting {region}
						.request() //generating a request
						.accept("application/json") //setting Accept header
						.get(new GenericType<List<Trade>>() { }); //sending request using GET of HTTP
		for(Trade trade : listOfTrades)
			System.out.println(trade); //override toString or invoke getters
		
		
		//testing POST method
		Trade newTrade = new Trade();
		newTrade.setTradeId(945311);
		newTrade.setDate("21-09-2017");
		newTrade.setAmount(56490);
		newTrade.setRegion("LN");
		
		target = 
				client.target("http://localhost:8080/JAX-RS-Proj/1.0/trade/add");
		
		responseStr = target
						.request()
						//content-type header will be set automatically
						.post(Entity.entity(newTrade, "application/json"), String.class);
		System.out.println(responseStr);
		
		client.close(); //should be in finally
		
		
	}
}












