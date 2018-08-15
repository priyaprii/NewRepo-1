package com.myfirstproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

import com.myfirstproject.Service.UserManager;

import com.myfirstproject.entity.User;

/**
 * @author s6
 *
 */
/**
 * @author s6
 *
 */
@SuppressWarnings("unused")
@Component
@Scope("singleton")
public class UserDAOImpl implements UserDAO {

	private Logger LOG = Logger.getLogger(UserDAOImpl.class);
	Session session = null;
	private static HibernateTemplate ht;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.ht = new HibernateTemplate(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser() {
		try {
			List<User> user = ht.find("from User u");
			User use = user.get(0);
			return use;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


}
