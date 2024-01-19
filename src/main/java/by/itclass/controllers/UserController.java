package by.itclass.controllers;

import by.itclass.model.entities.User;
import by.itclass.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.itclass.constants.AppConst.*;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String root() {
        return INDEX_PAGE;
    }

    @GetMapping(value = ALL_USER_URL)
    public String userControllerMethodWhichReturnAllUsers(Model model) {
        var users = service.getAllUsers();
        model.addAttribute(USER_LIST_ATTR, users);
        return USERS_PAGE;
    }

    @GetMapping(value = DELETE_USER_URL)
    public String deleteUserById(@RequestParam(name = "id") int userId) {
        service.deleteById(userId);
        return INDEX_PAGE;
    }

    @GetMapping(value = ADD_USER_URL)
    public ModelAndView addUserFromForm() {
        return new ModelAndView(ADD_PAGE, USER_ATTR, new User());
    }

    @PostMapping(value = SAVE_USER_URL)
    public String save(@ModelAttribute(name = USER_ATTR) User user) {
        service.add(user);
        return "redirect:" + ALL_USER_URL;
    }

    @GetMapping(value = UPD_USER_URL)
    public ModelAndView upd(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") int age) {
        return new ModelAndView(UPD_PAGE, USER_ATTR, new User(id, name, age));
    }

    @PostMapping(value = "/saveUpd")
    public String saveUpd(@ModelAttribute(name ="user") User user) {
        service.update(user);
        return "redirect:" + ALL_USER_URL;
    }
}
