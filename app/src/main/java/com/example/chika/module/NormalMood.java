package com.example.chika.module;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import static com.example.chika.module.FacialGestures.*;

public class NormalMood {
    public static final int BLINK_INTERVAL = 4000;
    public static void setNormalFace(View eyeLeft, View eyeRight){
        AnimatorSet animatorSet = new AnimatorSet();

        // Init ObjectAnimator
        ObjectAnimator LE_blink = blinkEye(eyeLeft);
        ObjectAnimator LE_keep = keep(eyeLeft, BLINK_INTERVAL);
        ObjectAnimator RE_blink = blinkEye(eyeRight);
        ObjectAnimator RE_keep = keep(eyeRight, BLINK_INTERVAL);

        // Arrange animation
        animatorSet.playSequentially(LE_keep, LE_blink);
        animatorSet.playSequentially(RE_keep, RE_blink);
        animatorSet.playTogether(LE_keep, RE_keep);

        setAnimation(animatorSet);
        animatorSet.start();
    }
}
