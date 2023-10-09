package td_hello_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import td_hello_crud.domain.Event;
import td_hello_crud.service.EventService;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public String listEvents(Model model){
        List<Event> events = eventService.findAll();
        model.addAttribute("events",events);
        return "listView";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        return "addEvent";
    }
    @PostMapping("/add")
    public String addPost() {
        return null;
    }
    @GetMapping("/cities")
    public String listCities(Model model){
        String [] cities = eventService.findAllCities();
        model.addAttribute("cities",cities);
        return "citiesView";
    }
}
