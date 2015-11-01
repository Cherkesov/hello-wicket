package com.gfb.hellowicket.dao.hibernate;

import com.gfb.hellowicket.dao.IBaseDao;
import com.gfb.hellowicket.domain.User;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 01.11.2015.
 */
public class UserDaoImpl extends HibernateDaoSupport implements IBaseDao<User> {
    /*@Override
    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        HibernateTemplate result = super.createHibernateTemplate(sessionFactory);
        result.setAllowCreate(false);
        return result;
    }*/

    @Override
    public List<User> load() {
//        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
//        return (List<User>) getHibernateTemplate().findByCriteria(criteria);

        List<?> empList = getHibernateTemplate().find("from User");
        System.out.println("User found: " + empList.size());
        return (List<User>) empList;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public void create(User entity) {
        /*Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }*/
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(long id) {

    }
}
