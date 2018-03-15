package yackeen.com.faragallah.Helpers;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import static yackeen.com.faragallah.Helpers.Screeninfo.getScreenHeight;

/**
 * Created by elmar7om on 10/12/2016.
 */

public class RecyclerAnimator {
    public static void runEnterAnimation(View view, int adapterPosition) {
        view.setTranslationY(getScreenHeight(view.getContext()));
        view.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(3.f))
                .setDuration(500 + 250 * adapterPosition)
                .start();
    }

    public static void RightToLeftAnimation(Context context, View view, int position, int screenWidth) {
        view.setTranslationX(screenWidth);
        view.animate().translationX(0)
                .setInterpolator(new DecelerateInterpolator(1.f))
                .setDuration(500 + (500 * position))
                .start();
    }

    public static void LeftToRightAnimation(Context context, View view, int position, int screenWidth) {
        view.setTranslationX(screenWidth);
        view.animate().translationX(0)
                .setInterpolator(new AccelerateInterpolator(-1.f))
                .setDuration(500 + (500 * position))
                .start();
    }

    public static void BottomToTopAnimation(Context context, View view, int position) {
        view.setTranslationY(Screeninfo.getScreenHeight(context));
        view.animate().translationY(0)
                .setInterpolator(new DecelerateInterpolator(3.f))
                .setDuration(500 + (250 * position))
                .start();
    }
}
