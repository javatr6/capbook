package org.flp.capbook.dao;

import javax.transaction.Transactional;

import org.flp.capbook.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("emaildao")
@Transactional
public interface IEmailDao extends JpaRepository<Email, Integer> {

}
