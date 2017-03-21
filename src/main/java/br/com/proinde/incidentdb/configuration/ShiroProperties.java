package br.com.proinde.incidentdb.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = ShiroProperties.PROPERTY_PREFIX)
public class ShiroProperties {
    public static final String PROPERTY_PREFIX = "wicket.external.shiro";

    private boolean enabled = true;

    private String userRolesQuery = "select role_name from user_roles where username = ?";

    private String authenticationQuery = "select password from users where username = ?";

    private boolean permissionsLookupEnabled = false;

    private String permissionsQuery = "select permission from roles_permissions where role_name = ?";

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserRolesQuery() {
        return userRolesQuery;
    }

    public void setUserRolesQuery(String userRolesQuery) {
        this.userRolesQuery = userRolesQuery;
    }

    public String getAuthenticationQuery() {
        return authenticationQuery;
    }

    public void setAuthenticationQuery(String authenticationQuery) {
        this.authenticationQuery = authenticationQuery;
    }

    public boolean isPermissionsLookupEnabled() {
        return permissionsLookupEnabled;
    }

    public void setPermissionsLookupEnabled(boolean permissionsLookupEnabled) {
        this.permissionsLookupEnabled = permissionsLookupEnabled;
    }

    public String getPermissionsQuery() {
        return permissionsQuery;
    }

    public void setPermissionsQuery(String permissionsQuery) {
        this.permissionsQuery = permissionsQuery;
    }
}
