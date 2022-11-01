package comunication.repository;

import comunication.model.KeyWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyWordRepository extends JpaRepository<KeyWord,Integer> {
    List<KeyWord> findAllByOrderByIdAsc();
}
