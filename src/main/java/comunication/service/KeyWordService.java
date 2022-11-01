package comunication.service;

import comunication.model.KeyWord;

import java.util.List;
import java.util.Optional;

public interface KeyWordService {
    List<KeyWord> findAll();
    Optional<KeyWord> findById(Integer id);
    KeyWord save(KeyWord keyWord);
    KeyWord update(KeyWord keyWord, Integer id);
    String delete(Integer id);
}
