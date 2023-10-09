package td_hello_crud.domain;

public class Event {
    private String name;
    private String city;
    private double price;

    public Event() {
    }

    public Event(String name, String city, Double price) {
        this.name = name;
        this.city = city;
        this.price = price;
    }

    public Event(String name, String city) {
        this.name = name;
        this.city = city;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
