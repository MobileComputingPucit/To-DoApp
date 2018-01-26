package com.example.junaid.to_doapp;

/**
 * Created by Junaid on 26-Jan-18.
 */
public class User_notes {
    private String User_name;
    private String Notes;

    public User_notes ()
    {

    }
    public User_notes (String user_id, String Notes)
    {
        this.User_name = user_id;
        this.Notes = Notes;
    }
    public void setUserName(String name)
    {
        this.User_name = name;
    }
    public void set_Notes(String Notes)
    {
        this.Notes = Notes;
    }
}
