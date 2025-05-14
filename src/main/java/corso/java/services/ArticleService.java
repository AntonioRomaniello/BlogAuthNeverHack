package corso.java.services;

import java.util.List;

import corso.java.dto.ArticleDto;

public interface ArticleService {
	public ArticleDto addArticle(ArticleDto insertArticle);
	public void modifyArticle();
	public List<ArticleDto> showAllArticle();
	

}
