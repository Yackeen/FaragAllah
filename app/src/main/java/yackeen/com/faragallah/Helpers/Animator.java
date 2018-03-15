package yackeen.com.faragallah.Helpers;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import static yackeen.com.faragallah.Helpers.Screeninfo.getScreenHeight;

/**
 * Created by elmar7om on 07/02/2018.
 */

public class Animator {

    public static void fade(View view, long duration) {
//        ObjectAnimator fadeAltAnim = ObjectAnimator.ofFloat(view, View.ALPHA, 0, 1);
//        fadeAltAnim.setDuration(duration);
//        fadeAltAnim.start();
//        return fadeAltAnim;
    }

    public static void scaleX(final View view, long duration, long delay, final String tag) {
//        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f);
//        scaleAnim.setDuration(duration);
//        scaleAnim.addListener(new android.animation.Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(android.animation.Animator animator) {
//                if (tag.equals("show"))
//                    view.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationEnd(android.animation.Animator animator) {
//                if (tag.equals("hide"))
//                    view.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onAnimationCancel(android.animation.Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(android.animation.Animator animator) {
//
//            }
//        });
//        scaleAnim.start();
//        scaleAnim.setStartDelay(delay);
//        return scaleAnim;
    }

    public static void deScaleX(final View view, long duration, long delay, final String tag) {
//        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f);
//        scaleAnim.setDuration(duration);
//        scaleAnim.setStartDelay(delay);
//        scaleAnim.addListener(new android.animation.Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(android.animation.Animator animator) {
//                if (tag.equals("show"))
//                    view.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationEnd(android.animation.Animator animator) {
//                if (tag.equals("hide"))
//                    view.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onAnimationCancel(android.animation.Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(android.animation.Animator animator) {
//
//            }
//        });
//        scaleAnim.start();
//        return scaleAnim;
    }

    public static void scaleY(final View view, long duration, long delay, final String tag) {
//        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f);
//        scaleAnim.setDuration(duration);
//        scaleAnim.start();
//        scaleAnim.setStartDelay(delay);
//        scaleAnim.addListener(new android.animation.Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(android.animation.Animator animator) {
//                if (tag.equals("show"))
//                    view.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationEnd(android.animation.Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationCancel(android.animation.Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(android.animation.Animator animator) {
//
//            }
//        });
//        return scaleAnim;
    }

    /*
    * AccelerateInterpolator	Rate of change starts out slowly and and then accelerates
    * BounceInterpolator	    Change bounces right at the end
    * DecelerateInterpolator	Rate of change starts out quickly and and then decelerates
    * LinearInterpolator	    Rate of change is constant throughout
     */
    public static ObjectAnimator move(View view, long duration) {
        ObjectAnimator moveAnim = ObjectAnimator.ofFloat(view, "Y", 1000);
        moveAnim.setDuration(duration);
        moveAnim.setInterpolator(new BounceInterpolator());
        moveAnim.start();
        return moveAnim;
    }

    public static void playTogether(View view, long duration, ObjectAnimator anim1, ObjectAnimator anim2) {
        AnimatorSet set1 = new AnimatorSet();
        set1.setDuration(duration);
        set1.playTogether(anim1, anim2);
    }

    public static void TranslationAnimation(final View view, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, int duration, final String tag) {
//        TranslationAnimation(mParent, 0.0f, 0.0f, 0.0f, -0.26f, 250, "show");
//        TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, fromXDelta,
//                Animation.RELATIVE_TO_PARENT, toXDelta, Animation.RELATIVE_TO_PARENT,
//                -fromYDelta, Animation.RELATIVE_TO_PARENT, toYDelta);
//        anim.setDuration(duration);
//        anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                if (tag.equals("show"))
//                    view.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                if (tag.equals("hide"))
//                    view.setVisibility(View.GONE);
//            }
//        });
//        view.startAnimation(anim);
    }
}
