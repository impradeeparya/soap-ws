package com.soap.ws.endpoint;

import com.soap.ws.repository.CountryRepository;
import com.soap.ws.xjc.*;
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
public class WSEndpoint {
    private static final String NAMESPACE_URI = "http://soap.com/ws/xjc";

    @Autowired
    private CountryRepository countryRepository;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryInfo(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMemberDetailsRequest")
    @ResponsePayload
    public GetMemberDetailsResponse getMemberInfo(@RequestPayload GetMemberDetailsRequest request) {
        GetMemberDetailsResponse response = new GetMemberDetailsResponse();

        String id = request.getId();

        MemberDetailType memberDetailType = new MemberDetailType();
        if ("arya".equalsIgnoreCase(id)) {
            memberDetailType.setCity("New Delhi");
            memberDetailType.setName("Pradeep Arya");
            memberDetailType.setPhone("9999");
            memberDetailType.setState("New Delhi");
        } else {
            memberDetailType.setCity("testCity");
            memberDetailType.setName("testName");
            memberDetailType.setPhone("testNumber");
            memberDetailType.setState("testState");
        }

        response.setMemberdetail(memberDetailType);

        return response;
    }
}
