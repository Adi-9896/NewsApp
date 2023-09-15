package com.example.newsapp;

import java.util.ArrayList;

public class Mainnews {
    private  String status,totalResults;
    private ArrayList<Modal> articles;

    public Mainnews(String status, String totalResults, ArrayList<Modal> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<Modal> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Modal> articles) {
        this.articles = articles;
    }
}
