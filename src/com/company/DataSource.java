package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    //DB Name
    public static final String DB_NAME = "booksWebsite.db";

    //Connection string
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/arman/IdeaProjects/BooksWebsite/src/"+DB_NAME;

    //Connection
    private Connection conn;

    //DB Table Books
    public static final String TABLE_BOOKS = "book";
    //Columns
    public static final String COLUMN_BOOKS_ID = "id";
    public static final String COLUMN_BOOKS_TITLE = "title";
    public static final String COLUMN_BOOKS_YEAR = "year";
    public static final String COLUMN_BOOKS_CATEGORY_ID = "category_id";
    public static final String COLUMN_BOOKS_PUBLISHER_ID = "publisher_id";
    //Column Indexes
    public static final int INDEX_BOOKS_ID = 1;
    public static final int INDEX_BOOKS_TITLE = 2;
    public static final int INDEX_BOOKS_YEAR = 3;
    public static final int INDEX_BOOKS_CATEGORY_ID = 4;
    public static final int INDEX_BOOKS_PUBLISHER_ID = 5;

    //DB Table Author
    public static final String TABLE_AUTHOR = "author";
    //Columns
    public static final String COLUMN_AUTHOR_ID = "id";
    public static final String COLUMN_AUTHOR_NAME = "name";
    //Column Indexes
    public static final int INDEX_AUTHOR_ID = 1;
    public static final int INDEX_AUTHOR_NAME = 2;

    //DB Table Member
    public static final String TABLE_MEMBER = "member";
    //Columns
    public static final String COLUMN_MEMBER_ID = "id";
    public static final String COLUMN_MEMBER_NAME = "name";
    public static final String COLUMN_MEMBER_EMAIL = "email";
    public static final String COLUMN_MEMBER_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_MEMBER_USERNAME = "username";
    public static final String COLUMN_MEMBER_PASSWORD = "password";
    //Column Indexes
    public static final int INDEX_MEMBER_ID = 1;
    public static final int INDEX_MEMBER_NAME = 2;
    public static final int INDEX_MEMBER_EMAIL =3;
    public static final int INDEX_MEMBER_PHONE_NUMBER = 4;
    public static final int INDEX_MEMBER_USERNAME = 5;
    public static final int INDEX_MEMBER_PASSWORD = 6;

    //DB Table Category
    public static final String TABLE_CATEGORY = "category";
    //Columns
    public static final String COLUMN_CATEGORY_ID = "id";
    public static final String COLUMN_CATEGORY_NAME = "name";
    //Column Indexes
    public static final int INDEX_CATEGORY_ID = 1;
    public static final int INDEX_CATEGORY_NAME = 2;

    //DB Table Publisher
    public static final String TABLE_PUBLISHER = "publisher";
    //Columns
    public static final String COLUMN_PUBLISHER_ID = "id";
    public static final String COLUMN_PUBLISHER_NAME = "name";
    //Column Indexes
    public static final int INDEX_PUBLISHER_ID = 1;
    public static final int INDEX_PUBLISHER_NAME = 2;

    //DB Table Review
    public static final String TABLE_REVIEW = "review";
    //Columns
    public static final String COLUMN_REVIEW_ID = "id";
    public static final String COLUMN_REVIEW_NAME = "name";
    public static final String COLUMN_REVIEW_BODY = "body";
    public static final String COLUMN_REVIEW_DATE = "date";
    public static final String COLUMN_REVIEW_RATING_SCORE = "rating_score";
    public static final String COLUMN_REVIEW_MEMBER_ID = "member_id";
    public static final String COLUMN_REVIEW_BOOK_ID = "book_id";
    //Column Indexes
    public static final int INDEX_REVIEW_ID = 1;
    public static final int INDEX_REVIEW_NAME = 2;
    public static final int INDEX_REVIEW_BODY = 3;
    public static final int INDEX_REVIEW_DATE = 4;
    public static final int INDEX_REVIEW_RATING_SCORE = 5;
    public static final int INDEX_REVIEW_MEMBER_ID = 6;
    public static final int INDEX_REVIEW_BOOK_ID = 7;

    //DB Table Enum
    public static final String TABLE_ENUM = "enum";
    //Columns
    public static final String COLUMN_ENUM_ID = "id";
    public static final String COLUMN_ENUM_STATUS = "status";
    //Column Indexes
    public static final int INDEX_ENUM_ID = 1;
    public static final int INDEX_ENUM_STATUS = 2;

    //DB Table book_author
    public static final String TABLE_BOOK_AUTHOR = "book_author";
    //Columns
    public static final String COLUMN_BA_BOOK_ID = "book_id";
    public static final String COLUMN_BA_AUTHOR_ID = "author_id";
    //Column Indexes
    public static final int INDEX_BA_BOOK_ID = 1;
    public static final int INDEX_BA_AUTHOR_ID = 2;

    //DB Table Booklist
    public static final String TABLE_BOOKLIST = "booklist";
    //Columns
    public static final String COLUMN_BOOKLIST_BOOK_ID = "book_id";
    public static final String COLUMN_BOOKLIST_MEMBER_ID = "member_id";
    //Column Indexes
    public static final int INDEX_BOOKLIST_BOOK_ID = 1;
    public static final int INDEX_BOOKLIST_MEMBER_ID = 2;

    //Sort order statemnts
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;


    //Query Strings

    public static final String QUERY_BOOKS_BY_RATING_SCORE =
            "SELECT "+TABLE_BOOKS+"."+COLUMN_BOOKS_TITLE+" FROM "
            +TABLE_BOOKS+" INNER JOIN "+TABLE_REVIEW + " ON "
            +TABLE_BOOKS+"."+COLUMN_BOOKS_ID+"="+TABLE_REVIEW+"."
            +COLUMN_REVIEW_BOOK_ID+" WHERE "+TABLE_REVIEW+"."
            +COLUMN_REVIEW_RATING_SCORE+" = \"";
     public static final String QUERY_BOOKS_BY_RATING_SCORE_SORT=
             " ORDER BY "+TABLE_BOOKS+"."+COLUMN_BOOKS_TITLE+" COLLATE NOCASE ";


     public static final String QUERY_BOOKS_BY_CATEGORY_START=
             "SELECT "+TABLE_BOOKS+"."+COLUMN_BOOKS_TITLE+", "
             +TABLE_CATEGORY+"."+COLUMN_CATEGORY_NAME+" FROM "
             +TABLE_BOOKS+" INNER JOIN "+TABLE_CATEGORY+" ON "
             +TABLE_BOOKS+"."+COLUMN_BOOKS_CATEGORY_ID+"="
             +TABLE_CATEGORY+"."+COLUMN_CATEGORY_ID
             +" WHERE "+TABLE_CATEGORY+"."+COLUMN_CATEGORY_NAME+" = \"";
     public static final String QUERY_BOOKS_BY_CATEGORY_SORT =
             " ORDER BY "+TABLE_BOOKS+"."+COLUMN_BOOKS_TITLE+" COLLATE NOCASE ";


     //Insert strings
    public static final String INSERT_BOOKS = "INSERT INTO "+TABLE_BOOKS+" ("+COLUMN_BOOKS_TITLE+", "
             +COLUMN_BOOKS_YEAR+") VALUES(?, ?)";

    public static final String INSERT_MEMBERS = "INSERT INTO "+TABLE_MEMBER+" ("
            +COLUMN_MEMBER_NAME+", "+COLUMN_MEMBER_USERNAME+", "+COLUMN_MEMBER_EMAIL
            +") VALUES (?, ?, ?)";

    public static final String INSERT_REVIEW = "";

    public static final String INSERT_CATEGORY = "";

    public static final String INSERT_PUBLISHER = "";

    public static final String INSERT_AUTHOR = "";


    //Query Strings for Insert Validation
    public static final String QUERY_BOOKS = "SELECT "+COLUMN_BOOKS_ID+" FROM "+TABLE_BOOKS
            +" WHERE "+COLUMN_BOOKS_TITLE+" = ?";

    public static final String QUERY_MEMBERS = "SELECT "+COLUMN_MEMBER_ID+" FROM "+TABLE_MEMBER
            +" WHERE "+COLUMN_MEMBER_NAME+" = ?";

    public static final String QUERY_REVIEWS = "";

    public static final String QUERY_CATEGORIES = "";

    public static final String QUERY_PUBLISHERS = "";

    public static final String QUERY_AUTHORS = "";

    //Prepared Statements
    private PreparedStatement insertIntoBooks;
    private PreparedStatement insertIntoMembers;

    private PreparedStatement queryBooks;
    private PreparedStatement queryMembers;


    //method to open db conn
    public boolean open(){

        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            insertIntoBooks = conn.prepareStatement(INSERT_BOOKS, Statement.RETURN_GENERATED_KEYS);
            insertIntoMembers = conn.prepareStatement(INSERT_MEMBERS, Statement.RETURN_GENERATED_KEYS);
            queryBooks = conn.prepareStatement(QUERY_BOOKS);
            queryMembers = conn.prepareStatement(QUERY_MEMBERS);
            return true;
        }catch(SQLException e){
            System.out.println("PROBLEM CONNECTING TO DATABASE "+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    //method to close db conn
    public void close(){
        try{
            if(conn != null){
                conn.close();
            }
            if(insertIntoBooks!=null){
                insertIntoBooks.close();
            }
            if(insertIntoMembers!=null){
                insertIntoMembers.close();
            }
            if(queryBooks!=null){
                queryBooks.close();
            }
            if(queryMembers!=null){
                queryMembers.close();
            }

        }catch(SQLException e){
            System.out.println("COULDN'T CLOSE CONNECTION TO DATABASE "+e.getMessage());
            e.printStackTrace();
        }
    }


    //method to list all books
    public List<Book> queryBooks(int sortOrder){

        //building str for sql statement
        //using StringBuilding because it creates muttable sequence of chars
        //not using StringBuffer because all is in one thread, no sync needed now
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_BOOKS);

        //sort order definitions
        if(sortOrder!=ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_BOOKS_TITLE);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else{
                sb.append("ASC");
            }
        }

        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString());

            List<Book> books = new ArrayList<>();
            while(results.next()){
                Book book  = new Book();
                book.setId(results.getInt(INDEX_BOOKS_ID));
                book.setTitle(results.getString(INDEX_BOOKS_TITLE));
                book.setYear(results.getInt(INDEX_BOOKS_YEAR));
                book.setCategory_id(results.getInt(INDEX_BOOKS_CATEGORY_ID));
                book.setPublisher_id(results.getInt(INDEX_BOOKS_PUBLISHER_ID));
                books.add(book);
            }
            return books;
        }catch(SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    //method to list reviews
    public List<Review> queryReview(int sortOrder){
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_REVIEW);

        //sort order definitions
        if(sortOrder!=ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_REVIEW_DATE);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else{
                sb.append("ASC");
            }
        }

        try{
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString());

            List<Review> reviews = new ArrayList<>();
            while(results.next()){
                Review review = new Review();
                review.setId(results.getInt(INDEX_REVIEW_ID));
                review.setName(results.getString(INDEX_REVIEW_NAME));
                review.setBody(results.getString(INDEX_REVIEW_BODY));
                review.setDate(results.getInt(INDEX_REVIEW_DATE));
                review.setRating_score(results.getInt(INDEX_REVIEW_RATING_SCORE));
                review.setBook_id(results.getInt(INDEX_REVIEW_BOOK_ID));
                review.setMember_id(results.getInt(INDEX_REVIEW_MEMBER_ID));
                reviews.add(review);
            }
            return reviews;
        }catch(SQLException e){
            System.out.println("QUERY FAILED "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //method to execute sql query =>
    //"SELECT book.title FROM book
    // INNER JOIN review ON book.id = review.book_id
    // WHERE review.rating_score=
    // ORDER BY book.title COLLATE NOCASE DESC"
    //lists books with a rating score of 7 ordered by book title desc

    public List<String> queryBooksByRatingScore(int ratingScore, int sortOrder){
        StringBuilder sb = new StringBuilder(QUERY_BOOKS_BY_RATING_SCORE);
        sb.append(ratingScore);
        sb.append("\"");

        if(sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_BOOKS_BY_RATING_SCORE_SORT);
            if(sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }
        System.out.println("SQL statement = " + sb.toString());

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString());
        ){
            List<String> books = new ArrayList<>();
            while(results.next()){
                books.add(results.getString(COLUMN_BOOKS_TITLE));
            }
               return books;
        }catch(SQLException e){
            System.out.println("QUERY FAILED "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Category> queryCategories(int sortOrder){
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_CATEGORY);

        //sort order definitions
        if(sortOrder!=ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_CATEGORY_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else{
                sb.append("ASC");
            }
        }

        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString());
            List<Category> categories = new ArrayList<>();
            while(results.next()) {
                Category category = new Category();
                category.setId(results.getInt(INDEX_CATEGORY_ID));
                category.setName(results.getString(INDEX_CATEGORY_NAME));
                categories.add(category);
            }
            return categories;
        } catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<BookCategory> queryBooksByCategory(String categoryName, int sortOrder){

        StringBuilder sb = new StringBuilder(QUERY_BOOKS_BY_CATEGORY_START);
        sb.append(categoryName);
        sb.append("\"");

        if(sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_BOOKS_BY_CATEGORY_SORT);
            if(sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        System.out.println("SQL Statement: " + sb.toString());

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())){

            List<BookCategory> bookCategories = new ArrayList<>();

            while(results.next()){
                BookCategory bookCategory = new BookCategory();
                bookCategory.setBookTitle(results.getString(COLUMN_BOOKS_TITLE));
                bookCategory.setCategoryName(results.getString(COLUMN_CATEGORY_NAME));
                bookCategories.add(bookCategory);
            }
            return bookCategories;
        }catch(SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //view
    public int getCount(String table){
        String sql = "SELECT COUNT (*) FROM "+table;

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sql)){

            int count = results.getInt(1);
            return count;
        }catch(SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    //insert methods

    public int insertBook(String title, int year) throws SQLException{
        queryBooks.setString(1, title);
        queryBooks.setInt(1, year);

        ResultSet results = queryBooks.executeQuery();
        if(results.next()){
            return results.getInt(1);
        }else {
            //insert book
            insertIntoBooks.setString(1,title);
            insertIntoBooks.setInt(2,year);
            int affectedRows = insertIntoBooks.executeUpdate();
            if(affectedRows!=1){
                throw new SQLException("Could't insert the book, sorry ");
            }

            ResultSet generatedKeys = insertIntoBooks.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }else {
                throw new SQLException("Could't get the id key for the book");
            }
        }
    }

    public int insertMember(String name, String username, String email) throws SQLException{

        queryMembers.setString(1, name);
        queryMembers.setString(1, username);
        queryMembers.setString(1, email);


        ResultSet results = queryMembers.executeQuery();

        if(results.next()){
            return results.getInt(1);
        }else {
            //insert member
            insertIntoMembers.setString(1,name);
            insertIntoMembers.setString(2,username);
            insertIntoMembers.setString(3,email);

            int affectedRows = insertIntoMembers.executeUpdate();
            if(affectedRows!=1){
                throw new SQLException("Could't insert the member, sorry ");
            }

            ResultSet generatedKeys = insertIntoMembers.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }else {
                throw new SQLException("Could't get the id key for the member");
            }
        }
    }


}
