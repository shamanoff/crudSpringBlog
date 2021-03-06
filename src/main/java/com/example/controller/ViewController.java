package com.example.controller;

import com.example.model.Post;
import com.example.model.Tag;
import com.example.repository.PostRep;
import com.example.repository.TagRep;
import com.example.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private UserRep userRep;
    @Autowired
    private PostRep postRep;
    @Autowired
    private TagRep tagRep;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
//        User user = userRep.findByUsername();
        List<Tag> tags = tagRep.findAll();
        List<Post> findedPosts = postRep.findAll();
        mv.addObject("posts", findedPosts);
        mv.addObject("newPost", new Post());
        mv.addObject("tags", tags);
        return mv;

    }

    @PostMapping("/save")
    public View saveOrUpdate(Post post) {

        View view = new RedirectView("/");
        if (post.getId() == null) {
            postRep.save(post);
            return view;
        }
        Post existPost = postRep.findOne(post.getId());
        if (existPost != null) {
            existPost.setTitle(post.getTitle());
            existPost.setText(post.getText());
//            existPost.setDate(post.getDate());
            existPost.setTag(post.getTag());

            postRep.save(post);
            return view;
        }
        postRep.save(post);
        return view;

    }

}
