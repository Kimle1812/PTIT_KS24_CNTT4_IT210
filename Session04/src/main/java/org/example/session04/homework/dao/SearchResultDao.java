package org.example.session04.homework.dao;


import org.example.session04.homework.model.SearchResult;
import org.springframework.stereotype.Repository;

@Repository
public class SearchResultDao {
    public SearchResult search(String category, int limit) {
        return new SearchResult(category, limit, "Tìm kiếm thành công");
    }
}
