import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fNameTextField, emailTextField, addressTextField, cityTextField, stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male, female, others, married, unmarred;
    JDateChooser dateChooser;
    SignUpOne(){

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);

        JLabel formno = new JLabel("APPLICATION FORM No. "+ random);
        formno.setFont(new Font("Rale way", Font.BOLD,38));
        formno.setBounds(140, 20, 600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 Personal Details");
        personalDetails.setFont(new Font("Rale way", Font.BOLD,24));
        personalDetails.setBounds(290, 80, 400,30 );
        add(personalDetails);

        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Rale way", Font.BOLD,20));
        name.setBounds(100, 140, 100,30 );
        add(name);


        nameTextField= new JTextField();
        nameTextField.setFont(new Font("rale way",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fName = new JLabel("FATHER'S NAME:");
        fName.setFont(new Font("Rale way", Font.BOLD,20));
        fName.setBounds(100, 190, 200,30 );
        add(fName);

        fNameTextField= new JTextField();
        fNameTextField.setFont(new Font("rale way",Font.BOLD,14));
        fNameTextField.setBounds(300,190,400,30);
        add(fNameTextField);

        JLabel DOB = new JLabel("DATE OF BIRTH:");
        DOB.setFont(new Font("Rale way", Font.BOLD,20));
        DOB.setBounds(100, 240, 200,30 );
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        //********************************** GENDER **************************************

        JLabel gender = new JLabel("GENDER:");
        gender.setFont(new Font("Rale way", Font.BOLD,20));
        gender.setBounds(100, 290, 200,30 );
        add(gender);

        male = new JRadioButton("male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("EMAIL:");
        email.setFont(new Font("Rale way", Font.BOLD,20));
        email.setBounds(100, 340, 200,30);
        add(email);

        emailTextField= new JTextField();
        emailTextField.setFont(new Font("rale way",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel maritalStatus = new JLabel("MARITAL STATUS:");
        maritalStatus.setFont(new Font("Rale way", Font.BOLD,20));
        maritalStatus.setBounds(100, 390, 300,30 );
        add(maritalStatus);

        married =new JRadioButton("married");
        married.setBounds(300, 390, 120, 30);
        married.setBackground(Color.white);
        add(married);

        unmarred =new JRadioButton("unmarred");
        unmarred.setBounds(450, 390, 120, 30);
        unmarred.setBackground(Color.white);
        add(unmarred);

        others =new JRadioButton("others");
        others.setBounds(600, 390, 120, 30);
        others.setBackground(Color.white);
        add(others);


        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(unmarred);
        maritalStatusGroup.add(others);

        JLabel address = new JLabel("ADDRESS:");
        address.setFont(new Font("Rale way", Font.BOLD,20));
        address.setBounds(100, 440, 200,30 );
        add(address);

        addressTextField= new JTextField();
        addressTextField.setFont(new Font("rale way",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("CITY:");
        city.setFont(new Font("Rale way", Font.BOLD,20));
        city.setBounds(100, 490, 100,30 );
        add(city);

        cityTextField= new JTextField();
        cityTextField.setFont(new Font("rale way",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("STATE:");
        state.setFont(new Font("Rale way", Font.BOLD,20));
        state.setBounds(100, 540, 100,30 );
        add(state);

        stateTextField= new JTextField();
        stateTextField.setFont(new Font("rale way",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("PINCODE:");
        pincode.setFont(new Font("Rale way", Font.BOLD,20));
        pincode.setBounds(100, 590, 100,30 );
        add(pincode);

        pincodeTextField= new JTextField();
        pincodeTextField.setFont(new Font("rale way",Font.BOLD,14));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);

        next = new JButton("next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("rale way",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    }

    public static void main(String args[]){
        new SignUpOne();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno;
        formno = "" + random;
        String name = nameTextField.getText();
        String fName = fNameTextField.getText();

        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        }

        String email = emailTextField.getText();

        String maritalStatus = null;
        if (married.isSelected()) {
            maritalStatus = "married";
        } else if (unmarred.isSelected()) {
            maritalStatus = "unmarred";
        } else if (others.isSelected()) {
            maritalStatus = "others";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try {
            if (nameTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Name.");
                nameTextField.requestFocus();
                return;
            }
            if (fNameTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Father's Name.");
                fNameTextField.requestFocus();
                return;
            }
            if (!male.isSelected() && !female.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select your Gender.");
                return;
            }
            if (!married.isSelected() && !unmarred.isSelected() && !others.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select your Marital Status.");
                return;
            }
            if (emailTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Email.");
                emailTextField.requestFocus();
                return;
            }
            if (addressTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Address.");
                addressTextField.requestFocus();
                return;
            }
            if (cityTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your City.");
                cityTextField.requestFocus();
                return;
            }
            if (stateTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your State.");
                stateTextField.requestFocus();
                return;
            }
            if (pincodeTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Pincode.");
                pincodeTextField.requestFocus();
                return;
            }
            else{
                Conn c =new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fName+"','"+dob+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
            setVisible(false);
            new SignUpTwo(formno).setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
    }