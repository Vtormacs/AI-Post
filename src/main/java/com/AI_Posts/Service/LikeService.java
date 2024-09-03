package com.AI_Posts.Service;

import com.AI_Posts.Entity.LikeEntity;
import com.AI_Posts.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public LikeEntity save(LikeEntity like) {
        try {
            return likeRepository.save(like);
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para salvar o like no repository: " + e.getMessage());
            return new LikeEntity();
        }
    }

    public LikeEntity update(LikeEntity like, UUID uuid) {
        try {
            likeRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Like não existe no banco"));
            like.setUuid(uuid);
            return likeRepository.save(like);
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para atualizar o like no repository: " + e.getMessage());
            return new LikeEntity();
        }
    }

    public String delete(UUID uuid) {
        try {
            likeRepository.deleteById(uuid);
            return "Like deletado";
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para deletar o like no repository: " + e.getMessage());
            return "Não deu para deletar o like, erro no service";
        }
    }

    public LikeEntity findById(UUID uuid) {
        try {
            return likeRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Like não encontrado no banco"));
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para encontrar o like no repository: " + e.getMessage());
            return new LikeEntity();
        }
    }

    public List<LikeEntity> findAll() {
        try {
            return likeRepository.findAll();
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para listar os likes do banco: " + e.getMessage());
            return List.of();
        }
    }
}
