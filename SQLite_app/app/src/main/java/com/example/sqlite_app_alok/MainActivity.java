package com.example.sqlite_app_alok;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.sql.StatementEvent;

public class MainActivity extends AppCompatActivity {
    EditText name, contact, age;
    Button insert, update, delete, view, clear, deleteAll;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        age = findViewById(R.id.age);

        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.view);
        clear = findViewById(R.id.clear);
        deleteAll = findViewById(R.id.deleteAll);

        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();
                String contactTxt = contact.getText().toString();
                String agetxt = age.getText().toString();

                boolean status = DB.insertData(nameTxt, contactTxt, agetxt);
                if(status == true){
                    Toast.makeText(MainActivity.this, "value inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();
                String contactTxt = contact.getText().toString();
                String agetxt = age.getText().toString();

                boolean status = DB.updateData(nameTxt, contactTxt, agetxt);
                if(status == true){
                    Toast.makeText(MainActivity.this, "Details updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Details not updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();
                boolean status = DB.deleteData(nameTxt);
                if(status == true){
                    Toast.makeText(MainActivity.this, "Details deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Details Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = DB.viewData();
                if(cursor.getCount() == 0){
                    Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }
                else{
                    StringBuffer stringBuffer = new StringBuffer();
                    while (cursor.moveToNext()){
                        stringBuffer.append("Name : " + cursor.getString(0) + "\n");
                        stringBuffer.append("Contact : " + cursor.getString(1) + "\n");
                        stringBuffer.append("Age : " + cursor.getString(2) + "\n");
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("User Data");
                    builder.setMessage(stringBuffer.toString());
                    builder.show();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.getText().clear();
                contact.getText().clear();
                age.getText().clear();
            }
        });

        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.deleteAllData();
                Toast.makeText(MainActivity.this, "All data deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}