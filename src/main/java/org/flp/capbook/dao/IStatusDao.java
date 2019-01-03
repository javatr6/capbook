package org.flp.capbook.dao;

import java.util.List;

import org.flp.capbook.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("statusDao")
public interface IStatusDao extends JpaRepository<Status, Integer> {
	

	@Query(value="select * from status s where s.user_id = :userId order by status_id desc", nativeQuery=true)
	List<Status> getStatus(@Param("userId") Integer userId);

	@Query(value="select image_url from status s where s.userId = :userId", nativeQuery=true)
	List<String> getImage(@Param("userId") Integer userId);
	

	@Query(value="select * from status where status_id=:status_id",nativeQuery=true)
	Status findStatus(@Param("status_id") Integer status_id);

}
