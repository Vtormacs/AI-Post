package com.AI_Posts.Service;

import com.AI_Posts.Entity.CommentEntity;
import com.AI_Posts.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentEntity save(CommentEntity comment) {
        try {
            return commentRepository.save(comment);
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para salvar o comentário no repository: " + e.getMessage());
            return new CommentEntity();
        }
    }

    public CommentEntity update(CommentEntity comment, UUID uuid) {
        try {
            commentRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Comentário não existe no banco"));
            comment.setUuid(uuid);
            return commentRepository.save(comment);
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para atualizar o comentário no repository: " + e.getMessage());
            return new CommentEntity();
        }
    }

    public String delete(UUID uuid) {
        try {
            commentRepository.deleteById(uuid);
            return "Comentário deletado";
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para deletar o comentário no repository: " + e.getMessage());
            return "Não deu para deletar o comentário, erro no service";
        }
    }

    public CommentEntity findById(UUID uuid) {
        try {
            return commentRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Comentário não encontrado no banco"));
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para encontrar o comentário no repository: " + e.getMessage());
            return new CommentEntity();
        }
    }

    public List<CommentEntity> findAll() {
        try {
            return commentRepository.findAll();
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para listar os comentários do banco: " + e.getMessage());
            return List.of();
        }
    }
}
