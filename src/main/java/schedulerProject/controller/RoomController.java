package schedulerProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import schedulerProject.model.event.Event;
import schedulerProject.model.room.Room;
import schedulerProject.model.room.RoomDAO;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomDAO roomDAO;

    @Autowired
    public RoomController(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @GetMapping
    public String index (Model model) {
        model.addAttribute("rooms", roomDAO.index());
        return "/room/index";
    }

    @GetMapping("/new")
    public String newRoom (@ModelAttribute("room") Room room) {
        // return view with form ->
        return "/room/new";
    }

    @PostMapping
    public String createRoom (@ModelAttribute ("room") Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "room/new";

        roomDAO.save(room);
        return "redirect:/room";
    }

    @GetMapping("/{id}")

    @GetMapping("/{id}/edit")

    @PatchMapping

    @DeleteMapping

}
