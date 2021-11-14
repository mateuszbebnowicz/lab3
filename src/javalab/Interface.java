package javalab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class Interface
{
    private final Map<String, Person> PeopleBase = new HashMap<>();

    JFrame frame;
    JTextField loginField;
    JPasswordField passwordField;

    Interface()
    {
        this.frame = createFrame();
        this.loginField = createTextField();
        this.passwordField = createPasswordField();



        JLabel loginLabel = createLabel("Login:");
        loginLabel.setBounds(160,150,50,30);

        JLabel passwordLabel = createLabel("Password:");
        passwordLabel.setBounds(455,150,70,30);

        JButton loginButton = createButton("Login");
        loginButton.setBounds(250,300,150,90);
        loginButton.addActionListener(e -> loginButtonPressed(e));
        loginButton.setBackground(Color.green);

        JButton exitButton = createButton("Exit");
        exitButton.setBounds(520,300,150,90);
        exitButton.addActionListener(e -> cancelButtonPressed());
        exitButton.setBackground(Color.orange);

        frame.add(loginButton);
        frame.add(loginField);
        frame.add(loginLabel);
        frame.add(exitButton);
        frame.add(passwordField);
        frame.add(passwordLabel);

        addPeople(PeopleBase);
    }


    private JFrame createFrame()
    {
        JFrame frame = new JFrame("Login Interface");

        frame.setSize(1000,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        frame.setBackground(Color.white);

        return frame;
    }

    private JButton createButton(String text)
    {
        JButton button = new JButton(text);

        button.setSize(80,40);
        button.setFocusable(false);
        
        return button;
    }

    private void loginButtonPressed(ActionEvent event)
    {
        String login = loginField.getText();
        String password = String.valueOf(passwordField.getPassword());


        if(PeopleBase.containsKey(login))
        {
            if (PeopleBase.get(login).getPassword().equals(password))
                accessPermitted();

            else
                accessDenied();
        }
        else
        {
            accessDenied();
        }
    }

    private void accessPermitted()
    {
        frame.getContentPane().setBackground(Color.green);
        JOptionPane.showMessageDialog(frame, "Correct!", "You are in!", JOptionPane.INFORMATION_MESSAGE);
        frame.getContentPane().setBackground(Color.white);
        clearTextFields();
    }

    private void accessDenied()
    {
        frame.getContentPane().setBackground(Color.red);
        JOptionPane.showMessageDialog(frame,"Incorrect!", "You have to try harder!", JOptionPane.WARNING_MESSAGE);
        frame.getContentPane().setBackground(Color.white);
        clearTextFields();
    }

    private void clearTextFields()
    {
        loginField.setText(null);
        passwordField.setText(null);
    }

    private void cancelButtonPressed()
    {
        System.exit(0);
    }

    private JTextField createTextField()
    {
        JTextField loginField = new JTextField();

        loginField.setBounds(200,150,200,30);
        loginField.setBorder(BorderFactory.createLineBorder(Color.blue,2));

        return loginField;
    }
    private JLabel createLabel(String text)
    {
        JLabel label = new JLabel(text);

        label.setVisible(true);
        label.setBackground(Color.white);

        return label;
    }

    private JPasswordField createPasswordField()
    {
        JPasswordField passwordField = new JPasswordField();

        passwordField.setBounds(520, 150,200,30);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black,2));

        return passwordField;
    }



    private void addPeople(Map<String, Person> PeopleBase)
    {
        Person person1 = new Person("Mateusz", "pomidor");
        PeopleBase.put(person1.getLogin(), person1);

        Person person2 = new Person("Filip", "jablko");
        PeopleBase.put(person2.getLogin(), person2);

        Person person3 = new Person("Krzysztof", "banan");
        PeopleBase.put(person3.getLogin(), person3);

        Person person4 = new Person("Maciek", "mandarynka");
        PeopleBase.put(person4.getLogin(), person4);


    }
}
