import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinNumber;

    BalanceEnquiry(String pinNumber){

        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("back");
        back.setFont(new Font("system",Font.BOLD, 14));
        back.setBounds(410, 490,100,25);
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
        int balance = 0;

        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("your current account balance is : Rs "+balance);
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        image.add(text);


        setSize(900,900);
        setLocation(300,0);
        setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }

    }
    public static void main(String[] args){
        new BalanceEnquiry("");
    }

}
