package comunication.service.impl;

import comunication.model.Operator;
import comunication.repository.OperatorRepository;
import comunication.service.OperatorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository operatorRepository;

    public OperatorServiceImpl(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Operator> findAll() {
        return operatorRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Optional<Operator> findByEmail(String email) {
        return operatorRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Operator> findById(Integer id) {
        return operatorRepository.findById(id);
    }

    @Override
    public Operator save(Operator operator) {
        return operatorRepository.save(operator);
    }

    @Override
    public Operator update(Operator operator, Integer id) {
        Optional<Operator> registered = operatorRepository.findById(id);
        Operator operatorUpdated = registered.get();
        operatorUpdated.setName(operator.getName());
        operatorUpdated.setLastName(operator.getLastName());
        operatorUpdated.setDni(operator.getDni());
        operatorUpdated.setPhone(operator.getPhone());
        operatorUpdated.setType(operator.getType());
        operatorUpdated.setEmail(operator.getEmail());
        operatorUpdated.setKeyWordList(operator.getKeyWordList());
        return operatorRepository.save(operatorUpdated);
    }

    @Override
    public String delete(Integer id) {
        operatorRepository.deleteById(id);
        return "Id eliminiado"+id;
    }
}
