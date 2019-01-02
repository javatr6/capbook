package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.Friend_request;
import org.flp.capbook.model.UserProfile;
import org.springframework.data.repository.query.Param;



public interface IFriendListService {


   List<String> getAllFriendList(Integer userId);
   //List<String> getAllFriendrequest2(Integer userId);
}
