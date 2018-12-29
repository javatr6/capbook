package org.flp.capbook.dao;

import javax.transaction.Transactional;

import org.flp.capbook.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("loginDao")
@Transactional
public interface ILoginDao extends JpaRepository<Login, String>{

}
