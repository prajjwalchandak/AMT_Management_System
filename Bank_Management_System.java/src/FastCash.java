import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, cashWithdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;

    FastCash(String pinNumber){
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select withdrawl amount: ");
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(200,300,300,30);
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.setFont(new Font("system", Font.BOLD, 14));
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

        cashWithdraw = new JButton("Rs 200");
        cashWithdraw.setBounds(360,415,150,30);
        cashWithdraw.setFont(new Font("system", Font.BOLD, 14));
        cashWithdraw.setForeground(Color.black);
        cashWithdraw.addActionListener(this);
        image.add(cashWithdraw);

        fastCash = new JButton("Rs 500");
        fastCash.setBounds(170,450,150,30);
        fastCash.setFont(new Font("system", Font.BOLD, 14));
        fastCash.setForeground(Color.black);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Rs 1000");
        miniStatement.setBounds(360,450,150,30);
        miniStatement.setFont(new Font("system", Font.BOLD, 14));
        miniStatement.setForeground(Color.black);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Rs 1500");
        pinChange.setBounds(170,485,150,30);
        pinChange.setFont(new Font("system", Font.BOLD, 14));
        pinChange.setForeground(Color.black);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Rs 2000");
        balanceEnquiry.setBounds(360,485,150,30);
        balanceEnquiry.setFont(new Font("system", Font.BOLD, 14));
        balanceEnquiry.setForeground(Color.black);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Back");
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

    public static void main(String[] args){
        new FastCash("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{

                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }if (ae.getSource()!= exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"insufficient balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Rs" +amount+ "Debited Successfully" );

                setVisible(false);
                new Transaction(pinNumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}