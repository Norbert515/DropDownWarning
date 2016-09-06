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


        dropDownWarning = new DropDownWarning.Builder(getApplicationContext(),rootView).message("My Message").backgroundColor(0xff1976D2).foregroundColor(0xffffffff).interpolatorIn(new BounceInterpolator()).interpolatorOut(new AnticipateOvershootInterpolator()).textHeight(80).build();
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(on){
                    dropDownWarning.hide();
                    on = false;

                }else{
                    dropDownWarning.show();
                    on = true;
                }

            }
        });

    }
}
