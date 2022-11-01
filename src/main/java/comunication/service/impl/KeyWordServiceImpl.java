package comunication.service.impl;

import comunication.model.KeyWord;
import comunication.repository.KeyWordRepository;
import comunication.service.KeyWordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeyWordServiceImpl implements KeyWordService{

    private final KeyWordRepository keyWordRepository;

    public KeyWordServiceImpl(KeyWordRepository keyWordRepository) {
        this.keyWordRepository = keyWordRepository;
    }

    @Override
    public List<KeyWord> findAll() {
        return keyWordRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Optional<KeyWord> findById(Integer id) {
        return keyWordRepository.findById(id);
    }

    @Override
    public KeyWord save(KeyWord keyWord) {
        return keyWordRepository.save(keyWord);
    }
    @Override
    public KeyWord update(KeyWord keyWord, Integer id) {
        Optional<KeyWord> registered = keyWordRepository.findById(id);
        KeyWord optional = registered.get();
        optional.setActive(keyWord.getActive());
        optional.setName(keyWord.getName());
        return keyWordRepository.save(optional);
    }

    @Override
    public String delete(Integer id) {
        keyWordRepository.deleteById(id);
        return "Id eliminado: "+id;
    }
}
