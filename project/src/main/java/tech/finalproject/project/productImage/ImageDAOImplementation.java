//package tech.finalproject.project.productImage;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//
//@Repository("ImageDAO")
//@Transactional
//public class ImageDAOImplementation implements ImageDAO {
//
//   // private final ImageDAO imageDAO;
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    /* public ImageDAOImplementation(ImageDAO imageDAO) {
//        this.imageDAO = imageDAO;
//    } */
//
//    public void save(Image image) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(image);
//		/*session.flush();
//		session.getTransaction().commit();*/ // Try removing this part
//
//    }
//
//
//
//
////    public ProfilePicture getProfilePicture(String loginname) {
////        Session session = sessionFactory.openSession();
////        ProfilePicture profilePicture = (ProfilePicture)session.get(ProfilePicture.class, loginname);
////        return profilePicture;
////    }
//
//}
