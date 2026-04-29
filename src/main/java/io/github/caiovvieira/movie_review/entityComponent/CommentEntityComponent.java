package io.github.caiovvieira.movie_review.entityComponent;

import io.github.caiovvieira.movie_review.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentEntityComponent {

    public boolean isValidComment(Comment comment) {
        return comment != null && comment.getCommentText() != null && !comment.getCommentText().trim().isEmpty();
    }

    public String getCommentSummary(Comment comment) {
        return comment.getCommentText().substring(0, Math.min(30, comment.getCommentText().length())) + "...";
    }
}
