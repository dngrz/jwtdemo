package pe.csweb.pruebas.jwtdemo.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		//TODO Lógica para obteneer el usuario desde la DB
		
		return new User("admin", "admin123", new ArrayList());
	}

}
