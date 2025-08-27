import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton current, saving, fixed, recurring;
    JCheckBox atmCard, mobileBanking, chequeBook, internetBanking, alerts, statement, declare;
    JButton submit, cancel;
    String formno;

    SignUpThree(String formno){
        this.formno = formno;
        setLayout(null);

        setSize(850,800);
        setLocation(350,10);
        getContentPane().setBackground(Color.white);

        JLabel accountDetails= new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("rale way",Font.BOLD,30));
        accountDetails.setBounds(220,40,400,40);
        add(accountDetails);


//***********************************   ACCOUNT TYPE SECTION   ***************************************************

        JLabel accType= new JLabel("Account Type");
        accType.setFont(new Font("rale way",Font.BOLD,25));
        accType.setBounds(60,110,200,40);
        add(accType);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("rale way", Font.BOLD, 16));
        current.setBounds(60, 150, 200, 40);
        current.setBackground(Color.white);
        add(current);

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("rale way", Font.BOLD, 16));
        saving.setBounds(60, 190, 200, 40);
        saving.setBackground(Color.white);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("rale way", Font.BOLD, 16));
        fixed.setBounds(350, 150, 250, 40);
        fixed.setBackground(Color.white);
        add(fixed);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("rale way", Font.BOLD, 16));
        recurring.setBounds(350, 190, 250, 40);
        recurring.setBackground(Color.white);
        add(recurring);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(current);
        accountGroup.add(saving);
        accountGroup.add(fixed);
        accountGroup.add(recurring);


//*******************************************  CARD NO , PIN  *********************************************************

        JLabel card= new JLabel("Card Number:");
        card.setFont(new Font("rale way",Font.BOLD,25));
        card.setBounds(60,250,200,30);
        add(card);

        JLabel cardNo= new JLabel("XXXX-XXXX-XXXX-1234");
        cardNo.setFont(new Font("rale way",Font.BOLD,25));
        cardNo.setBounds(320,250,400,30);
        add(cardNo);

        JLabel cardDigit= new JLabel("your 16 digit card number");
        cardDigit.setFont(new Font("rale way",Font.BOLD,14));
        cardDigit.setBounds(60,285,180,15);
        add(cardDigit);

        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("rale way",Font.BOLD,25));
        pin.setBounds(60,320,100,30);
        add(pin);

        JLabel pinNo = new JLabel("XXXX");
        pinNo.setFont(new Font("rale way",Font.BOLD,25));
        pinNo.setBounds(320,320,100,30);
        add(pinNo);

        JLabel pinDigit = new JLabel("your 4 digit pin");
        pinDigit.setFont(new Font("rale way",Font.BOLD,14));
        pinDigit.setBounds(60,355,150,15);
        add(pinDigit);


//****************************************  Service Required  **************************************************

        JLabel serviceRequired= new JLabel("Service Required:");
        serviceRequired.setFont(new Font("rale way",Font.BOLD,30));
        serviceRequired.setBounds(60,390,300,40);
        add(serviceRequired);

        atmCard = new JCheckBox(" ATM Card");
        atmCard.setFont(new Font("rale way",Font.BOLD,14));
        atmCard.setBounds(60,450,150,20);
        atmCard.setBackground(Color.white);
        add(atmCard);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("rale way",Font.BOLD,14));
        mobileBanking.setBounds(60,500,150,20);
        mobileBanking.setBackground(Color.white);
        add(mobileBanking);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setFont(new Font("rale way",Font.BOLD,14));
        chequeBook.setBounds(60,550,150,20);
        chequeBook.setBackground(Color.white);
        add(chequeBook);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("rale way",Font.BOLD,14));
        internetBanking.setBounds(250,450,200,20);
        internetBanking.setBackground(Color.white);
        add(internetBanking);

        alerts = new JCheckBox("EMAIL & SMS Alerts");
        alerts.setFont(new Font("rale way",Font.BOLD,14));
        alerts.setBounds(250,500,200,20);
        alerts.setBackground(Color.white);
        add(alerts);

        statement = new JCheckBox("E-statement");
        statement.setFont(new Font("rale way",Font.BOLD,14));
        statement.setBounds(250,550,150,20);
        statement.setBackground(Color.white);
        add(statement);

        declare = new JCheckBox("i hereby declare that the above entered details are correct to the beat of my knowledge");
        declare.setFont(new Font("rale way",Font.BOLD,14));
        declare.setBounds(60,630,650,20);
        declare.setBackground(Color.white);
        add(declare);


//*********************************************  BUTTONS  ****************************************************

        submit = new JButton("Submit");
        submit.setFont(new Font("rale way", Font.BOLD, 14));
        submit.setBounds(250, 700, 100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("rale way", Font.BOLD, 14));
        cancel.setBounds(450, 700, 100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.formno = formno;
            String accountType = null;
            String cardNumber = null;
            String pinNumber = null;
            String facility = null;
        if (e.getSource()==submit){

            if (current.isSelected()){
                accountType = "Current Account";
            } else if (saving.isSelected()) {
                accountType = "Savings Account";
            } else if (fixed.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (recurring.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 1010202000000000L);
            pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            facility = "";
            if (atmCard.isSelected()){
                facility = "ATM card";
            }else if (mobileBanking.isSelected()){
                facility = "mobileBanking";
            }else if (chequeBook.isSelected()){
                facility = "chequeBook";
            }else if (internetBanking.isSelected()){
                facility = "internetBanking";
            }else if (alerts.isSelected()){
                facility = "alerts";
            }else if (statement.isSelected()){
                facility = "statement";
            }
        }else if (e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }

//*****************************************  Throwing Errors  **************************************************
        try{
            if (!current.isSelected() && !saving.isSelected() && !fixed.isSelected() && !recurring.isSelected() ) {
                JOptionPane.showMessageDialog(this, "Please select your account type.");
                return;
            }
            if (!atmCard.isSelected() && !mobileBanking.isSelected() && !chequeBook.isSelected() && !internetBanking.isSelected() && !alerts.isSelected() && !statement.isSelected() ) {
                JOptionPane.showMessageDialog(this, "Please select at least one service.");
                return;
            }
            if (!declare.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select declaration message.");
                return;
            }else {
                Conn con = new Conn();
                String query1 = "insert into account_details values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";

                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "card number: "+cardNumber+"\n pin: "+pinNumber);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
    public static void main(String args[]){
        new SignUpThree("");
    }
}
