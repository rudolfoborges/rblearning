package rblearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rblearning.models.Lession;

public interface LessionRepository extends JpaRepository<Lession, Long> {

	
	
}
