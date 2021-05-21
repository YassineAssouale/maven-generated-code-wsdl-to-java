package soap.service.maven.wsdl2java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.oracle.xmlns.webservices.jaxws_databinding.ObjectFactory;

import ya.dev.maven.wsdl2java.NumberConversion;
import ya.dev.maven.wsdl2java.NumberConversionSoapType;

public class Runner {

	public static void main(String[] args) throws MalformedURLException {
		// Endpoint : website url
		final String endpoint = "https://www.dataaccess.com/webservicesserver/numberconversion.wso";
		
		// url to use
		final URL url = URI.create(endpoint).toURL();
		
		// Service instanciation
		final NumberConversion service = new NumberConversion(url);
		
		// Port configuration
		final NumberConversionSoapType port = service.getPort(NumberConversionSoapType.class);
		
		// Test && display result
		System.out.println("$15.99 -- >  " + port.numberToDollars(BigDecimal.valueOf(15.99)));
		System.out.println("$34 -- >  " + port.numberToWords(BigInteger.valueOf(34)));
	}
}
