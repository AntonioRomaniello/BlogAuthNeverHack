package corso.java.services;

import java.util.List;

import corso.java.dto.ArticleDto;

public interface ArticleService {
	public void addArticle(ArticleDto insertArticle);
	public void modifyArticle();
	public List<ArticleDto> showAllArticle();
	

}
