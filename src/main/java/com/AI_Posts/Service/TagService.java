package com.AI_Posts.Service;

import com.AI_Posts.Entity.TagEntity;
import com.AI_Posts.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public TagEntity save(TagEntity tag) {
        try {
            return tagRepository.save(tag);
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para salvar a tag no repository: " + e.getMessage());
            return new TagEntity();
        }
    }

    public TagEntity update(TagEntity tag, UUID uuid) {
        try {
            tagRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Tag não existe no banco"));
            tag.setUuid(uuid);
            return tagRepository.save(tag);
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para atualizar a tag no repository: " + e.getMessage());
            return new TagEntity();
        }
    }

    public String delete(UUID uuid) {
        try {
            tagRepository.deleteById(uuid);
            return "Tag deletada";
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para deletar a tag no repository: " + e.getMessage());
            return "Não deu para deletar a tag, erro no service";
        }
    }

    public TagEntity findById(UUID uuid) {
        return tagRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Tag não encontrada no banco"));
    }


    public List<TagEntity> findAll() {
        try {
            return tagRepository.findAll();
        } catch (Exception e) {
            System.out.println("Erro no service, não deu para listar as tags do banco: " + e.getMessage());
            return List.of();
        }
    }
}
