import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {

    String pinNumber;
    JPasswordField newPin, rePin;
    JButton change, back;

    PinChange(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your PIN: ");
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(250,280,300,30);
        text.setForeground(Color.white);
        image.add(text);

        JLabel newPinText = new JLabel("New PIN: ");
        newPinText.setFont(new Font("system",Font.BOLD,16));
        newPinText.setBounds(170,320,180,25);
        newPinText.setForeground(Color.white);
        image.add(newPinText);

        newPin = new JPasswordField();
        newPin.setBounds(350 ,320,150,25);
        newPin.setBackground(Color.white);
        image.add(newPin);

        JLabel rePinText = new JLabel("Re-enter New PIN: ");
        rePinText.setFont(new Font("system",Font.BOLD,16));
        rePinText.setBounds(170,360,150,25);
        rePinText.setForeground(Color.white);
        image.add(rePinText);

        rePin = new JPasswordField();
        rePin.setBounds(350 ,360,150,25);
        rePin.setBackground(Color.white);
        image.add(rePin);

        change= new JButton("CHANGE");
        change.setFont(new Font("system",Font.BOLD, 14));
        change.setBounds(410, 490,100,25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setFont(new Font("system",Font.BOLD, 14));
        back.setBounds(410, 520,100,25);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setBackground(Color.white);
//        setUndecorated(true);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource()==change){
            try{

            String npin = newPin.getText();
            String rpin = rePin.getText();

            if (!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if (npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter PIN");
                return;
            }
            if (rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter PIN");
                return;
            }

            Conn conn = new Conn();
            String query1 = "update bank set pin ='"+rpin+"' where pin ='"+pinNumber+"' ";
            String query2 = "update login set pinNumber ='"+rpin+"' where pinNumber ='"+pinNumber+"' ";
            String query3 = "update account_details set pinNumber ='"+rpin+"' where pinNumber ='"+pinNumber+"' ";
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"Pin changed successfully");

            setVisible(false);
            new Transaction(pinNumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
        }


        }else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args){
        new PinChange("");
    }
}