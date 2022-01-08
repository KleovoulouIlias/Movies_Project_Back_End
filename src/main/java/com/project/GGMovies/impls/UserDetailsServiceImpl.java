package com.project.GGMovies.impls;

import com.project.GGMovies.models.User;
import com.project.GGMovies.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String  email) throws UsernameNotFoundException {
	    User user = userRepository.getUserByEmail(email);
				
	    return UserDetailsImpl.build(user);
	}
    
}
