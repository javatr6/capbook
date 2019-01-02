package org.flp.capbook.service;

import org.flp.capbook.model.Likes;


public interface ILikeService {

	Boolean updateLikes(Integer status_id, Likes like);

	Integer getLikeCount(Integer status_id);

	Boolean updateDislikes(Integer status_id, Likes like);

	Integer getDislikeCount(Integer status_id);

	

}
