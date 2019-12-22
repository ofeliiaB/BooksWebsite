package com.company;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {


        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("CAN'T OPEN DATA SOURCE");
            return;
        }

        System.out.println("Books: ");

        List<Book> books = dataSource.queryBooks(1);
        if(books == null){
            System.out.println("No books");
            return;
        }

        for(Book book: books ){
            System.out.println("ID = "+book.getId()+", Title = "+book.getTitle()+", Category Id = "
                    +book.getCategory_id()+", Publisher Id = "+book.getPublisher_id()+", Year = "
                    +book.getYear());
        }


        System.out.println("Reviews: ");

        List<Review> reviews = dataSource.queryReview(2);
        if(reviews==null){
            System.out.println("No reviews yet");
            return;
        }

        for(Review review:reviews){
                System.out.println("ID = "+review.getId()+", Name = "+review.getName()+" , Body = "
                        +review.getBody()+", Rating Score = "+review.getRating_score()+" , Member Id = "
                        +review.getMember_id()+", Book Id = "+review.getBook_id()+" , Date = "+review.getDate());


        }


        System.out.println("Book By Rating Score:");

        List<String> booksByRatingScore = dataSource.queryBooksByRatingScore(4,1);
        if(booksByRatingScore.size()==0){
            System.out.println("There are no books with the given rating score between 1 and 8");
        }
        for(String book:booksByRatingScore ){
            System.out.println(book);
        }

        List<BookCategory> bookCategories = dataSource.queryBooksByCategory("Poetry",1);
        if(bookCategories.size() == 0) {
            System.out.println("There are no books in this category yet");
            return;
        }
        for(BookCategory bookCategory: bookCategories){
            System.out.println("The book category is "+bookCategory.getCategoryName()+" , the book title is "
                    +bookCategory.getBookTitle());
        }

        int count = dataSource.getCount(DataSource.TABLE_BOOKS);
        System.out.println("Number of records is "+ count);

//        dataSource.insertMember("My New Name","NewName Username", "newname@gmail.com");

        System.out.println("New Book List");
        dataSource.insertBook("New Book 1", 1918);
        for(Book book: books ){
            System.out.println("ID = "+book.getId()+", Title = "+book.getTitle()+", Year = " +book.getYear());
        }


        dataSource.close();
    }
}
