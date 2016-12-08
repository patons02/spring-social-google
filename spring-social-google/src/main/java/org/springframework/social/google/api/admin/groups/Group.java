package org.springframework.social.google.api.admin.groups;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Model class representing a Group resource within the Google Directory API.
 * <p>See the reference documentation at
 * <a href="https://developers.google.com/admin-sdk/directory/v1/reference/groups#resource">
 * https://https://developers.google.com/admin-sdk/directory/v1/reference/groups#resource</a>.
 * </p>
 * @author Stuart Paton
 */
public class Group {

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String kind;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String id;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String etag;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String email;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Long directMembersCount;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String description;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Boolean adminCreated;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<String> aliases;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<String> nonEditableAliases;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDirectMembersCount() {
        return directMembersCount;
    }

    public void setDirectMembersCount(Long directMembersCount) {
        this.directMembersCount = directMembersCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAdminCreated() {
        return adminCreated;
    }

    public void setAdminCreated(Boolean adminCreated) {
        this.adminCreated = adminCreated;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getNonEditableAliases() {
        return nonEditableAliases;
    }

    public void setNonEditableAliases(List<String> nonEditableAliases) {
        this.nonEditableAliases = nonEditableAliases;
    }
}
