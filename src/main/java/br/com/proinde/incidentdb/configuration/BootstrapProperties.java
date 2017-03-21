package br.com.proinde.incidentdb.configuration;

import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.themes.markup.html.bootswatch.BootswatchTheme;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static br.com.proinde.incidentdb.configuration.BootstrapProperties.PROPERTY_PREFIX;

@ConfigurationProperties(prefix = PROPERTY_PREFIX)
public class BootstrapProperties extends BootstrapSettings {

    public static final String PROPERTY_PREFIX = "wicket.external.agilcoders.bootstrap";

    private boolean enabled = true;

    private BootswatchTheme theme = BootswatchTheme.Sandstone;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public BootswatchTheme getTheme() {
        return theme;
    }

    public void setTheme(BootswatchTheme theme) {
        this.theme = theme;
    }
}
