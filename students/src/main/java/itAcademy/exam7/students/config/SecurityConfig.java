package itAcademy.exam7.students.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/student/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/student/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/student/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/course/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and().logout().and().formLogin();
    }
}
