package schedulerProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import schedulerProject.model.event.Event;
import schedulerProject.model.event.EventDAO;
import schedulerProject.model.room.Room;
import schedulerProject.model.room.RoomDAO;
import schedulerProject.model.user.Admin;
import schedulerProject.model.user.AdminDAO;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminDAO adminDAO;
    private final RoomDAO roomDAO;
    private final EventDAO eventDAO;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public AdminController(AdminDAO adminDAO, RoomDAO roomDAO, EventDAO eventDAO) {
        this.adminDAO = adminDAO;
        this.roomDAO = roomDAO;
        this.eventDAO = eventDAO;
    }

    // finish writing later
    @PostMapping("/newroom")
    public String createRoom (@ModelAttribute("room") Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return ""; // improve later

        roomDAO.save(room);
        return ""; // improve later
    }

    // finish writing later
    @PostMapping("/newevent")
    public String createEvent (@ModelAttribute("event") Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return ""; // improve later

        eventDAO.save(event);
        return "/event"; // improve later
    }

    @PostMapping("/newadmin")
    public String createAdmin (@ModelAttribute("admin")Admin admin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return ""; // improve later

        adminDAO.save(admin);
        return ""; // improve later
    }

}
