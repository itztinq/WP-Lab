package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Workshop {
    String title;
    String category;
    double price;
    int capacity;
}
