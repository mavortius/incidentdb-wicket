package br.com.proinde.incidentdb.view.page;

import br.com.proinde.incidentdb.security.RoleAuthority;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.basic.Label;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.shiro.ShiroConstraint;
import org.wicketstuff.shiro.annotation.ShiroSecurityConstraint;

@MountPath("administration")
@ShiroSecurityConstraint(
        constraint = ShiroConstraint.HasRole, value = RoleAuthority.ADMIN,
        unauthorizedMessage = "You must to have " + RoleAuthority.ADMIN + " role to access this page.")
public class AdministrationPage extends TemplatePage {

    public AdministrationPage() {
        super();

        add(new Label("roles", AuthenticatedWebSession.get().getRoles().toString()));
    }
}
