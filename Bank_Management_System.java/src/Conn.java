import java.sql.*;

public  class Conn  {
    Connection c;
    static Statement s;

    public Conn(){

        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem ", "root", "Prajjwal1@");
            s = c.createStatement();
            System.out.println("connected");

        }catch (SQLException e){
            System.out.println(e);
        }
    }
}