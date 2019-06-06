package model;

public class Lend {
    private String bookno;
    private String bookname;
    private String starttime;
    private String outtime;
    private String studentname;
    public Lend(){}

    public Lend(String bookno, String bookname, String starttime, String outtime, String studentname) {
        this.bookno = bookno;
        this.bookname = bookname;
        this.starttime = starttime;
        this.outtime = outtime;
        this.studentname = studentname;
    }

    public String getBookno() {
        return bookno;
    }

    public void setBookno(String bookno) {
        this.bookno = bookno;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
}
