package kr.ac.mjc.blog.controller;

import kr.ac.mjc.blog.domain.Article;
import kr.ac.mjc.blog.dto.AddArticleRequest;
import kr.ac.mjc.blog.dto.UpdateArticleRequest;
import kr.ac.mjc.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> saveArticle(@RequestBody AddArticleRequest request){
        Article savedRequest=blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedRequest);
    }
    @GetMapping("/api/articles")
    public ResponseEntity<List<Article>> allArticle(){
        List<Article> articles=blogService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<Article> findArticle(@PathVariable long id){
        Article article=blogService.findOne(id);
        return ResponseEntity.ok().body(article);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(
            @PathVariable long id,
            @RequestBody UpdateArticleRequest request
    ){
        Article article=blogService.update(id,request);
        return ResponseEntity.ok().body(article);
    }

}
