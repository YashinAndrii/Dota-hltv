package myprojects.hltvdota.Controllers;
import myprojects.hltvdota.Entities.Match;
import myprojects.hltvdota.Entities.Player;
import myprojects.hltvdota.Entities.Team;
import myprojects.hltvdota.repository.MatchRepository;
import myprojects.hltvdota.repository.PlayerRepository;
import myprojects.hltvdota.repository.TeamRepositoryJPA;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MatchesController {

    //private InMemoryTeamRepository repository;
    private final TeamRepositoryJPA teamRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;


    public MatchesController(TeamRepositoryJPA teamRepository, PlayerRepository playerRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/matches";
    }

    @GetMapping("/matches")
    public String showMatches(ModelMap model) {
        model.put("matches",matchRepository.findAll());
        return "matchList";
    }
    @GetMapping("/add-match")
    public String addMatch() {
        return "matchAddPage";
    }

    @PostMapping("/add-match")
    public String addMatch(@RequestParam("team1") String team1,
                           @RequestParam("team2") String team2) {
        Match match = new Match();
        match.setTeam1(teamRepository.findByName(team1));
        match.setTeam2(teamRepository.findByName(team2));
        matchRepository.save(match);
        return "redirect:/matches";
    }

    @GetMapping("/teams")
    public String showTeams(ModelMap model) {
        model.put("team",teamRepository.findAll());
        return "teamList";
    }
    @GetMapping("/add-team")
    public String addTeam(ModelMap model) {
        Team team = new Team(new ArrayList<>(),"");
        model.put("team",team);
        return "teamAddPage";
    }

    @GetMapping("/players")
    public String showPlayer(ModelMap model) {
        Player player = new Player("new","new","new");
        model.put("player",player);
        return "playerShow";
    }

    @PostMapping("/add-team")
    public String addTeam(@RequestParam("teamName") String teamName, @RequestParam("teamLogo") String teamLogo,
                          @RequestParam("playerName1") String playerName1,
                          @RequestParam("playerNickname1") String playerNickname1,
                          @RequestParam("playerSurname1") String playerSurname1,
                          @RequestParam("playerName2") String playerName2,
                          @RequestParam("playerNickname2") String playerNickname2,
                          @RequestParam("playerSurname2") String playerSurname2,
                          @RequestParam("playerName3") String playerName3,
                          @RequestParam("playerNickname3") String playerNickname3,
                          @RequestParam("playerSurname3") String playerSurname3,
                          @RequestParam("playerName4") String playerName4,
                          @RequestParam("playerNickname4") String playerNickname4,
                          @RequestParam("playerSurname4") String playerSurname4,
                          @RequestParam("playerName5") String playerName5,
                          @RequestParam("playerNickname5") String playerNickname5,
                          @RequestParam("playerSurname5") String playerSurname5) {
        Team team;

        if (teamLogo.length() != 0) {
            team = new Team(teamName, teamLogo);
        } else {
            team = new Team(teamName);
        }

        teamRepository.save(team);

        Player player1 = new Player(playerName1, playerNickname1, playerSurname1);
        Player player2 = new Player(playerName2, playerNickname2, playerSurname2);
        Player player3 = new Player(playerName3, playerNickname3, playerSurname3);
        Player player4 = new Player(playerName4, playerNickname4, playerSurname4);
        Player player5 = new Player(playerName5, playerNickname5, playerSurname5);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);

        // Установка связи между игроками и командой
        player1.setTeam(team);
        player2.setTeam(team);
        player3.setTeam(team);
        player4.setTeam(team);
        player5.setTeam(team);

        // Сохранение игроков
        playerRepository.saveAll(players);

        // Установка связи между командой и игроками
        team.setPlayers(players);
        teamRepository.save(team);

        return "redirect:/teams";
    }

    @GetMapping("/logo")
    public String showLogo() {
        return "matches";
    }

    @Transactional
    @GetMapping("/delete")
    public String deleteTeam(@RequestParam String name){
        //team.getPlayers().forEach(p -> p.setTeam(null));
        var players = playerRepository.findByTeamName(name);
        players.forEach(p -> p.setTeam(null));
        playerRepository.saveAll(players);
        teamRepository.deleteByName(name);
        return "redirect:/teams";
    }

    @GetMapping("/{nickName}")
    public String showPlayer(@PathVariable("nickName") String nickName, ModelMap model) {
        Player player = playerRepository.findByNickName(nickName);
        if (player != null) {
            model.put("player", player);
            return "playerShow";
        } else {
            return "redirect:/teams"; // Если игрок не найден, перенаправляем на страницу со списком игроков
        }
    }
}
