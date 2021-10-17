package pe.csweb.pruebas.jwtdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.csweb.pruebas.jwtdemo.model.JwtRequest;
import pe.csweb.pruebas.jwtdemo.model.JwtResponse;
import pe.csweb.pruebas.jwtdemo.service.UserService;
import pe.csweb.pruebas.jwtdemo.util.JWTUtil;

@RestController
public class HomeController {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String inicio() {
		
		return "Bienvenido al Sistema";
		
	}
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate (@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUsername(), 
							jwtRequest.getPassword()
					)
			);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID CREDENTIALS", e);
		}
		
		final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
		
		final String token = jwtUtil.generateToken(userDetails);
				
		return new JwtResponse(token);
		
	}

}
