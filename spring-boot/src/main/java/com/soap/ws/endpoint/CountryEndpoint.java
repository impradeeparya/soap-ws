package com.soap.ws.endpoint;

import com.soap.ws.repository.CountryRepository;
import com.soap.ws.xjc.GetCountryRequest;
import com.soap.ws.xjc.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 17/2/17
 * Time: 9:27 PM
 */

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://soap.com/ws/xjc";

    @Autowired
    private CountryRepository countryRepository;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
