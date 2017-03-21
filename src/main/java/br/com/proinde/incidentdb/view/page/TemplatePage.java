package br.com.proinde.incidentdb.view.page;

import br.com.proinde.incidentdb.security.RoleAuthority;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.GlyphIconType;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarComponents;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.wicketstuff.shiro.ShiroSubjectModel;
import org.wicketstuff.shiro.page.LogoutPage;


public abstract class TemplatePage extends WebPage {

    public TemplatePage() {

        add(newNavbar("navbar"));
    }

    private Navbar newNavbar(String markupId) {
        Navbar navbar = new Navbar(markupId);

        navbar.setPosition(Navbar.Position.TOP);
        navbar.setInverted(false);
        navbar.fluid();
        navbar.setBrandName(Model.of("Proinde Incident Database"));
        navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT,
                                new NavbarButton<Void>(AdministrationPage.class, Model.of("Other"))
                                        .setVisible(new ShiroSubjectModel().getObject().hasRole(RoleAuthority.ADMIN))));
        navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.RIGHT,
                                new NavbarButton<Void>(LogoutPage.class, Model.of("Exit")).setIconType(GlyphIconType.logout)));

        return navbar;
    }


}
