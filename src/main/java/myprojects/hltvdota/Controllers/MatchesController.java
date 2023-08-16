package myprojects.hltvdota.Controllers;
import myprojects.hltvdota.Entities.Match;
import myprojects.hltvdota.Entities.Player;
import myprojects.hltvdota.Entities.Team;
import myprojects.hltvdota.repository.MatchRepository;
import myprojects.hltvdota.repository.PlayerRepository;
import myprojects.hltvdota.repository.TeamRepositoryJPA;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MatchesController {
    private final TeamRepositoryJPA teamRepository;
    private final MatchRepository matchRepository;

    public MatchesController(TeamRepositoryJPA teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/matches";
    }

    @GetMapping("/matches")
    public String showMatches(ModelMap model) {
        LocalDateTime currentTime = LocalDateTime.now();
        Date currentDate = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());
        model.put("matches",matchRepository.findAllByOrderByTimeAsc());
        model.addAttribute("currentTime", currentDate);
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
        if(teamRepository.findByName(team1) != null && teamRepository.findByName(team2) != null && !team1.equals(team2)) {
            match.setTeam1(teamRepository.findByName(team1));
            match.setTeam2(teamRepository.findByName(team2));
            matchRepository.save(match);
        }
        return "redirect:/matches";
    }

    @GetMapping("/update-match")
    public String editMatch(@RequestParam("id") Long matchId, ModelMap model) {
        Match matchToEdit = matchRepository.findById(matchId).orElse(null);

        if (matchToEdit == null) {
            return "redirect:/matches";
        }

        model.addAttribute("match", matchToEdit);
        return "matchUpdate"; // Возвращаем имя JSP-страницы для редактирования матча
    }


    @PostMapping("/update-match")
    public String updateMatch(@RequestParam("id") Long matchId,
                              @RequestParam("score") String score,
                              @RequestParam("time") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date time) {
        Match match = matchRepository.findById(matchId).orElseThrow(() -> new IllegalArgumentException("Invalid match ID"));
        String[] scoreArray = score.split("-");
        if (scoreArray.length == 2) {
            match.setScore(new int[]{Integer.parseInt(scoreArray[0].trim()), Integer.parseInt(scoreArray[1].trim())});
        }
        match.setTime(time);
        matchRepository.save(match);
        return "redirect:/matches";
    }
    @Transactional
    @GetMapping("/delete-match")
    public String deleteMatch(@RequestParam Long id){
        matchRepository.deleteById(id);
        return "redirect:/matches";
    }
}
