package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.Comments;

public interface ICommentService {

	List<Comments> saveComment(Comments comment);

	List<Comments> getAllComments();

	List<Comments> getAllCommentsByStatusId(Integer status_id);

	List<Comments> saveCommentByStatusId(Integer status_id, Comments comment);

	Integer updateCommentLikeCount(Integer status_id, Integer commentId);

	Integer updateCommentDislikeCount(Integer status_id, Integer commentId);

}
