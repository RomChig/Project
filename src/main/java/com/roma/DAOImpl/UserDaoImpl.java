package com.roma.DAOImpl;

import com.roma.DAO.UserDAO;
import com.roma.models.User;
import com.roma.utils.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Optional;

public class UserDaoImpl implements UserDAO {

    public void save(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException h) {
            System.out.println("Couldn't save user");
        }
    }

    public void delete(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (HibernateException h) {
            System.out.println("Couldn't delete user");
        }
    }

    public void update(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (HibernateException h) {
            System.out.println("Couldn't update user");
        }
    }

    @Override
    public Optional<User> findByName(String name) {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("from User where name = :name");
            query.setParameter("name", name);
            user = (User) query.getSingleResult();
        } catch (HibernateException h) {
            System.out.println("Couldn't find user by name");
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("from User where name = :id");
            query.setParameter("id", id);
            user = (User) query.getSingleResult();
        } catch (HibernateException h) {
            System.out.println("Couldn't find user by id");
        }
        return Optional.ofNullable(user);
    }
}
