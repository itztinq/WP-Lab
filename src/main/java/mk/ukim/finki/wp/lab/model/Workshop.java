package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Workshop {
    private Long id;
    String title;
    String category;
    double price;
    int capacity;
    private Instructor instructor;

    public Workshop(String title, String category, double price, int capacity, Instructor instructor) {
        this.id = (long) (Math.random() * 1000);
        this.title = title;
        this.category = category;
        this.price = price;
        this.capacity = capacity;
        this.instructor = instructor;
    }
}
