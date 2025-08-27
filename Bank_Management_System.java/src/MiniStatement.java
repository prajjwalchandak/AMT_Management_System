import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{

    String pinNumber;

    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,250,250);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn conn = new Conn();
            ResultSet rs =  conn.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"'");
            while (rs.next()){
                card.setText("card number"+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("your current balance in Rs "+ bal);

        }catch (Exception ae){
            System.out.println(ae);
        }



        setSize(450,550);
        setLocation(20,20);
        setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args){
        new MiniStatement("");
    }
}
