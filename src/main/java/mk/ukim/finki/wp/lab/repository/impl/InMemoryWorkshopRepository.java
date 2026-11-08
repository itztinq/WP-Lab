package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Workshop;
import mk.ukim.finki.wp.lab.repository.WorkshopRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryWorkshopRepository implements WorkshopRepository {

    @Override
    public List<Workshop> findAll() {
        return DataHolder.workshops;
    }

    @Override
    public Optional<Workshop> findByTitle(String title) {
        return DataHolder.workshops.stream()
                .filter(w -> w.getTitle().equals(title))
                .findFirst();
    }

    @Override
    public List<Workshop> search(String text, Double maxPrice) {
        return DataHolder.workshops.stream()
                .filter(w -> {
                  if (text == null || text.isBlank()) return true;
                  String lowerCaseText = text.toLowerCase();
                  return w.getTitle().toLowerCase().contains(lowerCaseText) ||
                          w.getCategory().toLowerCase().contains(lowerCaseText);
                })
                .filter(w -> {
                    if (maxPrice == null) return true;
                    return w.getPrice() <= maxPrice;
                })
                .toList();
    }

    @Override
    public Optional<Workshop> findById(Long id) {
        return DataHolder.workshops
                .stream()
                .filter(workshop -> workshop.getId().equals(id))
                .findFirst();
    }

    @Override
    public Workshop save(Workshop workshop) {
        DataHolder.workshops.removeIf(existingWorkshop -> existingWorkshop.getId().equals(workshop.getId()));
        DataHolder.workshops.add(workshop);
        return workshop;
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.workshops.removeIf(workshop -> workshop.getId().equals(id));
    }
}
