package corso.java.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import corso.java.dto.ArticleDto;
import corso.java.entities.ArticleEntity;
import corso.java.repositories.ArticleRepository;
import corso.java.repositories.AuthorRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	AuthorRepository authorRepository;
	@Override
	public void addArticle(ArticleDto insertArticle) {
		ArticleEntity article = ArticleEntity.builder()
				.withAuthor(authorRepository.findById(insertArticle.getAuthorId()).orElseThrow())
				.withCategory(insertArticle.getCategory())
				.withContent(insertArticle.getContent())
				.withPublishDate(LocalDate.now())
				.withTitle(insertArticle.getTitle())
				.build();
				
		articleRepository.save(article);
		
		
	}

	@Override
	public void modifyArticle() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ArticleDto> showAllArticle() {
		// TODO Auto-generated method stub
		return null;
	}

}
