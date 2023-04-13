package pe.edu.sistemas.sisbusqdoc.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisbusqdoc.entity.UserRole;
import pe.edu.sistemas.sisbusqdoc.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService{
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//pe.edu.sistemas.sisbusqdoc.entity.Persona user = new Persona();
		//user.setUsername("kochi");
		//user.setPassword("8c416c2812ed806acb66520086da8972");
		//HashSet s = new HashSet<UserRole>();
		//s.add(new UserRole(new TipoUsuario(1,"ba"),user));
		//user.setUserRoles( s);
		pe.edu.sistemas.sisbusqdoc.entity.Persona user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRoles());
		return buildUser(user, authorities);
	}

	private User buildUser(pe.edu.sistemas.sisbusqdoc.entity.Persona user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);	
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for(UserRole userRole: userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getTipoUsuario().getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
}