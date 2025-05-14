package corso.java.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
	public ArticleDto addArticle(ArticleDto insertArticle) {
		ArticleEntity article = ArticleEntity.builder()
				.withAuthor(authorRepository.findById(insertArticle.getAuthor().getId()).orElseThrow())
				.withCategory(insertArticle.getCategory())
				.withContent(insertArticle.getContent())
				.withPublishDate(LocalDate.now())
				.withTitle(insertArticle.getTitle())
				.build();
				
		articleRepository.save(article);
		
		return insertArticle;
	}

	@Override
	public void modifyArticle() {
	

	}

	@Override
	public List<ArticleDto> showAllArticle() {
		List <ArticleDto> list = articleRepository.findAll().stream().map(a-> ArticleDto.builder()
				.withCategory(a.getCategory())
				.withAuthor(a.getAuthor())
				.withContent(a.getContent())
				.withTitle(a.getTitle()).build()).toList();
				
			return list;
		
	}

}
