import java.util.List;
import java.util.Set;

public class Library {

    private List<Reader> clients;
    private List<Book> books;

    Library(List<Reader> clients, List<Book> books){
        this.clients = clients;
        this.books = books;
    }

    public void createUser(Reader reader){
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
        int length = String.valueOf(reader.getPhoneNumber()).length();
        if(length != 9){
            System.out.println("Wrong phone number");
            return;
        }
        clients.add(reader);
        System.out.println("You have added " + reader.getName() + " " + reader.getSurname());
    }

    public void readBooks(){
        for(Book bk : books){
            bk.readBook();
        }
    }

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

