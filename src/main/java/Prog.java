import DAO.DAO;
import model.Author;
import model.Book;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.AuthorService;
import service.BookService;

import java.util.*;

public class Prog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Book, Integer> DAOBook = new BookService(factory);
        DAO<Author, Integer> DAOAuthor = new AuthorService(factory);
        List<Book> bookArrayList = new ArrayList<>();
        List<Author> authorArrayList = new ArrayList<>();


        System.out.println("choose create table (book/author) or \"othet\"");
        String tableChoose = scanner.nextLine();
        if (tableChoose.equals("book")){
            String choose = scanner.nextLine();
            if (choose.equals("c")){
            String bookName="";
            while (bookName.equals("")){
                System.out.println("inter book name");
                bookName = scanner.nextLine();
            }
            String bookYear="";
            while (bookYear.equals("")){
                System.out.println("inter book year of publish");
                bookYear = scanner.nextLine();
            }

                Author author = new Author();

                Set<Author> authors = new HashSet<>();


            Set<Book> books = new HashSet<>();


                bookArrayList = DAOBook.readByAll();
                for (Book book: bookArrayList){
                    System.out.print("Books: ");
                    System.out.printf("%s \n",book.toString());
                }
                System.out.println("choose id of writed book");
                int idBook = scanner.nextInt();
            Book book = DAOBook.read(idBook);
            book.setName(bookName);
            book.setYearOfPublish(bookYear);
            authors.add(author);
            books.add(book);

            book.setAuthors(authors);


            DAOBook.create(book);

                factory.close();
            }
        }
        if (tableChoose.equals("author")){

                String authorLastName="";
                while (authorLastName.equals("")){
                    System.out.println("inter author last name");
                    authorLastName = scanner.nextLine();
                }
                String authorFirstName="";
                while (authorFirstName.equals("")){
                    System.out.println("inter author first name");
                    authorFirstName = scanner.nextLine();
                }
                String authorOtchestvo="";
                while (authorOtchestvo.equals("")){
                    System.out.println("inter author otchestvo");
                    authorOtchestvo = scanner.nextLine();
                }

                Author author = new Author();
                author.setFirstName(authorFirstName);
                author.setLastName(authorLastName);
                author.setOtchestvo(authorOtchestvo);
                Set<Author> authors = new HashSet<>();

                DAOAuthor.create(author);

                factory.close();
        }

                System.out.println("choose what to do (r/u/d)");
    String choose = scanner.nextLine();
        if (choose.equals("r")){
            authorArrayList = DAOAuthor.readByAll();
            bookArrayList = DAOBook.readByAll();
            for (Author author: authorArrayList){
                System.out.print("Authors: ");
                System.out.printf("%s \n",author.toString());
            }
            for (Book book: bookArrayList){
                System.out.print("Books: ");
                System.out.printf("%s \n",book.toString());
            }
            factory.close();

        }
        if (choose.equals("d")){
            authorArrayList = DAOAuthor.readByAll();
            bookArrayList = DAOBook.readByAll();
            for (Author author: authorArrayList){
                System.out.print("Authors: ");
                System.out.printf("%s \n",author.toString());
            }
            for (Book book: bookArrayList){
                System.out.print("Books: ");
                System.out.printf("%s \n",book.toString());
            }

            String authorLastName="";
            while (authorLastName.equals("")){
                System.out.println("inter author last name");
                authorLastName = scanner.nextLine();
            }
            String authorFirstName="";
            while (authorFirstName.equals("")){
                System.out.println("inter author first name");
                authorFirstName = scanner.nextLine();
            }
            String authorOtchestvo="";
            while (authorOtchestvo.equals("")){
                System.out.println("inter author otchestvo");
                authorOtchestvo = scanner.nextLine();
            }




            String bookName="";
            while (bookName.equals("")){
                System.out.println("inter book name");
                bookName = scanner.nextLine();
            }
            String bookYear="";
            while (bookYear.equals("")){
                System.out.println("inter book year of publish");
                bookYear = scanner.nextLine();
            }
            Author author = new Author();
            author.setFirstName(authorFirstName);
            author.setLastName(authorLastName);
            author.setOtchestvo(authorOtchestvo);
            Set<Author> authors = new HashSet<>();
            Set<Book> books = new HashSet<>();

            Book book = new Book();
            book.setName(bookName);
            book.setYearOfPublish(bookYear);
            authors.add(author);
            books.add(book);

            book.setAuthors(authors);

            author.setBooks(books);

            DAOAuthor.delete(author);
            DAOBook.delete(book);
        }

        factory.close();
    }

}
