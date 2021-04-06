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

import javax.validation.Valid;

@Controller
@RequestMapping("/event")
public class EventController {
    private final AdminDAO adminDAO;
    private final EventDAO eventDAO;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public EventController(AdminDAO adminDAO, EventDAO eventDAO) {
        this.adminDAO = adminDAO;
        this.eventDAO = eventDAO;
    }

    @GetMapping()
    public String index (Model model) {
        model.addAttribute("events", eventDAO.index());
        return "event/index";
    }

    // this "newEvent" method means that it'll be a html with form to create new Event &
    // with button that invoke Post request to "createEvent" method

    @GetMapping("/new")
    public String newEvent (@ModelAttribute("event") Event event) {
        // return view with form ->
        return "/event/new";
    }

    @PostMapping
    public String createEvent (@ModelAttribute("event") Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "event/new";

        eventDAO.save(event);
        return "redirect:/event";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("event", eventDAO.show(id));
        return "event/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("event", eventDAO.show(id));
        return "event/edit";
    }

    // finish writing later
    @PatchMapping("/{id}")
    public String update (@ModelAttribute("event") @Valid Event event,
                          BindingResult bindingResult,
                          @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return ""; // improve later

        eventDAO.update(id, event);
        return "redirect:/event";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id) {
        eventDAO.delete(id);
        return "redirect:/event";
    }

}
