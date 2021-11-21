import java.util.List;
import java.util.Objects;

public class Reader {
    /*The class represents a single reader
    Contains the following variables:
    -name as String
    -surname as String
    -age as int
    -phoneNumber as int
    -books as the list of Book objects (the books that reader borrowed)

    */

    private String name;
    private String surname;
    private int age;
    public int phoneNumber;
    private List<Book> books;

    //Constructor
    public Reader(String name, String surname, int age, int phoneNumber, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.books = books;
    }

    //Print on the screen information about a single reader
    public void readUser(){
        System.out.println("Name: "+name+" / Surname: "+surname);
        System.out.println("Age: "+age+" / Phone number: "+phoneNumber);
        System.out.println("Borrowed books: "+books.size());
    }

    //Print on the screen all borrowed books
    public void readBorrowedBooks(){
        for(Book br : books){
            br.readBook();
        }
    }

    //Remove the reader from the library clients
    public void removeUser(Library lib){
        //Check if the reader has returned all the books.
        //If the reader hasn't returned all the books, print a message "You haven't return all the books yet".
        //If the reader has returned all the books, remove them from the library clients (the list of readers in the class Library)
        //and print a message "You've deleted your account".
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
        //If the reader already has three books borrowed, don't let them borrow this book
        //and print a message "You can't have more than three books borrowed".
        if(books.size() +1 > 3){
            System.out.println("You can't have more than three books borrowed");
            return;
        }
        //If the reader has less than three books borrowed,
        //add the book to their list of books and remove it from the library (the list of books in the class Library)
        //and print a message "You've borrowed <book title>".
        if(lib.getBooks().contains(book)){
            books.add(book);
            lib.removeBook(book);
            System.out.println("You've borrowed " + book.getTitle());
        }else{
            System.out.println("The library does not have this book");
        }
    }

    public void returnBook(Book book, Library lib){
        //Remove the given book from the reader's  books
        //and add it back to the library's books
        books.remove(book);
        lib.addBook(book);
    }

    public void changePhoneNumber(int phoneNumber){
        //If the given number has exactly 9 digits, change the reader's number
        //Otherwise print a message "Wrong phone number".
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