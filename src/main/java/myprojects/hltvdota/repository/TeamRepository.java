package myprojects.hltvdota.repository;

import myprojects.hltvdota.Entities.Team;

import java.util.List;

public interface TeamRepository {
    void addTeam(Team team);
    void deleteTeam(String name);
    void updateTeam(Team team);
    Team getTeamByName(String name);

    List<Team> getAllTeams();
}
