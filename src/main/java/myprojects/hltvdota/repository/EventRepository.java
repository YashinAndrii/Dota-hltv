package myprojects.hltvdota.repository;

import myprojects.hltvdota.Entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Tournament,Long> {
}
