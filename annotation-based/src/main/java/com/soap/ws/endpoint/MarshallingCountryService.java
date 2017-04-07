package com.soap.ws.endpoint;

import com.soap.ws.xjc.GetCountryRequest;
import com.soap.ws.xjc.GetCountryResponse;

/**
 * Created by pradeep on 7/4/17.
 */
public interface MarshallingCountryService {

    String NAMESPACE_URI = "http://soap.com/ws/xjc";
    String GET_COUNTRY_REQUEST = "getCountryRequest";

    GetCountryResponse getCountry(GetCountryRequest request);
}
