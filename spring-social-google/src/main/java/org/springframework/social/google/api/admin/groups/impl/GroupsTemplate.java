package org.springframework.social.google.api.admin.groups.impl;

import org.springframework.social.google.api.admin.groups.GroupsOperations;
import org.springframework.social.google.api.impl.AbstractGoogleApiOperations;
import org.springframework.web.client.RestTemplate;

public class GroupsTemplate extends AbstractGoogleApiOperations implements GroupsOperations {

    public GroupsTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
    }
}
