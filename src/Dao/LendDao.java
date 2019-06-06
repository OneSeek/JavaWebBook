package Dao;

import Utils.JdbcUtil;
import model.Book;
import model.Lend;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LendDao {

    public void Lend(Book book, Student student)throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = JdbcUtil.getConnection();

            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式

            String time = dateFormat.format( now );

            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, 30);
            String outtime = dateFormat.format(c.getTime());

            String sql = "insert into lend value (?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,book.getNo());
            ps.setString(2,book.getName());
            ps.setString(3,time);
            ps.setString(4,outtime);
            ps.setString(5,student.getName());
            ps.executeUpdate();

            String sql1 = "update book set lent='0' where no=?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1,book.getNo());
            ps.executeUpdate();
        }finally {
            JdbcUtil.free(null,ps,conn);
        }
    }
    public void Return(Book book,Student student)throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();

            ps = conn.prepareStatement("select * from lend where bookno=? and studentname=?");
            ps.setString(1,book.getNo());
            ps.setString(2,student.getName());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){


                String sql="update book set lent=1 where no=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,book.getNo());
                ps.executeUpdate();

                String sql2 ="delete from lend where bookno=? and studentname=?";
                ps = conn.prepareStatement(sql2);
                ps.setString(1,book.getNo());
                ps.setString(2,student.getName());
                ps.executeUpdate();


            }


        }finally {
            JdbcUtil.free(null,ps,conn);
        }
    }
    public List<Lend> LendQueryAll(String studentname){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Lend>bookList = new ArrayList<Lend>();
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from lend where studentname=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,studentname);
            rs = ps.executeQuery();
            while(rs.next()) {
                Lend lend = new Lend();
                lend.setBookno(rs.getString(1));
                lend.setBookname(rs.getString(2));
                lend.setStarttime(rs.getString(3));
                lend.setOuttime(rs.getString(4));
                lend.setStudentname(rs.getString(5));
                bookList.add(lend);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtil.free(rs,ps,conn);
        }
        return bookList;
    }
}
