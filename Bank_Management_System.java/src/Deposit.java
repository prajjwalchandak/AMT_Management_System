import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, exit;
    JTextField amount;
    String pinNumber;

    Deposit(String pinNumber){
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("enter the amount to be deposited: ");
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(200,300,300,30);
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("system",Font.BOLD,22));
        amount.setBounds(200,360,250,25);
        amount.setBackground(Color.white);
        image.add(amount);


        deposit = new JButton("Deposit");
        deposit.setBounds(360,485,150,30);
        deposit.setFont(new Font("system", Font.BOLD, 14));
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

        exit = new JButton("Exit");
        exit.setBounds(360,520,150,30);
        exit.setFont(new Font("system", Font.BOLD, 14));
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        image.add(exit);

        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(){
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the amount you want to deposit");
            }else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"deposited successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);

                }catch (Exception ae) {
                    System.out.println(ae);
                }
            }

        }else if (e.getSource()==exit){
            System.exit(0);
        }
    }
}
