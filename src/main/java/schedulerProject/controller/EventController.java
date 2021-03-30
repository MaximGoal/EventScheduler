package schedulerProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import schedulerProject.model.event.Event;
import schedulerProject.model.event.EventDAO;
import schedulerProject.model.room.Room;
import schedulerProject.model.user.AdminDAO;
import sun.text.normalizer.NormalizerBase;

import java.security.SecureRandom;
import java.security.spec.ECField;

@Controller
@RequestMapping("/event")
public class EventController {
    private final AdminDAO adminDAO;
    private final EventDAO eventDAO;

    @Autowired
    public EventController(AdminDAO adminDAO, EventDAO eventDAO) {
        this.adminDAO = adminDAO;
        this.eventDAO = eventDAO;
    }

    @GetMapping("/new")
    public String newEvent (@ModelAttribute("event") Event event) {
        return "/event/new";
    }

    // finish writing
    @PostMapping
    public String createEvent (@ModelAttribute("event") Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return ""; // improve later

        eventDAO.save(event);
        return "redirect:/event"; // improve later
    }

    @GetMapping("/index")
    public String index (Model model) {
        model.addAttribute("events", eventDAO.index());
        return "/event";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("event", eventDAO.show(id));
        return "event/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("event", eventDAO.show(id));
        return "/event/edit";
    }

    //realize methods
    // update
    // delete
}
