package com.example.ullala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDetailActivity extends AppCompatActivity {

    private FragmentManager fm;
    private Fragment nameFrag,dobFrag;
    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        btnNext=findViewById(R.id.button_next);


        fm = getSupportFragmentManager();
        nameFrag=new NameFragment();
        fm.beginTransaction().add(R.id.lyt_frame_detail,nameFrag).commit();


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDobFrag();
            }
        });
    }

    public void callDobFrag()
    {
        fm.popBackStack();
        dobFrag=new DobFragment();
        fm.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_up,android.R.anim.fade_out)
                .replace(R.id.lyt_frame_detail,dobFrag)
                .commit();
    }
}