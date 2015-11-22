/**
 * 
 */
package org.julengarcia.hibernate.airlines.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.julengarcia.hibernate.airlines.HibernateSession;
import org.julengarcia.hibernate.airlines.models.Pilot;

public class PilotDAO implements PilotDAOInterface {

	public Pilot selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Pilot pilot = (Pilot) session.get(Pilot.class, id);
	    
	    session.close();
	    return pilot;
	}

	public List<Pilot> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Pilot> pilots = session.createQuery("from Pilot").list();
	    
	    session.close();
	    return pilots;
	}
	
	public void insert(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    session.persist(pilot);
	         
	    session.getTransaction().commit();
	    session.close();

	}

	public void update(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(pilot);
		 
		    session.getTransaction().commit();
		    session.close();
	}
	
	public void delete(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(pilot);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
