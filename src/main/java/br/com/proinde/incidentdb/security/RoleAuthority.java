package br.com.proinde.incidentdb.security;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;

public class RoleAuthority extends Roles {
    public static final String OPERATOR = "OPERATOR";
    public static final String READER = "READER";

    public enum Authority {
        ADMIN("Administrator"),
        OPERATOR("Operator"),
        READER("Reader");

        private String label;

        Authority(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
