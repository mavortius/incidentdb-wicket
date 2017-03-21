package br.com.proinde.incidentdb.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SecurityConfig {}

    /*@Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("").permitAll()
                .and()
                .logout()
                .permitAll();
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, enabled FROM [user] WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT u.username, r.authority  FROM role r INNER JOIN user_role u_r ON r.id = u_r.role_id INNER JOIN [user] u ON u.id = u_r.user_id WHERE u.username = ?");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
} */
