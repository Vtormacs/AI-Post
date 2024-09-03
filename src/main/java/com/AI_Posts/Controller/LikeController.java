package com.AI_Posts.Controller;

import com.AI_Posts.Entity.LikeEntity;
import com.AI_Posts.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/save")
    public ResponseEntity<LikeEntity> save(@RequestBody LikeEntity like) {
        try {
            return ResponseEntity.ok(likeService.save(like));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<LikeEntity> update(@RequestBody LikeEntity like, @RequestParam UUID uuid) {
        try {
            return ResponseEntity.ok(likeService.update(like, uuid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam UUID uuid) {
        try {
            return ResponseEntity.ok(likeService.delete(uuid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<LikeEntity> findById(@RequestParam UUID uuid) {
        try {
            return ResponseEntity.ok(likeService.findById(uuid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<LikeEntity>> findAll() {
        try {
            return ResponseEntity.ok(likeService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
