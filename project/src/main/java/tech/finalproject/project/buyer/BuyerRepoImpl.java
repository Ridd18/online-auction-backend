//package tech.finalproject.project.buyer;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional
//public class BuyerRepoImpl implements BuyerRepo{
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public boolean addBuyer(BuyerRepo buyer) {
//        try{
//            sessionFactory.getCurrentSession().save(buyer);
//            return true;
//        } catch(Exception e){
//            return false;
//        }
//    }
//
//    @Override
//    public boolean delete(BuyerRepo buyer) {
//        try{
//            sessionFactory.getCurrentSession().delete(buyer);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//    }
//
//    public boolean getBuyers(BuyerRepo buyer) {
//        try{
//            sessionFactory.getCurrentSession().get(<BuyerLoginDetails>, buyer);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//    }
//}
