package com.example.controller;

import com.example.model.Post;
import com.example.repository.PostRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private PostRep postRep;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");

        List<Post> findedPosts = postRep.findAll();
        mv.addObject("posts", findedPosts);
//        mv.addObject("newPost", new Post());
        return mv;

    }

}
