package com.example.junaid.to_doapp;

/**
 * Created by Junaid on 26-Jan-18.
 */
public class User_table {
    private String name;
    private String pass;
    public User_table(){

    }
    public User_table(String name, String pass)
    {
        this.name = name;
        this.pass = pass;
    }
    public String get_user_name()
    {
        return this.name;
    }
    public String get_user_pass()
    {
        return this.pass;
    }

}
