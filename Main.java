//package hb.demo1;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import hb.demo1.model.Book;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class Main {
//
//	private static StandardServiceRegistry registry;
//	private static SessionFactory sessionFactory;
//
//	public static void main(String[] args) {
//		Transaction transaction = null;
//
//		try (Session session = getSessionFactory().openSession()) {
//			transaction = session.beginTransaction();
//			Book b = new Book(100, "Halo Envoy", "Eric Nylund", 999);
//			session.save(b);
//			transaction.commit();
//		}
//	}
//
//	public static SessionFactory getSessionFactory() {
//		if (sessionFactory == null) {
//			registry = new StandardServiceRegistryBuilder().configure().build();
//			MetadataSources sources = new MetadataSources(registry);
//			Metadata metadata = sources.getMetadataBuilder().build();
//			sessionFactory = metadata.getSessionFactoryBuilder().build();
//		}
//		return sessionFactory;
//	}
//	public static void shutdown() {
//		if(registry !=null) {
//			StandardServiceRegistryBuilder.destroy(registry);
//		}
//	}


package hb.demo1;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import hb.demo1.model.Book;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		//populate();
			
		//update(1);
		delete(6);
		System.out.println("After updating..");
		List<Book> books  =  read();
		for (Book book : books) {
			System.out.println(book);
		}
		shutdown();

	}
	
	public static void populate() {
		create(1, "Halo Envoy", "Eric Nylund", 1);
		create(2, "Halo First ", "Eric Nylund", 2);
		create(3, "Halo Smoke ", "Kelly Gay", 3);
		create(4, "Halo Renegades", "Kelly Gay", 4);
		create(5, "Halo Last ", "Troy Dennigs", 5);
		create(6, "Halo Silent ", "Troy Dennigs", 6);
	}
	
	public static void create(int id, String title, String author, int isbn) {
		Transaction transaction = null;
		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Book b = new Book(id, title, author, isbn);
			session.save(b);
			transaction.commit();
		}
	}
	
	public static List<Book> read(){
		List<Book> books = null;
		try (Session session = getSessionFactory().openSession()) {
			Query<Book> q =  session.createQuery("select b from Book b", Book.class);
			books = q.getResultList();
		}
		return books;
	}
	
	public static void update(int id) {
		try (Session session = getSessionFactory().openSession()) {
			Book b = session.get(Book.class, id);
			b.setAuthor("Troy Dennig");
			session.getTransaction().begin();
			session.update(b);
			session.getTransaction().commit();
			System.out.println(session.getTransaction().getStatus().toString());
		}
	}
	
	public static void delete(int id) {
		try (Session session = getSessionFactory().openSession()) {
			Transaction t  = null;
			try {
				Book b = session.get(Book.class, id);
				t = session.getTransaction();
				t.begin();
				session.delete(b);
				t.commit();
			}catch(Exception ex) {
				t.rollback();
				ex.printStackTrace();
			}
			
		}
	}
	


	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
//}