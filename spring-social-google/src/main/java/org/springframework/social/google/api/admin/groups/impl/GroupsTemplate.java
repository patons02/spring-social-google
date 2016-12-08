package org.springframework.social.google.api.admin.groups.impl;

import org.springframework.social.google.api.admin.groups.Group;
import org.springframework.social.google.api.admin.groups.GroupsOperations;
import org.springframework.social.google.api.impl.AbstractGoogleApiOperations;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

/**
 * {@link GroupsOperations} implementation.
 *
 * @author Stuart Paton
 */
public class GroupsTemplate extends AbstractGoogleApiOperations implements GroupsOperations {

    private static final String GROUPS_BASE_URL = "https://www.googleapis.com/admin/directory/v1/groups/";

    public GroupsTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }

    @Override
    public Group getGroup(String groupKey) {
        Assert.notNull(groupKey, "GroupKey must not be null!");
        GroupsGetQueryBuilderImpl builder = new GroupsGetQueryBuilderImpl(GROUPS_BASE_URL + "{0}", groupKey);
        return restTemplate.getForObject(builder.buildUri(), Group.class);
    }
}
