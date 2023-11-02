package kr.ac.mjc.blog.dto;

import kr.ac.mjc.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(){
        Article article=new Article(this.title, this.content);
        return article;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
