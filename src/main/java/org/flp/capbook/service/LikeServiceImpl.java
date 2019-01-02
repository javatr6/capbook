package org.flp.capbook.service;

import java.time.LocalDateTime;

import org.flp.capbook.dao.ILikeDao;
import org.flp.capbook.model.Likes;
import org.flp.capbook.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("likeService")
public class LikeServiceImpl implements ILikeService {

	@Autowired
	private ILikeDao likeDao;

	@Override
	public Boolean updateLikes(Integer status_id, Likes like) {
		Status status=likeDao.findStatus(status_id);
		if(status!=null) {
			Likes likeupdate=likeDao.findLikeByStatus(status.getStatus_id(),like.getLiked_By());
			if(likeupdate!=null) {
				
					if(likeupdate.getLike_count()==true) {
						likeupdate.setLike_count(false);
						likeupdate.setDate_of_Like(LocalDateTime.now());
						
					}else {
						likeupdate.setLike_count(true);
						likeupdate.setDislike_count(false);
						likeupdate.setDate_of_Like(LocalDateTime.now());
					}
					likeDao.save(likeupdate);
					return true;
				
			}else {
				like.setDate_of_Like(LocalDateTime.now());
				like.setLike_count(true);
				like.setDislike_count(false);
				like.setStatus(status);
				likeDao.save(like);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Integer getLikeCount(Integer status_id) {
		return likeDao.getLikeCount(status_id);
		
	}

	@Override
	public Boolean updateDislikes(Integer status_id, Likes like) {
		Status status=likeDao.findStatus(status_id);
		if(status!=null) {
			Likes dislikeupdate=likeDao.findLikeByStatus(status.getStatus_id(),like.getLiked_By());
			if(dislikeupdate!=null) {
				
					if(dislikeupdate.getDislike_count()==true) {
						dislikeupdate.setDislike_count(false);
						dislikeupdate.setDate_of_Like(LocalDateTime.now());
						
					}else {
						dislikeupdate.setDislike_count(true);
						dislikeupdate.setLike_count(false);
						dislikeupdate.setDate_of_Like(LocalDateTime.now());
					}
					likeDao.save(dislikeupdate);
					return true;
				
			}else {
				like.setDate_of_Like(LocalDateTime.now());
				like.setDislike_count(true);
				like.setLike_count(false);
				like.setStatus(status);
				likeDao.save(like);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Integer getDislikeCount(Integer status_id) {
		
		return likeDao.getDislikeCount(status_id);
	}
	

}
