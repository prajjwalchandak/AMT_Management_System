import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, cashWithdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;

    Transaction(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.setFont(new Font("system", Font.BOLD, 14));
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

        cashWithdraw = new JButton("Cash Withdraw");
        cashWithdraw.setBounds(360, 415, 150, 30);
        cashWithdraw.setFont(new Font("system", Font.BOLD, 14));
        cashWithdraw.setForeground(Color.black);
        cashWithdraw.addActionListener(this);
        image.add(cashWithdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.setFont(new Font("system", Font.BOLD, 14));
        fastCash.setForeground(Color.black);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(360, 450, 150, 30);
        miniStatement.setFont(new Font("system", Font.BOLD, 14));
        miniStatement.setForeground(Color.black);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.setFont(new Font("system", Font.BOLD, 14));
        pinChange.setForeground(Color.black);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(360, 485, 150, 30);
        balanceEnquiry.setFont(new Font("system", Font.BOLD, 14));
        balanceEnquiry.setForeground(Color.black);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(360, 520, 150, 30);
        exit.setFont(new Font("system", Font.BOLD, 14));
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        image.add(exit);


        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource() == cashWithdraw) {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if (ae.getSource() == miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transaction("").setVisible(true);
    }
}


