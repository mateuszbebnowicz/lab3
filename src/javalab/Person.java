package javalab;

public class Person {

    private final String login;
    private final String password;

    Person(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }



}