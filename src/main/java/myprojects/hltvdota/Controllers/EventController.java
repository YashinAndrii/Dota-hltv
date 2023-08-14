package myprojects.hltvdota.Controllers;

import myprojects.hltvdota.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
}
