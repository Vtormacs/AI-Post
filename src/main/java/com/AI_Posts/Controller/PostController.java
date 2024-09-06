package com.AI_Posts.Controller;

import com.AI_Posts.Entity.PostEntity;
import com.AI_Posts.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/save")
    public ResponseEntity<PostEntity> save(@RequestBody PostEntity post) {
        try {
            return ResponseEntity.ok(postService.save(post));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<PostEntity> update(@RequestBody PostEntity post, @RequestParam UUID uuid) {
        try {
            return ResponseEntity.ok(postService.update(post, uuid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam UUID uuid) {
        try {
            return ResponseEntity.ok(postService.delete(uuid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<PostEntity> findById(@RequestParam UUID uuid) {
            return ResponseEntity.ok(postService.findById(uuid));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PostEntity>> findAll() {
        try {
            return ResponseEntity.ok(postService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
