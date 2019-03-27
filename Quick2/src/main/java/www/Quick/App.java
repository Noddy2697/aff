package www.Quick;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentName n = new StudentName();
    	n.setFname("akshay");
    	n.setLname("naudiyal");
    	
    	Address a1 = new Address();
    	a1.setStreet("abcstreet1");
    	a1.setCity("abccity1");
    	a1.setState("abcstate1");
    	a1.setPincode("abcpincode1");
    	
    	Address a2 = new Address();
    	a2.setStreet("abcstreet2");
    	a2.setCity("abccity2");
    	a2.setState("abcstate2");
    	a2.setPincode("abcpincode2");
    	
        Student s = new Student();
        
        s.setRollno(1);
        s.setName(n);
        s.setMarks(100);
        s.setHomeadd(a1);
        s.setSchooladd(a2);
        s.getListofadd().add(a1);
        s.getListofadd().add(a2);
        
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.save(s);
        
        transaction.commit();
    }
}
