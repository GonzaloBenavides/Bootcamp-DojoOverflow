package cl.gonzalobenavides.dojooverflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.gonzalobenavides.dojooverflow.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
}
