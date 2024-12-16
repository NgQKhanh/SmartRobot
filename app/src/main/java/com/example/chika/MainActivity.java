package com.example.chika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chika.databinding.ActivityMainBinding;
import com.example.chika.ui.NormalFaceActivity;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'chika' library on application startup.
    static {
        System.loadLibrary("chika");
    }

    private ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo nút và thiết lập sự kiện khi nhấn
        Button buttonNavigate = findViewById(R.id.buttonNavigate);
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang TestActivity
                Intent intent = new Intent(MainActivity.this, NormalFaceActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * A native method that is implemented by the 'chika' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}