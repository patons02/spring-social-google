package org.springframework.social.google.api.admin.groups;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Model class representing a listing of all Groups within the Google Directory API.
 * <p>See the reference documentation at
 * <a href="https://developers.google.com/admin-sdk/directory/v1/reference/groups/list">
 * https://developers.google.com/admin-sdk/directory/v1/reference/groups/list</a>.
 * </p>
 * @author Stuart Paton
 */
public class GroupsListing {

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String kind;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String etag;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<Group> groups;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String nextPageToken;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }
}
