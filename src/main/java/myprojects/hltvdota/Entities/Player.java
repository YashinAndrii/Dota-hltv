package myprojects.hltvdota.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "Players")
public class Player {
    private String fname;
    private String lname;
    @Id
    private String nickName;
    @ManyToOne
    @JoinColumn(name = "team_name")
    private Team team;
    private String photo;

    public Player() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        if(this.team!=team){
            this.team = team;
        }
    }

    public Player(String fname, String lname, String nickName) {
        this.fname = fname;
        this.lname = lname;
        this.nickName = nickName;
        this.photo = "nonplayer.png";
    }

    public Player(String fname, String lname, String nickName, String photo) {
        this.fname = fname;
        this.lname = lname;
        this.nickName = nickName;
        this.photo = photo;
    }

    /*@Override
    public String toString() {
        return "Player{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", nickName='" + nickName + '\'' +
                ", team=" + team +
                '}';
    }*/

}
