package service;

import DAO.DAO;
import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class BookService implements DAO<Book, Integer> {
    private final org.hibernate.SessionFactory factory;

    public BookService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Book book) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        }

    }

    @Override
    public Book read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Book.class, id);
        }
    }

    @Override
    public List<Book> readByAll() {
        try(Session session = factory.openSession()){
            String hql = "FROM Book";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(Book book) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Book book) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
        }
    }
}
