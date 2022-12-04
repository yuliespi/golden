package golden.golden.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/","/auth/**","/public/**","/css/**","/js/**","/img/**","/empleado/**")
        .permitAll().anyRequest().authenticated()
        // .antMatchers("/index")
        // .permitAll() 

        // .antMatchers("/menu/*","/actividad/tablaA","/bitacora/tablaB","/categoria/tablaCT","/implemento/tablaI")
        // .hasAnyAuthority("GERENTE ADMIN","COACH")

        // .antMatchers("/actividad/formA","/bitacora/formB","/cargo/formC","/categoria/formCT","/empleado/formE","/implemento/formI")
        // .hasAnyAuthority("COACH")

        .and()
            .formLogin().loginPage("/login")
            .defaultSuccessUrl("/menu",true)
            .failureUrl("/login?error=true")
            .loginProcessingUrl("/login").permitAll()
        .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }
}