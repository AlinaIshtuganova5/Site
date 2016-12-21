package ru.kpfu.itis.Alina.repositories;

import ru.kpfu.itis.Alina.models.Book;
import ru.kpfu.itis.Alina.utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 28.10.2016.
 */
public class BookRepository {

    public static List<Book> getRecords(int start, int total) {
        List<Book> bookList = new ArrayList<Book>();
        try {
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from products order by product_id desc limit " + total + "offset " + (start - 1));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("product_name"));
                book.setId(rs.getLong("product_id"));
                book.setPrice(rs.getInt("price"));
                book.setPublisher(rs.getString("publisher"));
                book.setAuthor(rs.getString("author"));
                book.setImage(rs.getString("image"));
                book.setEdition(rs.getInt("edition"));
                book.setIsbn(rs.getString("isbn"));
                book.setLanguage(rs.getString("language"));
                book.setPages(rs.getInt("page"));
                book.setWeight(rs.getInt("weight"));
                book.setYear(rs.getInt("year"));
                bookList.add(book);
            }
        } catch (Exception ex) {
        }
        return bookList;
    }
}