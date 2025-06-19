package book;

public class Book {
    String title;
    String author;
    double price;
    int page;

    public Book(String title,String author,double price,int page){
        this.title=title;
        this.author=author;
        this.price=price;
        this.page=page;
    }
    void readPages(int count){
        System.out.println("Read: " +count + "Pages");
    }
    void updatePrice(double newPrice){
        this.price=newPrice;
        System.out.println("Price updated:"+this.price);
    }
    void displayBookInfo(){
        System.out.println("\tBook Info!");
        System.out.println("Title:"+title);
        System.out.println("Author:"+author);
        System.out.println("Price:"+price);
        System.out.println("Page:"+page);
    }
    public static void main(String[]args){
        Book book=new Book("The secret of the Nags","Amish Tripathi",280,200);
        book.displayBookInfo();
        book.updatePrice(240);
        book.readPages(67);


    }
}

