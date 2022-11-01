package comunication.controller;

import comunication.model.KeyWord;
import comunication.service.KeyWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/keys")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class KeyWordController {
    private final KeyWordService KeyWordService;

    @GetMapping
    public ResponseEntity<List<KeyWord>> findAll(){
        return ResponseEntity.ok(KeyWordService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<KeyWord>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(KeyWordService.findById(id));
    }
    @PostMapping
    public ResponseEntity<KeyWord> save(@RequestBody KeyWord keyWord){
        return ResponseEntity.ok(KeyWordService.save(keyWord));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KeyWord> update(@RequestBody KeyWord keyWord,@PathVariable Integer id){
        return ResponseEntity.ok(KeyWordService.update(keyWord,id));
    }
}
