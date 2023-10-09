package tdhellorest.repository;


import org.springframework.stereotype.Repository;
import tdhellorest.domain.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EventRepository {
    List<Event> events = new ArrayList<>(Arrays.asList(
            new Event("Violin Concert", "Paris"),
            new Event("Rock Concert", "London"),
            new Event("Ice Show", "Berlin"),
            new Event("Dance Show", "Milan"),
            new Event("Fire Show", "Dresden")

    ));


    public List<Event> findAll() {
        return events;
    }

    public Event save(Event event) {
        if (event.getId() == null) {
            // add new Event
            Event newEvent = new Event(event.getName(), event.getCity());
            events.add(newEvent);
            return newEvent;
        } else {
            // update Event by ID
            Event updEvent = findById(event.getId());
            if (updEvent != null) {
                updEvent.setName(event.getName());
                updEvent.setCity(event.getCity());
                return updEvent;
            }
            return null;
        }
    }

        public Event findById ( int id){
            for (Event event : events) {
                if (event.getId() == id) {
                    return event;
                }
            }
            return null;
        }
    public Event remove ( int id){
        Event removeEvent = findById(id);
        events.remove(removeEvent);
        return removeEvent;
    }
}
