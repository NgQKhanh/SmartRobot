package com.example.chika.module;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

public class FacialGestures {
    private static final int BLINK_DURATION = 200;
    private static final int BLINK_INTERVAL = 4000;

    public static ObjectAnimator blinkEye(View view) {
        if (view == null) return null;
        ObjectAnimator animator = new ObjectAnimator();
        animator.setTarget(view);
        animator.setPropertyName("scaleY");
        animator.setFloatValues(1f, 0.1f, 1f);
        animator.setDuration(BLINK_DURATION);
        return animator;
    }

    public static ObjectAnimator keep(View view, long duration) {
        if (view == null) return null;
        ObjectAnimator animator = new ObjectAnimator();
        animator.setTarget(view);
        animator.setPropertyName("translationX");
        animator.setFloatValues( view.getTranslationX(), view.getTranslationX());
        animator.setDuration(duration);
        return animator;
    }

    public static ObjectAnimator glanceLeft(View view) {
        if (view == null) return null;
        ObjectAnimator animator = new ObjectAnimator();
        animator.setTarget(view);
        animator.setPropertyName("translationX");
        animator.setFloatValues( 0f, -150f);
        animator.setDuration(500);
        return animator;
    }

    public static ObjectAnimator back(View view) {
        if (view == null) return null;

//        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat("translationX", view.getTranslationX(), 0f);
//        PropertyValuesHolder translationY = PropertyValuesHolder.ofFloat("translationY", view.getTranslationY(), 0f);
//
//        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, translationX, translationY);
        ObjectAnimator animator = new ObjectAnimator();
        animator.setTarget(view);
        animator.setPropertyName("translationX");
        animator.setFloatValues( view.getTranslationX(), 0f);
        animator.setDuration(500);
        return animator;
    }


    public static void setAnimation(AnimatorSet animatorSet) {
        animatorSet.addListener(new AnimatorListenerAdapter() {
            private boolean mCanceled;

            @Override
            public void onAnimationCancel(Animator animation) {
                mCanceled = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!mCanceled) {
                    animation.start();
                }
            }
            @Override
            public void onAnimationStart(Animator animation) {
                mCanceled = false;
            }
        });
    }
}
