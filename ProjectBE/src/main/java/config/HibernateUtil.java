package config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import model.entity.Product;

public class HibernateUtil {
	   private static StandardServiceRegistry registry;
	   private static SessionFactory sessionFactory;

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory == null) {
	         try {

	            // Create registry builder
	            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

	            // Hibernate settings equivalent to hibernate.cfg.xml's properties
	            Map<String, String> settings = new HashMap<String, String>();
	            settings.put(Environment.DRIVER, "org.h2.Driver");
	            settings.put(Environment.URL, "jdbc:h2:tcp://localhost/~/ShoppingDB");
	            settings.put(Environment.USER, "sa");
	            settings.put(Environment.PASS, "sa@123");
	            settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
	            settings.put(Environment.HBM2DDL_AUTO, "update");
	            settings.put(Environment.SHOW_SQL, "true");

	            // Apply settings
	            registryBuilder.applySettings(settings);

	            // Create registry
	            registry = registryBuilder.build();

	            // Create MetadataSources
	            MetadataSources sources = new MetadataSources(registry);
	            sources.addAnnotatedClass(Product.class);
	            // Create Metadata
	            Metadata metadata = sources.getMetadataBuilder().build();
	            

	            // Create SessionFactory
	            sessionFactory = metadata.getSessionFactoryBuilder().build();
	            

	         } catch (Exception e) {
	            e.printStackTrace();
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	         }
	      }
	      return sessionFactory;
	   }

	   public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }
}
