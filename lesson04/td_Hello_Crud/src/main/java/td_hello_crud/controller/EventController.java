package td_hello_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String addEventForm(Model model){
        model.addAttribute("event",new Event());
        return "addFormEvent";

    }
    @PostMapping("/add")
    public String addEvent(Model model, @ModelAttribute("event")Event event) {
            String name = event.getName();
            String city = event.getCity();
            double price = event.getPrice();

            //TODO check name & city
        if (!name.isEmpty()&& !city.isEmpty() ) {
            eventService.add(event);
            return "redirect:/";
        }
        model.addAttribute("errorMsg","Event Name & City  is required!");
        return "addFormEvent";

    }
    @GetMapping("/update/{id}")
    public String updateEventForm(Model model, @PathVariable Integer id) {
        Event event = eventService.findById(id);
        model.addAttribute("event", event);
        model.addAttribute("id", id);
        return "updateEvent";
    }

    @PutMapping("/update/{id}")
    public String updateEvent(Model model, @ModelAttribute("event") Event event, @PathVariable Integer id) {
        String name = event.getName();
        String city = event.getCity();
        if (!name.isEmpty() && !city.isEmpty() ) {
            eventService.update(id, event);
            return "redirect:/";
        }

        model.addAttribute("errorMsg", "Event Name & City is required!");
        return "updateEvent";
    }

    @DeleteMapping("/delete")
    public String deleteEvent(Integer id) {
        eventService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/cities")
    public String listCities(Model model){
        String [] cities = eventService.findAllCities();
        model.addAttribute("cities",cities);
        return "citiesView";
    }
}
