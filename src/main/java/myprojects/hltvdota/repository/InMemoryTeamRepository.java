package myprojects.hltvdota.repository;

import myprojects.hltvdota.Entities.Player;
import myprojects.hltvdota.Entities.Team;
import myprojects.hltvdota.repository.TeamRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryTeamRepository implements TeamRepository {
    private List<Team> teams = new ArrayList<>(List.of(new Team(List.of(new Player("a","a","a"),
                    new Player("a","a","a"),
                    new Player("a","a","a"),
                    new Player("a","a","a"),
                    new Player("a","a","a")
            ),"Natus Vincere","navi.png"),
            new Team(List.of(new Player("b","b","b"),
                    new Player("b","b","b"),
                    new Player("b","b","b"),
                    new Player("b","b","b"),
                    new Player("b","b","b")
            ),"Gaimin Gladiators","gladiators.png"),
            new Team(List.of(new Player("c","c","c"),
                    new Player("c","c","c"),
                    new Player("c","c","c"),
                    new Player("c","c","c"),
                    new Player("c","c","c")
            ),"Team Liquid", "liquid.jpg")));

    @Override
    public void addTeam(Team team) {
        if(teams.stream().anyMatch(t -> t.getName().equalsIgnoreCase(team.getName()))){
            return;
        }
        teams.add(team);
    }

    @Override
    public void deleteTeam(String name) {
        teams.removeIf(team -> team.getName().equals(name));
    }



    @Override
    public void updateTeam(Team team) {
        int index = getIndexByName(team.getName());
        if (index != -1) {
            teams.set(index, team);
        }
    }

    @Override
    public Team getTeamByName(String name) {
        return teams.stream()
                .filter(team -> team.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Team> getAllTeams() {
        return new ArrayList<>(teams);
    }

    private int getIndexByName(String name) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
