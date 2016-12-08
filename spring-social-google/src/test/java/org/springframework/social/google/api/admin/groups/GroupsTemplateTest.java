package org.springframework.social.google.api.admin.groups;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.social.google.api.AbstractGoogleApiTest;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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

        Group group = google.adminOperations().groupsOperations().getGroup(groupKey);

        assertNotNull(group);
        assertEquals("admin#directory#group", group.getKind());
        assertEquals("onn6d9kbhps6fc47m96auhtkdo", group.getId());
        assertEquals("\"2831656302604000\"", group.getEtag());
        assertEquals("test@example.com", group.getEmail());
        assertEquals("Joe Bloggs", group.getName());
        assertEquals(4L, group.getDirectMembersCount().longValue());
        assertEquals("A test group.", group.getDescription());
        assertTrue(group.getAdminCreated());
        assertEquals(1, group.getAliases().size());
        assertEquals("test1@example.com", group.getAliases().get(0));
        assertEquals(0, group.getNonEditableAliases().size());
    }

    @Test
    public void listGroups_RetrievesAPaginatedListOfAllGroups_WithNoOptionalQueryStringsSpecified() {

        mockServer
                .expect(requestTo("https://www.googleapis.com/admin/directory/v1/groups/"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("mock_groups_listing_no_optional_query_strings"), APPLICATION_JSON));

        GroupsListing groupsListing = google.adminOperations().groupsOperations().listGroups();

        assertNotNull(groupsListing);
        assertEquals("admin#directory#groups", groupsListing.getKind());
        assertEquals("\"2831656302604020\"", groupsListing.getEtag());
        assertEquals(1, groupsListing.getGroups().size());
        assertNotNull(groupsListing.getGroups().get(0));
        assertEquals("1", groupsListing.getNextPageToken());
    }
}
