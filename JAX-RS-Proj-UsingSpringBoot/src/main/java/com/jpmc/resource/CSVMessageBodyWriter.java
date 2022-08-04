package com.jpmc.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.jpmc.entity.Trade;

@Provider
@Produces("text/csv")
public class CSVMessageBodyWriter implements MessageBodyWriter<Trade> {

	   @Override
	    public void writeTo(Trade trade,
	                        Class<?> type,
	                        Type genericType,
	                        Annotation[] annotations,
	                        MediaType mediaType,
	                        MultivaluedMap<String, Object> httpHeaders,
	                        OutputStream entityStream)
	                        throws IOException, WebApplicationException {
	 
		   PrintWriter out = new PrintWriter(entityStream);
		   out.write(trade.getTradeId()+","+trade.getDate()+","+trade.getRegion()+","+trade.getAmount());
	       out.close();
	    }
	   

	   @Override
    public boolean isWriteable(Class<?> type, Type genericType,
                               Annotation[] annotations, MediaType mediaType) {
        return type == Trade.class;
    }
 
    @Override
    public long getSize(Trade myBean, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType) {
        // deprecated by JAX-RS 2.0 and ignored by Jersey runtime
        return -1;
    }
 
 	
}
