package rblearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rblearning.models.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {}
