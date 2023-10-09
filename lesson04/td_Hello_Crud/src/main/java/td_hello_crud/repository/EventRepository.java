package td_hello_crud.repository;

import org.springframework.stereotype.Repository;
import td_hello_crud.domain.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EventRepository {
    List<Event> events = new ArrayList<>(Arrays.asList(
         new Event("Violin Concert","Paris",59.95),
            new Event("Rock Concert","London",99.99),
            new Event("Ice Show","Berlin",110.99)
    ));


    public List<Event> findAll() {
        return events;
    }
    public void save( Event event) {
        events.add(event);
    }

    public void save(int id, Event event ) {
        Event updEvent = events.get(id);
        updEvent.setName(event.getName());
        updEvent.setCity(event.getCity());
        updEvent.setPrice(event.getPrice());

    }

    public Event findById(int id) {
        return events.get(id);
    }

    public void remove(int id) {
        events.remove(id);
    }

    public String[] findAllCities() {
        String[] cities;
        cities = new String[events.size()];
        for (int i = 0; i < events.size(); i++) {
            cities[i] = events.get(i).getCity();
        }
        return cities;
    }

}
