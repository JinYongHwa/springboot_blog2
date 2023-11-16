package kr.ac.mjc.blog.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.blog.domain.Article;
import kr.ac.mjc.blog.dto.AddArticleRequest;
import kr.ac.mjc.blog.dto.ArticleResponse;
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
    public ResponseEntity<ArticleResponse> saveArticle(@RequestBody AddArticleRequest request,
                                                       HttpServletRequest httpServletRequest){
        HttpSession session=httpServletRequest.getSession(true);
        String userId=(String)session.getAttribute("userId");

        ArticleResponse response=new ArticleResponse();
        if(userId==null){       //로그인 되어있지 않은경우
            response.setSuccess(false);
            response.setMessage("로그인 후 작성 가능합니다");
            return ResponseEntity.ok().body(response);
        }
        //로그인이 된경우 -> 글작성
        Article savedRequest=blogService.save(request,userId);
        response.setSuccess(true);
        response.setMessage("글작성이 완료되었습니다");
        response.setArticle(savedRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
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
