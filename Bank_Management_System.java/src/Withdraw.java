import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    JButton withdraw, exit;
    JTextField amount;
    String pinNumber;

    Withdraw(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("enter the amount to be withdrawn: ");
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(200,300,300,30);
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("system",Font.BOLD,22));
        amount.setBounds(200,360,250,25);
        amount.setBackground(Color.white);
        image.add(amount);


        withdraw = new JButton("Withdraw");
        withdraw.setBounds(360,485,150,30);
        withdraw.setFont(new Font("system", Font.BOLD, 14));
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        image.add(withdraw);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number.isEmpty()){
                JOptionPane.showMessageDialog(null,"please enter the amount you want to deposit");
            }else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"withdrawn successfully");

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
    public static void main(){
        new Withdraw("");
    }
}
