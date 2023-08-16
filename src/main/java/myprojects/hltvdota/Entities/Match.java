package myprojects.hltvdota.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "matches")
public class Match {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Team team1;
    @ManyToOne
    private Team team2;
    @ManyToOne
    private Tournament tournament;
    //private LocalDateTime time;
    private Date time;
    private int[] score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int[] getScore() {
        return score;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void setScore(int[] score) {
        this.score = score;
    }
}
