package com.soap.ws.endpoint;

import com.soap.ws.repository.CountryRepository;
import com.soap.ws.xjc.GetCountryRequest;
import com.soap.ws.xjc.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

/**
 * Created by pradeep on 7/4/17.
 */

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://soap.com/ws/xjc";
    private static final String GET_COUNTRY_REQUEST = "getCountryRequest";

    private CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = GET_COUNTRY_REQUEST)
    public GetCountryResponse getCountry(GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }

    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
}
