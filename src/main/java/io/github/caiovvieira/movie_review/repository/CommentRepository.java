package io.github.caiovvieira.movie_review.repository;

import io.github.caiovvieira.movie_review.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
