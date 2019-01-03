package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.UserProfile;




public interface IOnlineService {
	List<Integer> getAllUserMails1(Integer userId);
	List<Integer> getAllUserMails2(Integer userId);
	List<UserProfile> getAllUserNames(List<Integer> ids);
}
