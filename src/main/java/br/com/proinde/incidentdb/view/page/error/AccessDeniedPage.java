package br.com.proinde.incidentdb.view.page.error;

import com.giffing.wicket.spring.boot.context.scan.WicketAccessDeniedPage;
import org.apache.wicket.markup.html.pages.AbstractErrorPage;
import org.apache.wicket.request.http.WebResponse;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.shiro.ShiroConstraint;
import org.wicketstuff.shiro.annotation.ShiroSecurityConstraint;

import javax.servlet.http.HttpServletResponse;

@WicketAccessDeniedPage
@MountPath("unauthorized")
@ShiroSecurityConstraint(constraint = ShiroConstraint.IsAuthenticated)
public class AccessDeniedPage extends AbstractErrorPage {

    public AccessDeniedPage() {
    }

    @Override
    protected void setHeaders(final WebResponse response) {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}
