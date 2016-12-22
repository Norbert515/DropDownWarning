package com.nks.dropdownwarninglibrary;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Norbert on 31.08.2016.
 */
public class DropDownWarning extends LinearLayout {

    private TextView textView;
    private String warningMessage;
    private int backgroundColor, foregroundColor;
    private Animation fadeIn, fadeOut;
    private ViewGroup parent;
    private int height;
    private Interpolator interpolatorIn, interpolatorOut;
    private int animationLength;
    boolean isVisible = false;



    public static class Builder{
        private Interpolator interpolatorIn, interpolatorOut;
        private int animationLength;
        private int height;
        private String warningMessage;
        private Context context;
        private ViewGroup parent;
        private int backgroundColor, foregroundColor;


        public Builder(Context context, ViewGroup parent){
            this.context = context;
            this.parent = parent;
            warningMessage = "My Message";
            height = 60;
            animationLength = 500;
            interpolatorIn = new LinearInterpolator();
            interpolatorOut = new LinearInterpolator();
            backgroundColor = 0xffffffff;
            foregroundColor = 0xff000000;
        }


        public Builder interpolatorIn(Interpolator interpolator){
            this.interpolatorIn = interpolator;
            return this;
        }
        //d

        public Builder interpolatorOut(Interpolator interpolator){
            this.interpolatorOut = interpolator;
            return this;
        }

        public Builder animationLength(int length){
            this.animationLength = length;
            return this;
        }

        public Builder textHeight(int height){
            this.height = height;
            return this;
        }

        public Builder message(String message){
            this.warningMessage = message;
            return this;
        }

        public Builder foregroundColor(int color){
            this.foregroundColor = color;
            return this;
        }

        public Builder backgroundColor(int color){
            this.backgroundColor = color;
            return this;
        }

        public DropDownWarning build(){
            return new DropDownWarning(this);
        }

    }

    public DropDownWarning(Builder builder){
        super(builder.context);

        warningMessage = builder.warningMessage;
        backgroundColor = builder.backgroundColor;
        foregroundColor = builder.foregroundColor;
        height = builder.height;
        interpolatorIn = builder.interpolatorIn;
        interpolatorOut = builder.interpolatorOut;
        animationLength = builder.animationLength;
        parent = builder.parent;


        addWarningView();
        setUpLayoutParams();
        initializeAnimation();
    }


    private void addWarningView(){
        textView = new TextView(getContext());
        textView.setText(warningMessage);
        textView.setBackgroundColor(backgroundColor);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(0,12,0,12);
        textView.setVisibility(INVISIBLE);
        textView.setTextColor(foregroundColor);
        LayoutParams l = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        textView.setLayoutParams(l);
        addView(textView);
    }

    private void setUpLayoutParams(){
        LayoutParams l = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(l);
        parent.addView(this);
    }

    private void initializeAnimation(){
        animationLength = 500;
        fadeIn = new TranslateAnimation(0,0,-height,0);
        fadeIn.setDuration(animationLength);
        fadeOut = new TranslateAnimation(0,0,0,-height);
        fadeOut.setDuration(animationLength);

        if(interpolatorIn != null)
            fadeIn.setInterpolator(interpolatorIn);

        if(interpolatorOut != null)
            fadeOut.setInterpolator(interpolatorOut);
    }

    /**
     * Starts fade in animation and shows text view
     */
    public void show(){
        if(!isVisible) {
            textView.setVisibility(VISIBLE);
            textView.startAnimation(fadeIn);
            isVisible = true;
        }

    }

    @Override
    public void setOnClickListener(OnClickListener listener){
        textView.setOnClickListener(listener);
    }



    /**
     * Starts fade out animation and hides text view
     */
    public void hide(){
        if(!isVisible)return;
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.setVisibility(GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        isVisible = false;
        textView.startAnimation(fadeOut);


    }

}
