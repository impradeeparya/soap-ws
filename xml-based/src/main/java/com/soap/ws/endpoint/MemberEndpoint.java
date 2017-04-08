package com.soap.ws.endpoint;

import com.soap.ws.xjc.GetMemberDetailsRequest;
import com.soap.ws.xjc.GetMemberDetailsResponse;
import com.soap.ws.xjc.MemberDetailType;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

/**
 * Created by pradeep on 8/4/17.
 */
public class MemberEndpoint extends AbstractMarshallingPayloadEndpoint {

    @Override
    protected Object invokeInternal(Object o) throws Exception {
        GetMemberDetailsRequest request = (GetMemberDetailsRequest) o;
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
