package IntershipTasks;
import java.util.*;

public class User {
    private static int idCounter=1;
    private int userId;
    private String name;
    private ArrayList<Book> issuedBooks;
    public User(String name){
        this.name=name;
        this.userId=idCounter++;
        this.issuedBooks=new ArrayList<>();
    }
    public int getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }
    public void issueBook(Book book){
        issuedBooks.add(book);
    }
    public void returnBook(Book book){
        issuedBooks.remove(book);
    }
}
