package org.flp.capbook.service;


import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.flp.capbook.dao.IBirthdayDao;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("birthdayservice")
public class BirthdayServiceImpl implements IBirthdayService{
	@Autowired
	private IBirthdayDao birthdaydao1;

@Override
public List<String> getDetails(Integer recid) {

	return birthdaydao1.getDob(recid);
}

@Override
public List<String> getDetails1(Integer recid) {
	
	return birthdaydao1.getDob1(recid);
}

/*@Override
public List<String> getUsername(Integer recid) {
	// TODO Auto-generated method stub
	return birthdaydao1.getUsername(recid);
}*/

	
	}


	/*public List<Integer> getDetails(Integer recid) {
		
		return birthdaydao1.getDob(recid);
	}
*/
	/*@Override
	public List<Birthday> getDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	@Autowired
private IBirthday birthdaydao;
	@Override
	public List<Birthday> getDetails(){
		
		List<Birthday> bdayList=birthdaydao.findAll();
		Iterator<Birthday>birthdayIterator = bdayList.iterator();
		for()
		List<Birthday> filterList= new ArrayList<>();
		for(Birthday b:bdayList) {
			
			 int b1=b.getDob().toLocalDate().getDayOfMonth();
			 Month b2=LocalDate.now().getMonth();
			Month a1=b.getDob().toLocalDate().getMonth();
		int a2=	LocalDate.now().getDayOfMonth();
			 if(b2==a1&&a2==b1) {
				 filterList.add(b); 
			 }
			 System.out.println(b.getDob().toLocalDate().getDayOfMonth());
				System.out.println(b.getDob().toLocalDate().getMonth());
				System.out.println(LocalDate.now().getMonth());	
		}
		return filterList;
	}*/


