package com.prog.springboot.controller;

import com.prog.springboot.model.User;
import com.prog.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping()
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.findOne(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        userService.update(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
