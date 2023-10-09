package tdhellorest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdhellorest.domain.Event;
import tdhellorest.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EvenRestController {
 @Autowired
    private EventService eventService;
 @GetMapping("/all")
    public List<Event>findAll(){
     return eventService.findAll();
 }
@GetMapping("/{id}")
    public Event findById(@PathVariable Integer id){
     return eventService.findById(id);
}
@PostMapping("/add")
    public Event add(@RequestBody Event event){
    return  eventService.add(event);
}
@DeleteMapping("/delete/{id}")
    public Event delete (@PathVariable Integer id) {
     return eventService.delete(id);
}
@PutMapping("/update")
    public Event update(@RequestBody Event event){
     return eventService.update(event);
}

}
