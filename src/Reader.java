import java.util.List;
import java.util.Objects;

public class Reader {

    private String name;
    private String surname;
    private int age;
    private int phoneNumber;
    private List<Book> books;

    public Reader(String name, String surname, int age, int phoneNumber, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.books = books;
    }

    public void readUser(){
        System.out.println("Name: "+name+" / Surname: "+surname);
        System.out.println("Age: "+age+" / Phone number: "+phoneNumber);
        System.out.println("Borrowed books: "+books.size());
    }

    public void readBorrowedBooks(){
        for(Book br : books){
            br.readBook();
        }
    }

    public void removeUser(Library lib){
        if(!lib.getClients().contains(this)){
            System.out.println("User does not exist on the list of library readers");
            return;
        }
        if(books.size() != 0){
            System.out.println("You haven't return all the books yet");
        }else{
            lib.removeUser(this);
            System.out.println("You've deleted your account");
        }
    }

    public void borrowBook(Book book, Library lib){
        if(books.size() +1 > 3){
            System.out.println("You can't have more than three books borrowed");
            return;
        }
        if(lib.getBooks().contains(book)){
            books.add(book);
            lib.removeBook(book);
            System.out.println("You've borrowed " + book.getTitle());
        }else{
            System.out.println("The library does not have this book");
        }
    }

    public void returnBook(Book book, Library lib){
        books.remove(book);
        lib.addBook(book);
    }

    public void changePhoneNumber(int phoneNumber){
        int length = String.valueOf(phoneNumber).length();
        if(length != 9){
            System.out.println("Wrong phone number");
            return;
        }

        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private List<Book> getBooks() {
        return books;
    }

    private void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return age == reader.age && phoneNumber == reader.phoneNumber && name.equals(reader.name) && surname.equals(reader.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, phoneNumber);
    }
}