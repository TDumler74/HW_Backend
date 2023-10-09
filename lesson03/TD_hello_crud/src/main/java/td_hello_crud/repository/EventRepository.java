package td_hello_crud.repository;

import org.springframework.stereotype.Repository;
import td_hello_crud.domain.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EventRepository {
    List<Event> events = new ArrayList<>(Arrays.asList(
         new Event("Violin Concert","Paris"),
            new Event("Rock Concert","London"),
            new Event("Ice Show","Berlin")
    ));


    public List<Event> findAll() {
        return events;
    }

    public void save(Event event) {
        events.add(event);
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
