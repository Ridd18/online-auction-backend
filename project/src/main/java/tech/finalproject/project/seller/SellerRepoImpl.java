//package tech.finalproject.project.seller;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional
//public class SellerRepoImpl implements SellerRepo{
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public boolean addSeller(SellerLoginDetails seller) {
//        try{
//            sessionFactory.getCurrentSession().save(seller);
//            return true;
//        }catch(Exception e){
//            return false;
//        }
//    }
//}
