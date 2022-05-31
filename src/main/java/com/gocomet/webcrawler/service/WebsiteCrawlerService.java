package com.gocomet.webcrawler.service;

import java.util.Set;

import com.gocomet.webcrawler.entity.Article;

public interface WebsiteCrawlerService {

	public Set<Article> getArticlesByTag(String searchTag);

	public Set<Article> fetchArticlesFromDb(String searchTag);

	public Article fillArticle(Article article);

}