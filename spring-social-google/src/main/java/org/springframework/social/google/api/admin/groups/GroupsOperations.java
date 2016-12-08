package org.springframework.social.google.api.admin.groups;

/**
 * Retrieves {@link GroupsOperations}, used for interacting with Google Directory Groups API.
 * Some methods require OAuth2 scope from the following:
 * <ul>
 * <li>https://www.googleapis.com/auth/admin.directory.group.readonly</li>
 * <li>https://www.googleapis.com/auth/admin.directory.group</li>
 * </ul>
 *
 * @author Stuart Paton
 */
public interface GroupsOperations {

    /**
     * Retrieves single {@link Group} by group key.
     * Group key can either be the group's email address, group alias, or the unique group ID.
     * <p>
     * This method requires OAuth2 scope from one of the following:
     * <ul>
     * <li>https://www.googleapis.com/auth/admin.directory.group.readonly</li>
     * <li>https://www.googleapis.com/auth/admin.directory.group</li>
     * </ul>
     *
     * @author Stuart Paton
     */
    Group getGroup(String groupKey);
}
