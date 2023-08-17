package myprojects.hltvdota.Controllers;

import myprojects.hltvdota.Entities.Tournament;
import myprojects.hltvdota.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class EventController {
    final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public String showAllEvents(ModelMap model) {
        model.put("events",eventRepository.findAll());
        return "eventList";
    }
    @GetMapping("/add-event")
    public String addEvent() {
        return "eventAddPage";
    }
    @PostMapping("/add-event")
    public String addEvent(@RequestParam("name") String eventName,
                           @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date startDate,
                           @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date endDate) {
        Tournament tournament = new Tournament();
        tournament.setName(eventName);
        tournament.setStartDate(startDate);
        tournament.setEndDate(endDate);
        eventRepository.save(tournament);
        return "redirect:/events";
    }
}
