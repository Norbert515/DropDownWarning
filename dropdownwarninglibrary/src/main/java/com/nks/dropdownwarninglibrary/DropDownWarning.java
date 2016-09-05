package com.nks.dropdownwarninglibrary;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
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

    /**
     *
     * @param context
     * @param text Text to display
     * @param backgroundColor hex color value with alpha (example "0xff49f522")
     * @param parent
     */
    public DropDownWarning(Context context, String text, int backgroundColor, ViewGroup parent) {
        super(context);
        this.parent = parent;
        this.warningMessage = text;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = 0xffffffff;

        height = 120;

        addWarningView();
        setUpLayoutParams();
        initializeAnimation();

    }

    /**
     *
     * @param context
     * @param text Text to display
     * @param backgroundColor Color of the background in hex with alpha
     * @param parent
     * @param textHeight Height of the warning
     */
    public DropDownWarning(Context context, String text, int backgroundColor, ViewGroup parent, int textHeight){
        super(context);
        this.parent = parent;
        this.warningMessage = text;
        this.backgroundColor = backgroundColor;
        this.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,textHeight, context.getResources().getDisplayMetrics());

        this.foregroundColor = 0xf00fffff;

        addWarningView();
        setUpLayoutParams();
        initializeAnimation();

    }

    /**
     *
     * @param context
     * @param text Text to display
     * @param backgroundColor Color of the background in hex with alpha
     * @param parent
     * @param textHeight Height of the warning
     * @param textColor Color of the text in hex with alpha
     */
    public DropDownWarning(Context context, String text, int backgroundColor, ViewGroup parent, int textHeight, int textColor){
        super(context);
        this.parent = parent;
        this.warningMessage = text;
        this.backgroundColor = backgroundColor;
        this.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,textHeight, context.getResources().getDisplayMetrics());
        this.foregroundColor = textColor;

        addWarningView();
        setUpLayoutParams();
        initializeAnimation();

    }

    /**
     *
     * @param context
     * @param text Text to display
     * @param backgroundColor Color of the background in hex with alpha
     * @param parent
     * @param textHeight Height of the warning
     * @param textColor Color of the text in hex with alpha
     * @param interpolatorIn Interpolation of the animation IN
     * @param interpolatorOut Interpolation of the animation OUT
     */
    public DropDownWarning(Context context, String text, int backgroundColor, ViewGroup parent, int textHeight, int textColor, Interpolator interpolatorIn, Interpolator interpolatorOut){
        super(context);
        this.parent = parent;
        this.warningMessage = text;
        this.backgroundColor = backgroundColor;
        this.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,textHeight, context.getResources().getDisplayMetrics());
        this.foregroundColor = textColor;
        this.interpolatorIn = interpolatorIn;
        this.interpolatorOut = interpolatorOut;

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
    public void showWarning(){
        if(!isVisible) {
            textView.setVisibility(VISIBLE);
            textView.startAnimation(fadeIn);
            isVisible = true;
        }

    }


    /**
     * Starts fade out animation and hides text view
     */
    public void hideWarning(){
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

    public String getWarningMessage() {
        return warningMessage;
    }

    public void setWarningMessage(String text) {
        this.warningMessage = text;
        textView.setText(warningMessage);
    }

    public int getMessageBackgroundColor() {
        return backgroundColor;
    }

    public void setMessageBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        textView.setBackgroundColor(backgroundColor);
    }

    public int getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(int foregroundColor) {
        this.foregroundColor = foregroundColor;
        textView.setTextColor(foregroundColor);
    }

    public int getWarningHeight() {
        return height;
    }

    public void setWarningHeight(int height) {
        this.height = height;
        LayoutParams l = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        textView.setLayoutParams(l);
    }

    public Interpolator getInterpolatorIn() {
        return interpolatorIn;
    }

    public void setInterpolatorIn(Interpolator interpolatorIn) {
        this.interpolatorIn = interpolatorIn;
        fadeIn.setInterpolator(interpolatorIn);
    }

    public Interpolator getInterpolatorOut() {
        return interpolatorOut;
    }

    public void setInterpolatorOut(Interpolator interpolatorOut) {
        this.interpolatorOut = interpolatorOut;
        fadeOut.setInterpolator(interpolatorOut);
    }

    public int getAnimationLength() {
        return animationLength;
    }

    public void setAnimationLength(int animationLength) {
        this.animationLength = animationLength;
        fadeIn.setDuration(animationLength);
        fadeOut.setDuration(animationLength);
    }
}
