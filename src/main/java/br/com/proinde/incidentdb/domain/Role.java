package br.com.proinde.incidentdb.domain;

import br.com.proinde.incidentdb.security.RoleAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {

    public final static String AUTHENTICATION_QUERY = "SELECT r.authority FROM role r INNER JOIN user_role u_r ON r.id = u_r.role_id INNER JOIN [user] u ON u.id = u_r.user_id WHERE u.username = ?";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleAuthority.Authority authority;

    public Role() {
    }

    public Role(RoleAuthority.Authority authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleAuthority.Authority getAuthority() {
        return authority;
    }

    public void setAuthority(RoleAuthority.Authority authority) {
        this.authority = authority;
    }
}
