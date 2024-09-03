package com.AI_Posts.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "post")
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private Instant data;

    @NotBlank @NotNull @NotEmpty
    private String conteudo;

    private boolean valido;

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<TagEntity> tags = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    @JsonIgnoreProperties("post")  // Evita loop infinito durante a serialização de ComplaintEntity
    private List<ComplaintEntity> complaints = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    @JsonIgnoreProperties("post")  // Evita loop infinito durante a serialização de LikeEntity
    private List<LikeEntity> likes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("post")
    private UserEntity user;

    @OneToMany(mappedBy = "post")
    @JsonIgnoreProperties("post")
    private List<CommentEntity> comments = new ArrayList<>();

}
