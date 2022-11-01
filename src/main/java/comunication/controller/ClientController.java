package comunication.controller;

import comunication.model.Client;
import comunication.model.SpeechDto;
import comunication.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> findAll(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.findById(id));
    }
    @PutMapping("/speech/{id}")
    public ResponseEntity<Client> assignSpeech(@PathVariable Integer id, @RequestBody SpeechDto speechDto) {
        return ResponseEntity.ok(clientService.updateSpeechAndKeyWords(id,speechDto));
    }
    @GetMapping("/list/keys")
    public ResponseEntity<List<Client>> findAllByKeys(@RequestBody List<String> keys){
        return ResponseEntity.ok(clientService.findAllByKeys(keys));
    }
}
