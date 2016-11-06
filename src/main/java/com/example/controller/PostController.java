package com.example.controller;

import com.example.model.Post;
import com.example.repository.PostRep;
import com.example.repository.TagRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostRep postRep;
    @Autowired
    private TagRep tagRep;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<Post> saveOrUpdate(@RequestBody Post post) {
        post.setDate(Date.valueOf(LocalDate.now()));
        Post existPost = postRep.findOne(post.getId());
        if (existPost != null) {
            existPost.setTitle(post.getTitle());
            existPost.setText(post.getText());


            postRep.save(existPost);
            return ResponseEntity.ok(post);
        }
        postRep.save(post);
        return ResponseEntity.ok(post);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(postRep.findAll());
    }

    @GetMapping("/findOne{id}")
    public ResponseEntity<Post> findOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(postRep.findOne(id));

    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Post> delete(@PathVariable("id") Long id) {
        Post post = postRep.findOne(id);
        postRep.delete(id);
        return ResponseEntity.ok(post);
    }

}
