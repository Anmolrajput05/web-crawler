package com.gocomet.webcrawler.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gocomet.webcrawler.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	@Query(value = "SELECT * FROM Articles a WHERE a.article_creator = :creator and a.article_title = :title", nativeQuery = true)
	public Article getArticleByCreatorTitle(String creator, String title);

	public Set<Article> findBySearchTagContainsAllIgnoreCase(String searchTag);
}
