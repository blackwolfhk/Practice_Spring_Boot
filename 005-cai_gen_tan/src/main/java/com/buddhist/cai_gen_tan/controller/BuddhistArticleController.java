package com.buddhist.cai_gen_tan.controller;

import com.buddhist.cai_gen_tan.entity.BuddhistArticle;
import com.buddhist.cai_gen_tan.repository.BuddhistArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class BuddhistArticleController {

    private final BuddhistArticleRepository articleRepository;

    @Autowired
    public BuddhistArticleController(BuddhistArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public List<BuddhistArticle> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public BuddhistArticle getArticleById(@PathVariable Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Article not found with id: " + id));
    }

    @PostMapping
    public BuddhistArticle createArticle(@RequestBody BuddhistArticle article) {
        return articleRepository.save(article);
    }

    @PutMapping("/{id}")
    public BuddhistArticle updateArticle(@PathVariable Long id, @RequestBody BuddhistArticle updatedArticle) {
        BuddhistArticle existingArticle = articleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Article not found with id: " + id));

        existingArticle.setChiContent(updatedArticle.getChiContent());
        existingArticle.setEngContent(updatedArticle.getEngContent());

        return articleRepository.save(existingArticle);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }
}
