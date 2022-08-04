package com.jpmc.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TradeExceptionMapper implements ExceptionMapper<TradeException> {

	@Override
	public Response toResponse(TradeException e) {
		//exception handling/logging will be here
		
		ErrorObj errorObj = new ErrorObj();
		errorObj.setErrorCode(123);
		errorObj.setErrorMessage(e.getMessage());
		
		return Response
				.status(400)
				.entity(errorObj)
				.type("application/json")
				.build();
	}
	
	public static class ErrorObj {
		
		private int errorCode;
		private String errorMessage;
		
		public int getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
		
	}

	
}
