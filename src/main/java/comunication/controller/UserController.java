package comunication.controller;

import lombok.RequiredArgsConstructor;
import comunication.model.AppUser;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import comunication.dto.UserDataDTO;
import comunication.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {

  private final UserService userService;
  private final ModelMapper modelMapper;

  @GetMapping("/signin")
  public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
    return ResponseEntity.ok(userService.signin(email, password));
  }

  @PostMapping("/signup")
  public String signup(@RequestBody UserDataDTO user) {
    return userService.signup(modelMapper.map(user, AppUser.class));
  }

  @PutMapping("/update/{email}")
  public ResponseEntity<AppUser> signup(@RequestBody AppUser appUser, @PathVariable String email) {
    return ResponseEntity.ok(userService.update(email,appUser));
  }

  @DeleteMapping(value = "/{username}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public String delete(@PathVariable String username) {
    userService.delete(username);
    return username;
  }

}
