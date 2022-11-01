package comunication.configuration.security;

import lombok.RequiredArgsConstructor;
import comunication.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import comunication.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    final AppUser appUser = userRepository.findByEmail(email);

    if (appUser == null) {
      throw new UsernameNotFoundException("Email '" + email + "' not found");
    }

    return org.springframework.security.core.userdetails.User//
        .withUsername(appUser.getUsername())//
        .password(appUser.getPassword())//
        .authorities(appUser.getAppUserRoles())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

}
