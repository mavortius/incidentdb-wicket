package br.com.proinde.incidentdb;


import br.com.proinde.incidentdb.domain.Role;
import br.com.proinde.incidentdb.security.RoleAuthority;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;

public class ShiroWebSession extends AuthenticatedWebSession {
    private static final long serialVersionUID = 1L;

    /**
     * Construct.
     *
     * @param request The current request object
     */
    public ShiroWebSession(Request request) {
        super(request);
        Injector.get().inject(this);
    }

    @Override
    protected boolean authenticate(String username, String password) {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
            return true;
        } catch (AuthenticationException e) {
            return false;
        }
    }

    @Override
    public Roles getRoles() {
        Roles roles = new Roles();
        Subject currentUser = SecurityUtils.getSubject();

        if(isSignedIn()) {
            for(RoleAuthority.Authority r : RoleAuthority.Authority.values()) {
                if(currentUser.hasRole(r.name())) {
                    roles.add(r.name());
                }
            }
        }

        return roles;
    }
}
