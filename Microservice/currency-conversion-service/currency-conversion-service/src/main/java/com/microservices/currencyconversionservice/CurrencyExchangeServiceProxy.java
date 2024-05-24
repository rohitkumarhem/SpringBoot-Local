package com.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.currencyexchangeservice.ExchangeValue;

//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
//@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}") 
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") 
	public ExchangeValue convertCurrencyFeign(@PathVariable String from, 
			@PathVariable String to);
	
}
