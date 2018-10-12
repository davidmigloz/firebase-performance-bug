package com.davidmiguel.firebaseperformancebug;

import androidx.appcompat.app.AppCompatActivity;
import at.favre.lib.crypto.bcrypt.BCrypt;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,
                BCrypt.withDefaults().hashToString(12, "1234".toCharArray()),
                Toast.LENGTH_SHORT).show();
    }
}
