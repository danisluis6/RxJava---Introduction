package com.example.lorence.rxtutorial.activities.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.lorence.rxtutorial.R;

/**
 * Created by lorence on 19/12/2017.
 *
 */

public class MainView extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
