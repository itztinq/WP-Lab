package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Instructor;
import mk.ukim.finki.wp.lab.model.Registration;
import mk.ukim.finki.wp.lab.model.Workshop;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Workshop> workshops = null;
    public static List<Registration> registrations = null;
    public static List<Instructor> instructors = null;

    @PostConstruct
    public void init() {
        instructors = new ArrayList<>();

        instructors.add(new Instructor(1L, "Ana", "Anovska", "ana@example.com", "Web Development"));
        instructors.add(new Instructor(2L, "Marko", "Markovski", "marko@example.com", "DevOps"));
        instructors.add(new Instructor(3L, "Elena", "Elenova", "elena@example.com", "Machine learning"));

        workshops = new ArrayList<>();

        workshops.add(new Workshop("C++ Fundamentals", "Programming", 1200.0, 12, instructors.get(0)));
        workshops.add(new Workshop("Spring Boot Basics", "Web Development", 1500.0, 10, instructors.get(0)));
        workshops.add(new Workshop("Docker for Beginners", "DevOps", 1500.0, 8, instructors.get(1)));
        workshops.add(new Workshop("Kubernetes Introduction", "DevOps", 2000.0, 0, instructors.get(1)));
        workshops.add(new Workshop("React Essentials", "Web Development", 1700.0, 17, instructors.get(0)));
        workshops.add(new Workshop("Python for Data Science", "Data Science", 1600.0, 20, instructors.get(2)));
        workshops.add(new Workshop("Machine Learning Basics", "Artificial Intelligence", 2500.0, 10, instructors.get(2)));
        workshops.add(new Workshop("UI UX Design", "Design", 1300.0, 30, instructors.get(0)));
        workshops.add(new Workshop("Git and GitHub", "Tools", 900.0, 25, instructors.get(1)));
        workshops.add(new Workshop("SQL Databases", "Databases", 1400.0, 14, instructors.get(2)));

        registrations = new ArrayList<>();
    }
}
