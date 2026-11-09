package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Workshop {
    private Long id;
    String title;
    String category;
    double price;
    int capacity;
    private Instructor instructor;

    private List<Double> ratings = new ArrayList<>();

    public Workshop(String title, String category, double price, int capacity, Instructor instructor) {
        this.id = (long) (Math.random() * 1000);
        this.title = title;
        this.category = category;
        this.price = price;
        this.capacity = capacity;
        this.instructor = instructor;
    }

    public void addRating(double rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        ratings.add(rating);
    }

    public Double getAvgRating() {
        if (ratings.isEmpty()) {
            return null;
        }
        double sum = 0;
        for (double r : ratings) {
            sum += r;
        }
        return sum / ratings.size();
    }
}
