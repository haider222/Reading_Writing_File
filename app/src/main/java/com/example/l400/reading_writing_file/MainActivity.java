package com.example.l400.reading_writing_file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText write ,read;
    String file ="mydata";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        write = (EditText)findViewById(R.id.editText);
        read = (EditText)findViewById(R.id.editText2);
    }

    public void write(View view){
        String wr = write.getText().toString();
        try {
            {
                FileOutputStream fileOutputStream = openFileOutput(file, MODE_WORLD_READABLE);
                fileOutputStream.write(wr.getBytes());
                fileOutputStream.close();
                Toast.makeText(MainActivity.this, "File write", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "file not write", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void read(View view) throws IOException {
        FileInputStream fileInputStream = openFileInput(file);
        String re = "";
        int c ;
        while((c = fileInputStream.read())!= -1){
                re = re+Character.toString((char) c);
        }
        read.setText(re);
        Toast.makeText(MainActivity.this, "file read ", Toast.LENGTH_SHORT).show();
    }
}
