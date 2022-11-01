package comunication.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import comunication.model.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

  boolean existsByUsername(String username);

  AppUser findByEmail(String email);

  @Transactional
  void deleteByUsername(String username);

}
