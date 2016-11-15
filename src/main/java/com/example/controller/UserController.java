package com.example.controller;

import com.example.model.User;
import com.example.service.ISecurityService;
import com.example.service.IUserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ISecurityService securityService;


    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping(value = "/registration")
    public ModelAndView registration(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
        val mv = new ModelAndView("registration");
        if (bindingResult.hasErrors()) {
            List<String> messages = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(toList());
            mv.addObject("errors", messages);
            mv.addObject("isError", true);
            return mv;
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return new ModelAndView("redirect:/index");
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

  /*  @GetMapping(value = {"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }*/

    @GetMapping(value = "/admin")
    public String admin(Model model) {
        return "admin";
    }
}
