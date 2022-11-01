package comunication.service;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;

import comunication.model.Operator;
import comunication.repository.OperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import comunication.exception.CustomException;
import comunication.model.AppUser;
import comunication.repository.UserRepository;
import comunication.configuration.security.JwtTokenProvider;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final OperatorRepository operatorRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;
  private final AuthenticationManager authenticationManager;

  public String signin(String email, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
      return jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getAppUserRoles());
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public String signup(AppUser appUser) {
    if (!userRepository.existsByUsername(appUser.getUsername())) {
      appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
      userRepository.save(appUser);
      return jwtTokenProvider.createToken(appUser.getUsername(), appUser.getAppUserRoles());
    } else {
      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }
  public AppUser update(String actualEmail, AppUser appUser){
    Optional<AppUser> registered= Optional.ofNullable(userRepository.findByEmail(actualEmail));
    AppUser entity = registered.get();
    entity.setEmail(appUser.getEmail());
    entity.setPassword(passwordEncoder.encode(appUser.getPassword()));
    Optional<Operator> registered2 = operatorRepository.findByEmail(actualEmail);
    Operator operatorUpdated = registered2.get();
    operatorUpdated.setEmail(appUser.getEmail());
    operatorRepository.save(operatorUpdated);
    return userRepository.save(entity);
  }
  public void delete(String username) {
    userRepository.deleteByUsername(username);
  }

}
