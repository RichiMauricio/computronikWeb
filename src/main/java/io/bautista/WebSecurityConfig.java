package io.bautista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Alexis on 23/12/2016.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()

                .and()
                .csrf()
                .ignoringAntMatchers("/api/**")
               /* .antMatchers("/faces/v/s/clientes/adminClientes.xhtml").hasRole("ADMIN", "ROLE_USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/faces/v/login.xhtml")
                .loginProcessingUrl("/appLogin")
                .defaultSuccessUrl("/faces/v/s/loginSuccess.xhtml", true)
                .failureUrl(Ctns.LOGIN_URL + "?error=hasError")
                .failureHandler(customAuthenticationHandler)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/faces/index.xhtml")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/faces/v/denied.xhtml")*/;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                /*.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
                .and()*/
                .inMemoryAuthentication()
                .withUser("enki@banquito.com").password("enki").roles("ADMIN").and();
    }

}
