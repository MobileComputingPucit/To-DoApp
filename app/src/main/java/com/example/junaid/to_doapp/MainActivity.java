package com.example.junaid.to_doapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etPass;
    private Button btnRegister;
    private Button login;
    private TextView message;
    private RecyclerView rvStudents;
    private User_table ut;
    private DBHelper db;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.editText);
        etPass = (EditText) findViewById(R.id.editText2);
        btnRegister = (Button) findViewById(R.id.button);
        login = (Button) findViewById(R.id.button2);
        //rvStudents = (RecyclerView) findViewById(R.id.rv1);
        message = (TextView) findViewById(R.id.textView2);

        login.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        //adapter = new Adapter(this);
        //rvStudents.setAdapter(adapter);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //rvStudents.setLayoutManager(linearLayoutManager);
        db = new DBHelper(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button)
        {
            if (!etName.getText().toString().equals(""))
            {
                if(!etPass.getText().toString().equals(""))
                {
                    ut = new User_table(etName.getText().toString(),etPass.getText().toString());
                    try
                    {
                        db.insertUserData(ut);
                        message.setText(ut.get_user_name() + " Registered");
                    }
                    catch (Exception e)
                    {
                        message.setText("User already exist with same name");
                    }
                    message.setVisibility(View.VISIBLE);
                }
                else
                    message.setVisibility(View.INVISIBLE);
            }
            else
                message.setVisibility(View.INVISIBLE);
        }
        else if (v.getId() == R.id.button2)
        {
            if (!etName.getText().toString().equals("")) {
                if (!etPass.getText().toString().equals("")) {
                    ut = new User_table(etName.getText().toString(), etPass.getText().toString());
                    try {
                        Cursor cursor = db.getUserData(etName.getText().toString());
                        Intent intent = new Intent(this, Main2Activity.class);
                        intent.putExtra("name",etName.getText().toString());
                        startActivity(intent);

                    } catch (Exception e) {
                        message.setText("User does not exist");
                        message.setVisibility(View.VISIBLE);
                    }
                }
            }

        }
    }
}
