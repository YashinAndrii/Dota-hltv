package myprojects.hltvdota.repository;

import myprojects.hltvdota.Entities.Player;
import myprojects.hltvdota.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepositoryJPA extends JpaRepository <Team,String> {
    Team findByName(String name);
    void deleteByName(String name);
    List<Team> findAll();
}
