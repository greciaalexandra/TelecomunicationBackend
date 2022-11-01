package comunication.service;

import comunication.model.Client;
import comunication.model.SpeechDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(Integer id);
    Client updateSpeechAndKeyWords(Integer id, SpeechDto speechDto);
    List<Client> findAllByKeys(List<String> keys);
}
