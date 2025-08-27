import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignUpTwo extends JFrame implements ActionListener{

    JComboBox category;
    JTextField religionTextField, incomeTextField, educationTextField, occupationTextField, aadharnoTextField, panTextField;
    JButton next;
    JRadioButton yes, no, yess, noo;
    String formno;

    SignUpTwo(String formno){
        this.formno = formno;
        setLayout(null);

//*****************************************************  HEADING  *******************************************************

        JLabel personalDetails = new JLabel("Page 2 Additional Details");
        personalDetails.setFont(new Font("Rale way", Font.BOLD,30));
        personalDetails.setBounds(200, 40, 500,40 );
        add(personalDetails);


//***************************************************** RELIGION *********************************************************

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Rale way", Font.BOLD,20));
        religion.setBounds(100, 160, 100,30 );
        add(religion);


        religionTextField= new JTextField();
        religionTextField.setFont(new Font("rale way",Font.BOLD,14));
        religionTextField.setBounds(300,160,400,30);
        add(religionTextField);


//***************************************************** CATEGORY *********************************************************

        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Rale way", Font.BOLD,20));
        Category.setBounds(100, 230, 200,30 );
        add(Category);

        String valcategory[] ={" ","GENERAL","OBC","SC","ST","OTHERS"};
        category = new JComboBox(valcategory);
        category.setFont(new Font("rale way",Font.BOLD,14));
        category.setBounds(300, 230,400,30);
        category.setBackground(Color.white);
        add(category);


//***************************************************** INCOME *********************************************************

        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Rale way", Font.BOLD,20));
        Income.setBounds(100, 290, 200,30 );
        add(Income);

        incomeTextField= new JTextField();
        incomeTextField.setFont(new Font("rale way",Font.BOLD,14));
        incomeTextField.setBounds(300,290,400,30);
        add(incomeTextField);


//******************************************* Educational Qualification ************************************************

        JLabel Education = new JLabel("Educational");
        Education.setFont(new Font("Rale way", Font.BOLD,20));
        Education.setBounds(100, 340, 200,30);
        add(Education);
        JLabel qualification = new JLabel("Qualification");
        qualification.setFont(new Font("Rale way", Font.BOLD,20));
        qualification.setBounds(100, 363, 200,30);
        add(qualification);

        educationTextField= new JTextField();
        educationTextField.setFont(new Font("rale way",Font.BOLD,14));
        educationTextField.setBounds(300,350,400,30);
        add(educationTextField);


//************************************************ Occupation *****************************************************

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Rale way", Font.BOLD,20));
        occupation.setBounds(100, 420, 200,30 );
        add(occupation);

        occupationTextField= new JTextField();
        occupationTextField.setFont(new Font("rale way",Font.BOLD,14));
        occupationTextField.setBounds(300,420,400,30);
        add(occupationTextField);


//************************************************ Aadhar Number *****************************************************

        JLabel aadharno = new JLabel("Aadhar Number:");
        aadharno.setFont(new Font("Rale way", Font.BOLD,20));
        aadharno.setBounds(100, 470, 160,30 );
        add(aadharno);

        aadharnoTextField= new JTextField();
        aadharnoTextField.setFont(new Font("rale way",Font.BOLD,14));
        aadharnoTextField.setBounds(300,470,400,30);
        add(aadharnoTextField);

//************************************************ PAN Number *****************************************************

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Rale way", Font.BOLD,20));
        pan.setBounds(100, 520, 150,30 );
        add(pan);

        panTextField= new JTextField();
        panTextField.setFont(new Font("rale way",Font.BOLD,14));
        panTextField.setBounds(300,520,400,30);
        add(panTextField);


//************************************************ RADIO BUTTONS  *****************************************************

        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Rale way", Font.BOLD,20));
        seniorcitizen.setBounds(100, 570, 200,30 );
        add(seniorcitizen);

        yes = new JRadioButton("Yes");
        yes.setBounds(300, 570, 60, 30);
        yes.setBackground(Color.white);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(450, 570, 120, 30);
        no.setBackground(Color.white);
        add(no);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(yes);
        genderGroup.add(no);



        JLabel maritalStatus = new JLabel("Existing Account:");
        maritalStatus.setFont(new Font("Rale way", Font.BOLD,20));
        maritalStatus.setBounds(100, 620, 300,30 );
        add(maritalStatus);

        yess =new JRadioButton("Yes");
        yess.setBounds(300, 620, 120, 30);
        yess.setBackground(Color.white);
        add(yess);

        noo =new JRadioButton("No");
        noo.setBounds(450, 620, 120, 30);
        noo.setBackground(Color.white);
        add(noo);

        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(yess);
        maritalStatusGroup.add(noo);


        next = new JButton("next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("rale way",Font.BOLD,14));
        next.setBounds(620,670,80,30);
        next.addActionListener(this);
        add(next);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public static void main(String args[]){
        new SignUpTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.formno = formno;
        String religion = religionTextField.getText();
        String scategory = (String) category.getSelectedItem();
        String income = incomeTextField.getText();
        String education = educationTextField.getText();
        String occupation = occupationTextField.getText();
        String aadharno = aadharnoTextField.getText();
        String pan = panTextField.getText();

        String seniorcitizen = null;
        if (yes.isSelected()) {
            seniorcitizen = "yes";
        } else if (no.isSelected()) {
            seniorcitizen = "no";
        }

        String existingAcc = null;
        if (yes.isSelected()) {
            existingAcc = "yess";
        } else if (no.isSelected()) {
            existingAcc = "noo";
        }

        try {
//***************************************************  ERROR MESSAGE ***************************************************

            if (religionTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Religion.");
                religionTextField.requestFocus();
                return;
            }
            if (((String) category.getSelectedItem()).isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your category.");
                category.requestFocus();
                return;
            }
            if (!yes.isSelected() && !no.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select  if you senior citizen .");
                return;
            }
            if (!yess.isSelected() && !noo.isSelected() ) {
                JOptionPane.showMessageDialog(this, "Please select if you have existing account.");
                return;
            }
            if (incomeTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your income.");
                incomeTextField.requestFocus();
                return;
            }
            if (occupationTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your occupation.");
                occupationTextField.requestFocus();
                return;
            }
            if (aadharnoTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your aadhar number.");
                aadharnoTextField.requestFocus();
                return;
            }
            if (panTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your pan number.");
                panTextField.requestFocus();
                return;
            }
//********************************************  DATABASE CONNECTION ***************************************************
            else{
                Conn c =new Conn();
                String query = "insert into personal_details values('"+formno+"','"+religion+"','"+scategory+"','"+income+"','"+education+"','"+occupation+"','"+aadharno+"','"+pan+"','"+seniorcitizen+"','"+existingAcc+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formno).setVisible(true);


            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}