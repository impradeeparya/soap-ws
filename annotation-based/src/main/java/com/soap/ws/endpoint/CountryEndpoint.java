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
 * Created by pradeep on 7/4/17.
 */

@Endpoint
public class CountryEndpoint implements MarshallingCountryService {


    @Autowired
    private CountryRepository countryRepository;

    @Override
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = GET_COUNTRY_REQUEST)
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
