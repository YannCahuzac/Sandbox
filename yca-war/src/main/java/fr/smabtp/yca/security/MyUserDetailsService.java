package fr.smabtp.yca.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import fr.smabtp.jndi.GetEJB;

public class MyUserDetailsService implements UserDetailsService {

	final static Logger logger = Logger.getLogger(MyUserDetailsService.class
			.getName());

	@Autowired
	private GetEJB getEJB;

	public UserDetails loadUserByUsername(String username) {
		// On passe ici par l'EJB car c'est lui qui accède à la base de donnée:
		return getEJB.loadUserByUsername(username);
	}
}