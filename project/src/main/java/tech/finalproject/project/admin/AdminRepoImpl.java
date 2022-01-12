//package tech.finalproject.project.admin;
//
//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository("AdminDetailsDAO")
//@Transactional
//public class AdminRepoImpl implements AdminRepo{
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public boolean addAdmin(AdminDetails admin) {
//        try {
//            sessionFactory.getCurrentSession().save(admin);
//            return true;
//        }
//        catch(Exception e){
//            return false;
//        }
//    }
//
//    @Override
//    public boolean deleteAdmin(AdminDetails admin) {
//        try{
//            sessionFactory.getCurrentSession().delete(admin);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
