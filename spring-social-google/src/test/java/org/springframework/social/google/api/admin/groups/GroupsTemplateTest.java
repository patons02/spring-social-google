package org.springframework.social.google.api.admin.groups;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.social.google.api.AbstractGoogleApiTest;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.core.Is.is;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class GroupsTemplateTest extends AbstractGoogleApiTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getGroupThrowsExceptionWhenGroupKeyIsNull() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(is("GroupKey must not be null!"));
        google.adminOperations().groupsOperations().getGroup(null);
    }

    @Test
    public void getGroup_ReturnsGroupForGroupKey() throws UnsupportedEncodingException {

        String groupKey = "test@example.com";

        mockServer
                .expect(requestTo("https://www.googleapis.com/admin/directory/v1/groups/" + encodeUTF8(groupKey)))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("mock_retrieved_group"), APPLICATION_JSON));

        google.adminOperations().groupsOperations().getGroup(groupKey);
    }
}
