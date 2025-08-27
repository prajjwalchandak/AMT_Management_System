import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){

        setTitle("AUTOMATIC TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text =new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Oswald", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno =new JLabel("CARD No.");
        cardno.setFont(new Font("Oswald", Font.BOLD,28));
        cardno.setBounds(120,150,400,30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);

        JLabel pin =new JLabel("PIN");
        pin.setFont(new Font("Oswald", Font.BOLD,28));
        pin.setBounds(120,220,400,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        //*******************************BUTTONS************************************

        login = new JButton("sign in");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("sign up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }

        else if (ae.getSource() == login) {
            Conn conn= new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";
        try {
            ResultSet rs = Conn.s.executeQuery(query);
            if (rs.next()){
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null,"incorrect card no or pin");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        }

        else if (ae.getSource() == signup) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
