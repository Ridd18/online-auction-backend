//package tech.finalproject.project.product;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Transactional
//public class ProductRepoImpl implements ProductRepo{
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public boolean addProduct(ProductDetails product) {
//        try{
//            sessionFactory.getCurrentSession().save(product);
//            return true;
//        } catch(Exception e){
//            return false;
//        }
//    }
//}
