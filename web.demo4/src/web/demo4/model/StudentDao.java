package web.demo4.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import web.demo4.model.Student;

public class StudentDao {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static void create(Student obj) {
		// Transaction transaction = null;
		try (Session session = getSessionFactory().openSession()) {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		}
	}

	public static void delete_table(String nm) {
		System.out.println("Nm is "+nm);
		try (Session session = getSessionFactory().openSession()) {
			Query query = session.createQuery("delete from Student e where e.name = :nm ");
			session.getTransaction().begin();
			query.setParameter("nm", nm);
			System.out.println(query.executeUpdate());
			session.getTransaction().commit();
			
		}
	}
	
	public static void update_table(String nm) {
		System.out.println("Nm is "+nm);
		try (Session session = getSessionFactory().openSession()) {
			Query query = session.createQuery("update Student e set e.email = :email where e.name = :nm ");
			session.getTransaction().begin();
			query.setParameter("email", "hello");
			query.setParameter("nm", nm);
			System.out.println(query.executeUpdate());
			session.getTransaction().commit();
			
		}
	}

	public static List<Student> Display() {
		String query = "select e from Student e";
		List<Student> stud = null;

		try (Session session = getSessionFactory().openSession()) {
			Query<Student> q = session.createQuery(query, Student.class);
			stud = q.getResultList();
		}
		return stud;
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
