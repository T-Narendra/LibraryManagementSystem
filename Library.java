package IntershipTasks;
import java.util.*;
public class Library {
    ArrayList<Book> books=new ArrayList<>();
    public void addBook(Book book){
        books.add(book);
    }
    public void showAllBooks(){
        System.out.println("All Books in the Library:");
        for(Book b: books){
            System.out.println(b);
        }
    }
    public void showAvailableBooks(){
        System.out.println("Available Books in the Library:");
        for(Book b: books){
            if(!b.isIssued())
                System.out.println(b);
        }
    }
    public Book findBookByTitle(String title){
        for(Book b: books){
            if(b.getTitle().equalsIgnoreCase(title)){
                return b;
            }
        }
        return null;
    }
    public ArrayList<Book> searchBooks(String keyword){
        ArrayList<Book> result =new ArrayList<>();
        for(Book b:books){
            if(b.getTitle().toLowerCase().contains(keyword.toLowerCase()) || b.toString().toLowerCase().contains(keyword.toLowerCase())){
                result.add(b);
            }
        }
        return result;
    }

}
