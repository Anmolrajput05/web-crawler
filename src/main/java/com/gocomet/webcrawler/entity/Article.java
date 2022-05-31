package com.gocomet.webcrawler.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private int id;

	@Column(name = "article_link")
	private String link;

	@Column(name = "article_creator")
	private String creator;

	@Column(name = "article_title")
	private String title;

	@Column(name = "article_blog")
	private String blog;

	@Column(name = "article_details")
	private String details;

	@Column(name = "article_fullBlog")
	private String fullBlog;

	@Column(name = "article_searchtag")
	private String searchTag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getFullBlog() {
		return fullBlog;
	}

	public void setFullBlog(String fullBlog) {
		this.fullBlog = fullBlog;
	}

	public String getSearchTag() {
		return searchTag;
	}

	public void setSearchTag(String searchTag) {
		this.searchTag = searchTag;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public Article(int id, String link, String creator, String title, String blog, String details, String fullBlog,
			String searchTag, Set<Tag> tags, List<Response> responses) {
		super();
		this.id = id;
		this.link = link;
		this.creator = creator;
		this.title = title;
		this.blog = blog;
		this.details = details;
		this.fullBlog = fullBlog;
		this.searchTag = searchTag;
		this.tags = tags;
		this.responses = responses;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "articles_tags", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "articles_responses", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "respnse_id"))
	private List<Response> responses;

}
