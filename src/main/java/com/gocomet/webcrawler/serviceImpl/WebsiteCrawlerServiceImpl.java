package com.gocomet.webcrawler.serviceImpl;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gocomet.webcrawler.entity.Article;
import com.gocomet.webcrawler.repository.ArticleRepository;
import com.gocomet.webcrawler.service.WebsiteCrawlerService;

@Service
public class WebsiteCrawlerServiceImpl implements WebsiteCrawlerService {

	@Autowired
	private ArticleRepository articleRepository;

	@Value("${website}")
	String url;

	@Override
	public Set<Article> getArticlesByTag(String searchTag) {

		Set<Article> articles = new LinkedHashSet<Article>();

		fetchArticlesFromUrl(searchTag, url + "/tag/" + searchTag);

		articles.addAll(fetchArticlesFromDb(searchTag));

		return articles;
	}

	private void fetchArticlesFromUrl(String searchTag, String url) {

		try {
			Document document = Jsoup.connect(url).userAgent("Mozilla").timeout(30000).referrer("http://google.com")
					.get();
			Elements elements = document.getElementsByClass("fv ar l gq");

			for (Element element : elements) {
				if (articleRepository.getArticleByCreatorTitle(
						element.child(0).getElementsByClass("sj sk sl sm sn y").get(0).text(),
						element.child(1).getElementsByClass(
								"bv he so sp sq sr ss st su sv sw sx sy sz ta tb tc td te tf tg th ti tj tk tl tm ct po pp pr ps by")
								.get(0).text()) == null) {
					
					Article article = new Article();
					article.setLink(element.child(1)
							.getElementsByClass("ay az ba bb bc bd be bf bg bh bi bj bk bl bm").get(0).attr("abs:href")
							.substring(0,
									element.child(1).getElementsByClass("ay az ba bb bc bd be bf bg bh bi bj bk bl bm")
											.get(0).attr("abs:href").indexOf("?")));
					article.setTitle(element.child(1).getElementsByClass(
									"bv he sp sq sr ss st su sv sw sx sy sz ta tb tc td te tf tg th ti tj tk tl tm tn ct qg qh qj qk by")
									.get(0).text());
					article.setCreator(element.child(0).getElementsByClass("bv b bw bx ct qu po pp qv pr qw ps by")
									.get(0).text());
					article.setBlog(element.child(1).getElementsByClass("tn b ec eb ct ug po pp pq pr ps fk by").get(0)
									.text());
					article.setDetails(element.child(1).getElementsByClass("bv b hn bx ho").get(0).text());
					article.setSearchTag(searchTag);
					articleRepository.save(article);
				} else {
					Article article = articleRepository.getArticleByCreatorTitle(
							element.child(0).getElementsByClass("sj sk sl sm sn y").get(0).text(),
							element.child(1).getElementsByClass(
									"bv he sp sq sr ss st su sv sw sx sy sz ta tb tc td te tf tg th ti tj tk tl tm tn ct qg qh qj qk by")
									.get(0).text());
					article.setLink(element.child(1).getElementsByClass("ay az ba bb bc bd be bf bg bh bi bj bk bl bm")
							.get(0).attr("abs:href").substring(0,
									element.child(1).getElementsByClass("ay az ba bb bc bd be bf bg bh bi bj bk bl bm")
											.get(0).attr("abs:href").indexOf("?")));
					article.setBlog(
							element.child(1).getElementsByClass("tn b ec eb ct ug po pp pq pr ps fk by").get(0).text());
					article.setDetails(element.child(1).getElementsByClass("bv b hn bx ho").get(0).text());
					article.setSearchTag(searchTag);
					articleRepository.save(article);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Set<Article> fetchArticlesFromDb(String searchTag) {
		return articleRepository.findBySearchTagContainsAllIgnoreCase(searchTag);
	}

	@Override
	public Article fillArticle(Article article) {
		try {
			Document document = Jsoup.connect(article.getLink()).userAgent("Mozilla").timeout(30000)
					.referrer("http://google.com").get();
			Element element = document.getElementsByTag("article").get(0);
			article.setFullBlog(element.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return article;
	}

}
