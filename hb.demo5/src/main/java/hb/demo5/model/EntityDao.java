package hb.demo5.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class EntityDao {
	
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public EntityDao() {
		
	}
	public static void createStudents(Students obj) {
			try (Session session = getSessionFactory().openSession()) {
				session.getTransaction().begin();
				session.save(obj);
				session.getTransaction().commit();
			}
	}
	public static void createTeacher(Teacher obj) {
		try (Session session = getSessionFactory().openSession()) {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		}
	}
	
	private static SessionFactory getSessionFactory() {
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
