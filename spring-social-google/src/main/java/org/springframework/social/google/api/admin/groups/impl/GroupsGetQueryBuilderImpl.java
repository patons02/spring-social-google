package org.springframework.social.google.api.admin.groups.impl;

import org.springframework.social.google.api.calendar.impl.UriQueryBuilderImpl;

import java.text.MessageFormat;

public class GroupsGetQueryBuilderImpl extends UriQueryBuilderImpl<GroupsGetQueryBuilderImpl, Object> {

    public GroupsGetQueryBuilderImpl(String urlTemplate, String groupKey) {
        super(MessageFormat.format(urlTemplate, encode(groupKey)));
    }
}
