package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Registration {
    String workshopTitle;
    String participantName;
    String participantEmail;
    int numberOfSeats;
}
