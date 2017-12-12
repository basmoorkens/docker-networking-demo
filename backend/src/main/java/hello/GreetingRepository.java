package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

	List<Greeting> findByName(String name);
}
