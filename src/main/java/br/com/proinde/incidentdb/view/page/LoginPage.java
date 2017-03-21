package br.com.proinde.incidentdb.view.page;

import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

@WicketSignInPage
@MountPath("login")
public class LoginPage extends WebPage {

    public LoginPage(PageParameters parameters) {
        super(parameters);

        AuthenticatedWebSession session = AuthenticatedWebSession.get();

        if(session.isSignedIn()) {
            continueToOriginalDestination();
            setResponsePage(getApplication().getHomePage());
        }

        add(new LoginForm("form"));
    }

    private class LoginForm extends Form<LoginForm> {
        private String username;
        private String password;

        public LoginForm(String markupId) {
            super(markupId);
            setModel(new CompoundPropertyModel<>(this));
            add(new FeedbackPanel("feedback"));
            add(new RequiredTextField<String>("username"));
            add(new PasswordTextField("password"));
        }

        @Override
        protected void onSubmit() {
            if(login(username, password)) {
                continueToOriginalDestination();
                setResponsePage(getApplication().getHomePage());
            } else {
                error("Login Failed");
            }
        }
    }

    public boolean login(final String username, final String password) {
        try {
            AuthenticatedWebSession session = AuthenticatedWebSession.get();

            return session.signIn(username, password);
        } catch (Exception e) {
            error(e.getMessage());
            return false;
        }
    }
}
