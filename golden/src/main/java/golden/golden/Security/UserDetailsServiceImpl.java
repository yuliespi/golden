package golden.golden.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import golden.golden.Models.Empleado.Empleado;
import golden.golden.Models.Empleado.IEmpleado;
import golden.golden.Models.Rol.Roles;
@Service
public class UserDetailsServiceImpl implements  UserDetailsService{

    @Autowired
    private IEmpleado empleadoService;

    @Override
    public UserDetails loadUserByUsername(String correoEmpleado) throws UsernameNotFoundException {
        Empleado empleado = empleadoService.findByCorreoEmpleado(correoEmpleado);

        UserBuilder builder = null;

        if(empleado != null) {
            builder = User.withUsername(correoEmpleado);
            builder.disabled(false);
            builder.password(empleado.getContrasenaEmpleado());
            builder.authorities(getAuthorities(empleado));
        }
        else {
            throw new UsernameNotFoundException("Empleado no encontrado");
        }
        return builder.build();
    }

    

    private Collection<GrantedAuthority> getAuthorities(Empleado emple){
        List <Roles> empleGroups = emple.getRoles();
        Collection<GrantedAuthority> authorities = new ArrayList<>(empleGroups.size());
        for(Roles empleGroup : empleGroups){
            authorities.add(new SimpleGrantedAuthority(empleGroup.getNombreRol().toUpperCase()));
        }

        return authorities;
    }
}