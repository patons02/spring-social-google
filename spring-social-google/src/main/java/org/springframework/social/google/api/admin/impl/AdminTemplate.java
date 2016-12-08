package org.springframework.social.google.api.admin.impl;

import org.springframework.social.google.api.admin.AdminOperations;
import org.springframework.social.google.api.admin.groups.GroupsOperations;
import org.springframework.social.google.api.admin.groups.impl.GroupsTemplate;
import org.springframework.social.google.api.impl.AbstractGoogleApiOperations;
import org.springframework.web.client.RestTemplate;

public class AdminTemplate extends AbstractGoogleApiOperations implements AdminOperations {

    private GroupsOperations groupsOperations;

    public AdminTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
        initialize(restTemplate, isAuthorized);
    }

    private void initialize(RestTemplate restTemplate, boolean isAuthorized) {
        groupsOperations = new GroupsTemplate(restTemplate, isAuthorized);
    }

    @Override
    public GroupsOperations groupsOperations() {
        return groupsOperations;
    }
}
