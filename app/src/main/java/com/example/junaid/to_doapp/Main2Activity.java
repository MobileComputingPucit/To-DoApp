package com.example.junaid.to_doapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvNotesNumber;
    private RecyclerView rv;
    private ArrayList<User_notes> user_notes;
    private Adapter adapter;
    private Button create_a_note;
    private User_table ut = new User_table();
    private DBHelper db = new DBHelper(this);
    private EditText create_note_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvNotesNumber = (TextView) findViewById(R.id.textViewforNumberOfNotesPerUser);
        create_a_note = (Button) findViewById(R.id.button3);
        create_a_note.setOnClickListener(this);
        user_notes = new ArrayList<User_notes>();
        rv = (RecyclerView) findViewById(R.id.rv1);
        adapter = new Adapter(this, user_notes, getIntent().getStringExtra("name"));
        create_note_text = (EditText) findViewById(R.id.editText3);
        rv.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        tvNotesNumber.setText("Welcome " + getIntent().getStringExtra("name"));
    }

    @Override
    public void onClick(View v) {
        User_notes user_notes2 = new User_notes();
        user_notes2.set_Notes(create_note_text.getText().toString());
        user_notes2.setUserName(getIntent().getStringExtra("name"));
        adapter.insertItem(user_notes.size(), user_notes2);
        db.insertNoteUser(create_note_text.getText().toString(), getIntent().getStringExtra("name"));
    }
}
