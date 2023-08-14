package myprojects.hltvdota.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Teams")
public class Team {
    @OneToMany(mappedBy = "team")
    private List<Player> players;
    @Id
    private String name;
    private String logo;
    private long points;

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public Team(List<Player> playerList, String name) {
        this.players = playerList;
        this.name = name;
        this.logo = "default.png";
        playerList.forEach(player -> player.setTeam(this));
    }
    public Team(){
        this.logo = "default.png";
    }
    public Team(List<Player> playerList, String name, String logo) {
        this.players = playerList;
        this.name = name;
        this.logo = logo;
        playerList.forEach(player -> player.setTeam(this));
    }
    public Team(String name, String logo) {
        this.logo = logo;
        this.name = name;
    }
    public Team(String name) {
        this.logo = "default.png";
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> playerList) {
        this.players = playerList;
        playerList.forEach(player -> player.setTeam(this));
    }

    public String getName() {
        return name;
    }
    public String getLogo() {
        return logo;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /*@Override
    public String toString() {
        return "Team "+ name + "{" +
                "playerList=" + players +
                '}';
    }*/
}
