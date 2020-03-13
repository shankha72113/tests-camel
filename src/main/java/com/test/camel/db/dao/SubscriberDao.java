package com.test.camel.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.test.camel.db.entity.SubscribersE;

public class SubscriberDao {
 HibernateTemplate template;


public void setTemplate(HibernateTemplate template) {
	this.template = template;
}

public HibernateTemplate getTemplate() {
	return template;
}

//method to save Subscriber  
public void saveSubscriber(SubscribersE e){  
	getTemplate().save(e);  
}  
//method to update Subscriber  
public void updateSubscriber(SubscribersE e){  
	getTemplate().saveOrUpdate(e);
}  
//method to delete Subscriber  
public void deleteSubscriber(SubscribersE e){  
	
		getTemplate().delete(e);
	
}  
//method to return one Subscriber of given id  
public SubscribersE getById(int id){  
	SubscribersE e=(SubscribersE)getTemplate().get(SubscribersE.class,id);  
  return e;  
}  
//method to return all Subscriber  
public List<SubscribersE> getSubscribers(){  
  List<SubscribersE> list=new ArrayList<SubscribersE>();  
  list=getTemplate().loadAll(SubscribersE.class);  
  return list;  
}  

}
