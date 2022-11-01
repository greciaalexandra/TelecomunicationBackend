package comunication.service.impl;

import comunication.model.Client;
import comunication.model.SpeechDto;
import comunication.repository.ClientRepository;
import comunication.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client updateSpeechAndKeyWords(Integer id, SpeechDto speechDto) {
        Optional<Client> registered = clientRepository.findById(id);
        Client clientUpdated = registered.get();
        clientUpdated.setSpeech(speechDto.getSpeech());
        clientUpdated.setKey(speechDto.getKeys());
        return clientRepository.save(clientUpdated);
    }

    @Override
    public List<Client> findAllByKeys(List<String> keys) {
        return clientRepository.findDistinctByKeyInIgnoreCase(keys);
    }
}
