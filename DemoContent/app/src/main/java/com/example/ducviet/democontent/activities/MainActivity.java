package com.example.ducviet.democontent.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ducviet.democontent.R;
import com.example.ducviet.democontent.manager.StudentProvider;
import com.example.ducviet.democontent.model.Student;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText name,phone,inf;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.ed_name);
        phone = (EditText)findViewById(R.id.ed_phone);
        inf = (EditText)findViewById(R.id.ed_inf);
        button = (Button)findViewById(R.id.bt_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = new Random().nextInt(10000);
                Student student = new Student(id,name.getText().toString(),phone.getText().toString(),
                        inf.getText().toString());
                if(getContentResolver().insert(StudentProvider.CONTENT_URI, student.getContentValues()) != null){
                    Toast.makeText(MainActivity.this, "Insert success", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    inf.setText("");
                    phone.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "Insert failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
