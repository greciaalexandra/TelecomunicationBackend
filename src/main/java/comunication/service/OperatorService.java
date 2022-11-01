package comunication.service;

import comunication.model.Operator;

import java.util.List;
import java.util.Optional;

public interface OperatorService {
    List<Operator> findAll();
    Optional<Operator> findByEmail(String email);
    Optional<Operator> findById(Integer id);
    Operator save(Operator operator);
    Operator update(Operator operator, Integer id);
    String delete(Integer id);
}
