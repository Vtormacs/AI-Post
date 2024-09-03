package com.AI_Posts.Repository;

import com.AI_Posts.Entity.PostEntity;
import com.AI_Posts.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, UUID> {
}