package org.example.session04.homework.model;


public class SearchResult {
    private String category;
    private int limit;
    private String message;

    public SearchResult() {
    }

    public SearchResult(String category, int limit, String message) {
        this.category = category;
        this.limit = limit;
        this.message = message;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
