package Dao;

import Utils.JdbcUtil;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public void add(Student student) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql="insert into student values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setString(2,student.getPwd());
            ps.setString(3,student.getEmail());
            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null,ps,conn);
        }
    }

    public void update(Student student)throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql="update student set pwd=?,email=? where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,student.getPwd());
            ps.setString(2,student.getEmail());
            ps.setString(3,student.getName());
            ps.executeUpdate();
        }finally {
            JdbcUtil.free(null,ps,conn);
        }
    }
//
    public void delete(String userName)throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "delete from student where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.executeUpdate();
        }finally {
            JdbcUtil.free(null,ps,conn);
        }
    }

    public Student findUserByName(String userName)throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student user = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from student where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new Student();
                user.setName(rs.getString(1));
                user.setPwd(rs.getString(2));
                user.setEmail(rs.getString(3));
            }
        }finally {
            JdbcUtil.free(rs,ps,conn);
        }

        return user;
    }
    public List<Student> QueryAll(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student>studentList = new ArrayList<Student>();
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setName(rs.getString(1));
                student.setPwd(rs.getString(2));
                student.setEmail(rs.getString(3));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtil.free(rs,ps,conn);
        }
        return studentList;
    }

//public ArrayList<Student> selectByCombin(String sql) throws SQLException
//{
//    Connection conn=null;
//    PreparedStatement pst=null;
//    ResultSet rs=null;
//    try {
//        ArrayList<Student> studentList=new ArrayList<Student>();
//        conn=JdbcUtil.getConnection();
//        pst=conn.prepareStatement(sql);
//        rs=pst.executeQuery(sql);
//        while(rs.next())
//        {
//            Student student=new Student();
//            student.setName(rs.getString("name"));
//            student.setPwd(rs.getString("pwd"));
//            student.setEmail(rs.getString("email"));
//            studentList.add(student);
//        }
//        return studentList;
//    } catch (Exception e) {
//        e.printStackTrace();
//        return null;
//    }
//    finally
//    {
//        JdbcUtil.free(rs, pst, conn);
//    }
//}


}
