package br.com.proinde.incidentdb.view.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.shiro.ShiroConstraint;
import org.wicketstuff.shiro.ShiroSubjectModel;
import org.wicketstuff.shiro.annotation.ShiroSecurityConstraint;

@WicketHomePage
@MountPath("home")
@ShiroSecurityConstraint(constraint = ShiroConstraint.IsAuthenticated)
public class HomePage extends TemplatePage {

    public HomePage() {
        super();
        Form<Void> form = new Form<Void>("form"){
            @Override
            protected void onSubmit() {
                setResponsePage(AdministrationPage.class);
            }
        };

        form.add(new Label("username", new ShiroSubjectModel().getObject().getPrincipal().toString()));

        add(form);
    }


}
