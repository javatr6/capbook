package org.flp.capbook.dao;

import org.flp.capbook.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IStatusDao  extends JpaRepository<Status, Integer>{

}
