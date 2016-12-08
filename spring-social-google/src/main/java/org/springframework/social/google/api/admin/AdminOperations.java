package org.springframework.social.google.api.admin;

import org.springframework.social.google.api.admin.groups.GroupsOperations;

/**
 * Interface specifying a basic set of operations for interacting with Google Directory
 * APIs. Implemented by {@link org.springframework.social.google.api.admin.impl.AdminTemplate}.
 *
 * @author Stuart Paton
 */
public interface AdminOperations {

    /**
     * Retrieves {@link GroupsOperations}, used for interacting with Google Directory Groups API.
     * Some methods require OAuth2 scope from the following:
     * <ul>
     * <li>https://www.googleapis.com/auth/admin.directory.group.readonly</li>
     * <li>https://www.googleapis.com/auth/admin.directory.group</li>
     * </ul>
     *
     * @return {@link GroupsOperations} for the authenticated user if authenticated
     */
    GroupsOperations groupsOperations();
}
