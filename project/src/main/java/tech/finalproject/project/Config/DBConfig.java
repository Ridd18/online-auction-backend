//package tech.finalproject.project.Config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import tech.finalproject.project.productImage.Image;
//
//
//@Configuration
//@ComponentScan("tech.finalproject.project")
//@EnableTransactionManagement
//public class DBConfig {
//
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/auction");
//        dataSource.setUsername("root");
//        dataSource.setPassword("Ridd18");
//        System.out.println("DataSource object created");
//        return dataSource;
//    }
//
//    @Bean(name="sessionFactory")
//    public SessionFactory getSessionFactory() {
//        Properties hibernateProp = new Properties();
//        hibernateProp.put("hibernate.hbm2ddl.auto", "update");
//        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
//        hibernateProp.put("spring.jpa.show-sql","true");
//        // hibernateProp.put("hibernate.current_session_context_class", "thread"); // Remove this if there is any problem with Hibernate session
//        // hibernateProp.put("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults", "false");
//
//        LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
//        factoryBuilder.addProperties(hibernateProp);
//
//
//        factoryBuilder.addAnnotatedClass(Image.class);
//
//        SessionFactory sessionFactory = factoryBuilder.buildSessionFactory();
//        System.out.println("SessionFactory object created");
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
//        System.out.println("TransactionManager object created");
//        return new HibernateTransactionManager(sessionFactory);
//    }
//
//}
