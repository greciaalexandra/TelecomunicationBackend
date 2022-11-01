package comunication.controller;

import comunication.model.Operator;
import comunication.service.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operators")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class OperatorController {
    private final OperatorService operatorService;

    @GetMapping
    public ResponseEntity<List<Operator>> findAll(){
        return ResponseEntity.ok(operatorService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Operator>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(operatorService.findById(id));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Operator>> findById(@PathVariable String email){
        return ResponseEntity.ok(operatorService.findByEmail(email));
    }
    @PostMapping
    public ResponseEntity<Operator> save(@RequestBody Operator operator){
        return ResponseEntity.ok(operatorService.save(operator));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Operator> update(@RequestBody Operator operator,@PathVariable Integer id){
        return ResponseEntity.ok(operatorService.update(operator,id));
    }
}
