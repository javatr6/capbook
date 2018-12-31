package org.flp.capbook.service;
import java.util.List;

import org.flp.capbook.model.Group_Request;

public interface IGroupRequestService {
	List<Group_Request> requestSent(Group_Request request);

	List<Group_Request> findRequest();

}
