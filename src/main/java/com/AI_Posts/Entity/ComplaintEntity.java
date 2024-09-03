package com.AI_Posts.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "complaint")
@Table(name = "complaint")
public class ComplaintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("complaints")  // Evita loop infinito durante a serialização de UserEntity
    private UserEntity user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties("complaints")  // Evita loop infinito durante a serialização de PostEntity
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = true)
    @JsonIgnoreProperties("complaints")  // Evita loop infinito durante a serialização de CommentEntity
    private CommentEntity comment;
}
