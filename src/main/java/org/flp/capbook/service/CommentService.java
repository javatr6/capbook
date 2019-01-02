package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.ICommentDao;
import org.flp.capbook.model.Comments;
import org.flp.capbook.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("CommentService")
public class CommentService implements ICommentService{

	
	@Autowired
	private ICommentDao commentdao;
	@Override
	public List<Comments> saveComment(Comments comment) {
		Comments pro=commentdao.save(comment);
		System.out.println(pro);
		return commentdao.findAll();
		
	}
	@Override
	public List<Comments> getAllComments() {
		return commentdao.findAll();
	}
	@Override
	public List<Comments> getAllCommentsByStatusId(Integer status_id) {
		
		return commentdao.getAllCommentsByStatusId(status_id);
	}
	@Override
	public List<Comments> saveCommentByStatusId(Integer status_id, Comments comment) {
		Status status=commentdao.getStatusById(status_id);
		if(status.equals(null))
		return null;
		else {
			comment.setStatus(status);
			comment.setPostedTo(status.getUser().getUserId());
			comment.setLikeCount(0);
			comment.setDislikeCount(0);
			commentdao.save(comment);
			
			return commentdao.getAllComments(status.getStatus_id());
		}
	}
	@Override
	public Integer updateCommentLikeCount(Integer status_id, Integer commentId) {
	
		return commentdao.updateCommentLikeCount(status_id, commentId);
	}
	@Override
	public Integer updateCommentDislikeCount(Integer status_id, Integer commentId) {
		
		return commentdao.updateCommentDislikeCount(status_id, commentId);
	}

}
