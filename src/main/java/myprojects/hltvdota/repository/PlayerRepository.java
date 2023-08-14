package myprojects.hltvdota.repository;

import myprojects.hltvdota.Entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,String> {
    Player findByNickName(String nickName);
    List<Player> findByTeamName(String teamName);
}
