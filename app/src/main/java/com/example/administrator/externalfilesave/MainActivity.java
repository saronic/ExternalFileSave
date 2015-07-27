package com.example.administrator.externalfilesave;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            File sdPath = Environment.getExternalStorageDirectory();
            File file = new File(sdPath, "data.txt");
            FileOutputStream fileOutputStream = null;

            try {
                Log.d("MainActivity", sdPath.toString() + "xxxxxxxxxxxxxxxxx");
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write("hello".getBytes());
                fileOutputStream.close();
                Log.d("MainActivity", sdPath.toString() + "...........");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
                String data = br.readLine();
                Log.d("lsx", data + "xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
