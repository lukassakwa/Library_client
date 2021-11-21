import java.util.List;
import java.util.Set;

public class Library {
    //The class represents the library
    //Contains the following variables:
    //-list of the Reader objects - represents the clients of the library
    //-list of the Book objects - represents books available in the library

    private List<Reader> clients;
    private List<Book> books;

    //Constructor
    Library(List<Reader> clients, List<Book> books){
        this.clients = clients;
        this.books = books;
    }

    //Add the reader to the library clients
    public void createUser(Reader reader){
        //Check if the name and surname contain only letters.
        //If they don't, print a message "Wrong name or surname".
        if(clients.contains(reader)){
            System.out.println("User already exist on the list of library readers");
            return;
        }

        if(reader.getSurname() == null || reader.getName() == null)
            return;

        String fullname = reader.getSurname() + reader.getName();
        for(int i = 0; i < fullname.length(); i++){
            if(!Character.isLetter(fullname.charAt(i))){
                System.out.println("Wrong name or surname");
                return;
            }
        }
        //Check if the reader's number has exactly 9 digits.
        //If it doesn't, print a message "Wrong phone number".
        int length = String.valueOf(reader.getPhoneNumber()).length();
        if(length != 9){
            System.out.println("Wrong phone number");
            return;
        }
        //If the data are correct, add the given reader to the library clients (the list clients)
        clients.add(reader);
        //and print a message "You have added: <reader name> <reader surname>".
        System.out.println("You have added " + reader.getName() + " " + reader.getSurname());
    }

    //Print on the screen all the books in the library
    public void readBooks(){
        for(Book bk : books){
            bk.readBook();
        }
    }

    //Print on the screen all the library clients
    public void readUsers(){
        for(Reader rd : clients){
            rd.readUser();
        }
    }

    public void removeUser(Reader reader){
        clients.remove(reader);
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public List<Reader> getClients() {
        return clients;
    }

    private void setClients(List<Reader> clients) {
        this.clients = clients;
    }

    public List<Book> getBooks() {
        return books;
    }

    private void setBooks(List<Book> books) {
        this.books = books;
    }

}

