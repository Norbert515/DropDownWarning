package com.nks.dropdownwarning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.nks.dropdownwarninglibrary.DropDownWarning;


public class MainActivity extends AppCompatActivity {


    boolean on = false;
    DropDownWarning dropDownWarning;
    RelativeLayout rootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = (RelativeLayout) findViewById(R.id.rootView);

        Button button = (Button) findViewById(R.id.button);
        
        dropDownWarning = new DropDownWarning(getApplicationContext(),"My message",0xff49baff,rootView,200,0xffffffff,new BounceInterpolator(),new AnticipateOvershootInterpolator());

        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(on){
                    dropDownWarning.hideWarning();
                    on = false;

                }else{
                    dropDownWarning.showWarning();
                    on = true;
                }

            }
        });

    }
}
