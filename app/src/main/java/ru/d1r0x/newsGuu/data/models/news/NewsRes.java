package ru.d1r0x.newsGuu.data.models.news;

public class NewsRes {
    private final String status;
    private final int totalResults;
    private final Articles[] articles;

    public NewsRes(String status, int totalResults, Articles[] articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public Articles[] getArticles() {
        return articles;
    }
}
