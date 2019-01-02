package org.flp.capbook.service;

import java.util.List;




public interface IOnlineService {
	List<Integer> getAllUserMails1(Integer userId);
	List<Integer> getAllUserMails2(Integer userId);
	List<String> getAllUserNames(List<Integer> ids);
}
