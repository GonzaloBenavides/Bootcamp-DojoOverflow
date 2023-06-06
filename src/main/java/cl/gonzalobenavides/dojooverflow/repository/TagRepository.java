package cl.gonzalobenavides.dojooverflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.gonzalobenavides.dojooverflow.model.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	Optional<Tag> findByTag(String tag);
}
