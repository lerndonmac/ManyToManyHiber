package service;

import DAO.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Author;

import javax.persistence.Query;
import java.util.List;

public class AuthorService implements DAO<Author, Integer> {

    private final SessionFactory factory;

    public AuthorService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Author author) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        }

    }

    @Override
    public Author read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Author.class, id);
        }
    }

    @Override
    public List<Author> readByAll() {
        try(Session session = factory.openSession()){
            String hql = "FROM Author";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(Author author) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(author);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Author author) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(author);
            session.getTransaction().commit();
        }
    }
}
