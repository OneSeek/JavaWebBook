package Dao;

import Utils.JdbcUtil;
import model.Book;
import model.Lend;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public void add(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql="insert into book values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,book.getNo());
            ps.setString(2,book.getName());
            ps.setString(3,book.getAuthor());
            ps.setString(4,book.getDescription());
            ps.setString(5,book.getLent());
            ps.setString(6,book.getIsbn());
            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null,ps,conn);
        }
    }

    public void update(Book book)throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql="update book set name=?,author=?,description=?,lent=?,isbn=? where no=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,book.getName());
            ps.setString(2,book.getAuthor());
            ps.setString(3,book.getDescription());
            ps.setString(4,book.getLent());
            ps.setString(5,book.getIsbn());
            ps.setString(6,book.getNo());
            ps.executeUpdate();
        }finally {
            JdbcUtil.free(null,ps,conn);
        }
    }
    //
    public void delete(String bookNo)throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "delete from book where no=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,bookNo);
            ps.executeUpdate();
        }finally {
            JdbcUtil.free(null,ps,conn);
        }
    }

    public Book findUserByNo(String bookNo)throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book book = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from book where no=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,bookNo);
            rs = ps.executeQuery();
            if(rs.next()){
                book = new Book();
                book.setNo(rs.getString(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setDescription(rs.getString(5));
                book.setLent(rs.getString(6));
                book.setIsbn(rs.getString(4));
            }
        }finally {
            JdbcUtil.free(rs,ps,conn);
        }

        return book;
    }
    public Book findUserByName(String bookName)throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book book = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from book where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,bookName);
            rs = ps.executeQuery();
            if(rs.next()){
                book = new Book();
                book.setNo(rs.getString(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setIsbn(rs.getString(4));
                book.setDescription(rs.getString(5));
                book.setLent(rs.getString(6));

            }
        }finally {
            JdbcUtil.free(rs,ps,conn);
        }

        return book;
    }
    public List<Book> QueryAll(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book>bookList = new ArrayList<Book>();
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from book";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Book book = new Book();
                book.setNo(rs.getString(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setIsbn(rs.getString(4));
                book.setDescription(rs.getString(5));
                book.setLent(rs.getString(6));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtil.free(rs,ps,conn);
        }
        return bookList;
    }



}
