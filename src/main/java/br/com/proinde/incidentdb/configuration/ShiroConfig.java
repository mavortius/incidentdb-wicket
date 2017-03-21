package br.com.proinde.incidentdb.configuration;

import br.com.proinde.incidentdb.ShiroWebSession;
import br.com.proinde.incidentdb.domain.Role;
import br.com.proinde.incidentdb.domain.User;
import br.com.proinde.incidentdb.security.BCryptPasswordService;
import br.com.proinde.incidentdb.view.page.LoginPage;
import br.com.proinde.incidentdb.view.page.error.AccessDeniedPage;
import com.giffing.wicket.spring.boot.context.extensions.ApplicationInitExtension;
import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;
import com.giffing.wicket.spring.boot.context.security.AuthenticatedWebSessionConfig;
import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.giffing.wicket.spring.boot.starter.app.WicketBootWebApplication;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.event.EventBus;
import org.apache.shiro.event.EventBusAware;
import org.apache.shiro.event.Subscribe;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.wicketstuff.shiro.annotation.AnnotationsShiroAuthorizationStrategy;
import org.wicketstuff.shiro.authz.ShiroUnauthorizedComponentListener;

import javax.sql.DataSource;

@ApplicationInitExtension
@ConditionalOnProperty(prefix = ShiroProperties.PROPERTY_PREFIX, value = "enabled", matchIfMissing = true)
@ConditionalOnClass(ShiroConfig.class)
@ConditionalOnMissingBean(WicketBootWebApplication.class)
@EnableConfigurationProperties(ShiroProperties.class)
public class ShiroConfig implements WicketApplicationInitConfiguration {

    @Autowired
    DataSource dataSource;

    @Autowired
    private ShiroProperties properties;

    @Bean
    public WicketBootSecuredWebApplication wicketBootWebApplication() {
        return new WicketBootSecuredWebApplication();
    }

    @Bean
    public AuthenticatedWebSessionConfig authenticatedWebSessionConfig(){
        return new AuthenticatedWebSessionConfig() {
            @Override
            public Class<? extends AbstractAuthenticatedWebSession> getAuthenticatedWebSessionClass() {
                return ShiroWebSession.class;
            }
        };
    }

    @Bean
    public Realm realm() {
        JdbcRealm realm = new JdbcRealm();
        PasswordMatcher passwordMatcher = new PasswordMatcher();

        passwordMatcher.setPasswordService(new BCryptPasswordService());
        realm.setCredentialsMatcher(passwordMatcher);
        realm.setDataSource(dataSource);
        realm.setAuthenticationQuery(properties.getAuthenticationQuery());
        realm.setUserRolesQuery(properties.getUserRolesQuery());
        realm.setCachingEnabled(true);

        return realm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        return new DefaultShiroFilterChainDefinition();
    }

    @Bean
    public EventBusAwareObject eventBusAwareObject() {
        return new EventBusAwareObject();
    }

    @Bean
    public SubscribedListener subscribedListener() {
        return new SubscribedListener();
    }

    @Override
    public void init(WebApplication webApplication) {
        AnnotationsShiroAuthorizationStrategy authz = new AnnotationsShiroAuthorizationStrategy();

        webApplication.getSecuritySettings().setAuthorizationStrategy(authz);
        webApplication.getSecuritySettings().setUnauthorizedComponentInstantiationListener(
                new ShiroUnauthorizedComponentListener(LoginPage.class, AccessDeniedPage.class, authz)
        );
    }

    public static class EventBusAwareObject implements EventBusAware {
        private EventBus eventBus;

        public void setEventBus(EventBus bus) {
            this.eventBus = bus;
        }
        public EventBus getEventBus() {
            return eventBus;
        }
    }

    public static class SubscribedListener {
        @Subscribe
        public void onEvent(Object object) { }
    }
}
