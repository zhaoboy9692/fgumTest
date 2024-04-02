package com.example.fgumtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fgumtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'fgumtest' library on application startup.
    static {
        System.loadLibrary("fgumtest");
    }

    public String ssssss = "testfrida";

    TextView tv;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tv = binding.sampleText;
        tv.setText(stringFromJNI("/data/local/tmp/frida.js") + "");
    }

    /**
     * A native method that is implemented by the 'fgumtest' native library,
     * which is packaged with this application.
     */
    public native boolean stringFromJNI(String jspath);

    public void sss(View view) {
        tv.setText(ssssss);
    }
}