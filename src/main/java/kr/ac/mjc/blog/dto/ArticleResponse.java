package kr.ac.mjc.blog.dto;

import kr.ac.mjc.blog.domain.Article;

public class ArticleResponse {
    private boolean success;
    private String message;
    private Article article;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
