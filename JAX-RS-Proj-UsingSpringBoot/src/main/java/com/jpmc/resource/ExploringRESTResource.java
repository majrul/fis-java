package com.jpmc.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.jpmc.dao.TradeDao;
import com.jpmc.entity.Trade;

@Path("/example")
public class ExploringRESTResource {

	//URL : http://localhost:8080/1.0/example/01/1001/Majrul/1000
	@GET
	@Path("/01/{empno}/{name}/{salary}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example01(
			@PathParam("empno") int empno,
			@PathParam("name") String name,
			@PathParam("salary") double salary) {
		
		System.out.println(empno + " , " + name + " , " + salary);
		
		return "Response from example01";
	}

	//URL : http://localhost:8080/1.0/example/02?empno=1001&empno=1002&name=Majrul&salary=10000
	@GET
	@Path("/02")
	@Produces(MediaType.TEXT_PLAIN)
	public String example02(
			@QueryParam("empno") int empno,
			@QueryParam("name") String name,
			@QueryParam("salary") double salary) {
		
		System.out.println(empno + " , " + name + " , " + salary);
		
		return "Response from example02";
	}

	//URL : http://localhost:8080/1.0/example/03;empno=1001;name=Majrul;salary=10000
	@GET
	@Path("/03")
	@Produces(MediaType.TEXT_PLAIN)
	public String example03(
			@MatrixParam("empno") int empno,
			@MatrixParam("name") String name,
			@MatrixParam("salary") double salary) {
		
		System.out.println(empno + " , " + name + " , " + salary);
		
		return "Response from example03";
	}
	
	//URL : http://localhost:8080/1.0/example/04/1001/Majrul
	@GET
	@Path("/04/{empno : \\d+}/{name : [a-zA-Z]*}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example04(
			@PathParam("empno") int empno,
			@PathParam("name") String name) {
		
		System.out.println(empno + " , " + name);
		
		return "Response from example04";
	}
	
	//for ex: we need to construct an URL in which we need to send bunch of empnos
	//URL : http://localhost:8080/1.0/example/05/1001/1002/1003/action/sendEmail
	//URL : http://localhost:8080/1.0/example
			// /05/1001;doublecheck=true/1002;sendSMS=true
			// /1003/1004;doublecheck=true;sendSMS=true/1005/action/sendEmail
	@GET
	@Path("/05/{empnos : .+}/action/{someAction}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example05(
			//@PathParam("empnos") String empnos, //not the right way
			//@PathParam("empnos") List<String> empnos, //not working this too
			@PathParam("empnos") List<PathSegment> empnos, //the right way
			@PathParam("someAction") String someAction) {
		
		//System.out.println(empnos + " , " + someAction);
		for(PathSegment empno : empnos) {
			System.out.println(empno.getPath());
			System.out.println(empno.getMatrixParameters());
		}
		System.out.println(someAction);
		
		return "Response from example05";
	}
	
	//URL : /06/abc/xyz;z=30?x=10&y=20
	@GET
	@Path("/06/{param1}/{param2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example06(@BeanParam SampleBean bean) {
		System.out.println(bean);
		return "Response from example06";
	}
	
	//DI support
	//URL : /07/123/456?x=10&y=20
	@GET
	@Path("/07/{param1}/{param2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String example07(
			@Context UriInfo uriInfo,
			@Context HttpHeaders headers,
			@Context SecurityContext sCtx) {
		
		System.out.println(uriInfo.getPath());
		System.out.println(uriInfo.getBaseUri());
		System.out.println(uriInfo.getRequestUri());
		System.out.println(uriInfo.getAbsolutePath());
		
		return "Response from example07";
	}
	
	//revisiting Response API
	@GET
	@Path("/08")
	public Response example08() {
		return Response
				.ok() //200 OK Status Code
				.header("app-key", "Dfgsd93024sdklfsd") //any inbuilt or custom header
				.cookie(new NewCookie("username", "majrul")) //HTTP cookies
				.entity("Response from example08") //Response Body
				.type(MediaType.TEXT_PLAIN) //Content-Type
				.build();				
	}
	
	//URL : http://localhost:8080/1.0/example/trades/NY.json
	//URL : http://localhost:8080/1.0/example/trades/NY.xml
	@GET
	@Path("/trades/{region}.{format}")
	public Response getTradesByRegion(
			@PathParam("region") String region,
			@PathParam("format") String format) {
		TradeDao dao = new TradeDao();
		List<Trade> trades = dao.fetchAllTrades(region);
		
		//Response API doesn't support collections directly
		//so we need to use this wrapper
		GenericEntity<List<Trade>> wrappedListOfTrades = 
				new GenericEntity<List<Trade>>(trades) { };
		
		if(format.equalsIgnoreCase("xml"))
			return Response
					.ok()
					.entity(wrappedListOfTrades)
					.type(MediaType.APPLICATION_XML)
					.build();
		else
			return Response
					.ok()
					.entity(wrappedListOfTrades)
					.type(MediaType.APPLICATION_JSON)
					.build();
				
	}

	//try sending link(s) in the response
	@POST
	@Path("/trade/add")
	@Consumes({ "application/json" , "application/xml" })
	public Response postNewTrade(Trade trade, @Context UriInfo uriInfo) {
		TradeDao dao = new TradeDao();
		dao.newTrade(trade);
		
		//code to generate a URI
		UriBuilder uriBuilder = 
				uriInfo.getBaseUriBuilder(); //http://localhost:8080/1.0
		uriBuilder.path(TradeResource.class); // /trade
		uriBuilder.path(TradeResource.class, "getTradeById"); // /{tradeId}

		//so we have the following uri by now:
		// http://localhost:8080/1.0/trade/{tradeId}
		
		//substituting {tradeId} and return the final URI
		URI uri = uriBuilder.build(trade.getTradeId()); 
		
		return Response
				.created(uri) //201 Created Status Code
				.entity("Trade record created successfully!")
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

	//one more way of sending links in the response
	@POST
	@Path("/trade/addv2")
	@Consumes({ "application/json" , "application/xml" })
	public Response postNewTradev2(Trade trade, @Context UriInfo uriInfo) {
		TradeDao dao = new TradeDao();
		dao.newTrade(trade);
		
		UriBuilder uriBuilder1 = uriInfo
								.getBaseUriBuilder()
								.path(TradeResource.class)
								.path(TradeResource.class, "getTradeById");

		UriBuilder uriBuilder2 = uriInfo
								.getBaseUriBuilder()
								.path(TradeResource.class)
								.path(TradeResource.class, "getAllTrades");
		
		Link link1 = Link
						.fromUriBuilder(uriBuilder1)
						.rel("get trade by id") //any logical name
						.build(trade.getTradeId());
		
		Link link2 = Link
						.fromUriBuilder(uriBuilder2)
						.rel("get all the trades") //any logical name
						.build();
		
		return Response
				.ok()
				.links(link1, link2)
				.entity("Trade record created successfully!")
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

	//sending response in the CSV format
	@GET
	@Path("/{tradeId}.csv")
	@Produces("text/csv")
	public Trade getTradeById(@PathParam("tradeId") int tradeId) {
		TradeDao dao = new TradeDao();
		return dao.fetchTrade(tradeId);
	}

	
	
	public static class SampleBean {
		
		@PathParam("param1")
		private String param1;
		
		@PathParam("param2")
		private String param2;
		
		@QueryParam("x")
		private int x;
		
		@QueryParam("y")
		private int y;
		
		@MatrixParam("z")
		private int z;
		
		@HeaderParam("app-key")
		private String appkey;
		
		@CookieParam("username")
		private String username;

		@Override
		public String toString() {
			return "SampleBean [param1=" + param1 + ", param2=" + param2 + ", x=" + x + ", y=" + y + ", z=" + z
					+ ", appkey=" + appkey + ", username=" + username + "]";
		}
		
		
	}
	
}









