package corso.java.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import corso.java.controllers.ArticleController;
import corso.java.dto.CommentDto;
import corso.java.entities.CommentEntity;
import corso.java.repositories.ArticleRepository;
import corso.java.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    private final ArticleServiceImpl articleServiceImpl;

    private final ArticleRepository articleRepository;

    private final ArticleController articleController;
	
	@Autowired
	CommentRepository commentRepository;

    CommentServiceImpl(ArticleController articleController, ArticleRepository articleRepository, ArticleServiceImpl articleServiceImpl) {
        this.articleController = articleController;
        this.articleRepository = articleRepository;
        this.articleServiceImpl = articleServiceImpl;
    }
	@Override
	public CommentDto addComment(CommentDto comment) {
		CommentEntity comm =CommentEntity.builder()
				.withArticle(comment.getArticle())
				.withAuthor(comment.getAuthor())
				.withContent(comment.getContent())
				.withDate(LocalDate.now())
				.withTitle(comment.getTitle()).build();
		commentRepository.save(comm);
		return comment;
	}

	@Override
	public List<CommentDto> showAllCommentsByArticleId(int id) {
		
		return commentRepository.findAllByArticleId(id).stream().map(c -> CommentDto.builder()
				.withArticle(c.getArticle())
				.withAuthor(c.getAuthor())
				.withContent(c.getContent())
				.withTitle(c.getTitle())
				.build()).toList();
	}

}
