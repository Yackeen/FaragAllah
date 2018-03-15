package yackeen.com.faragallah.Helpers.ImageLoader;

import android.content.Context;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Picasso;

import yackeen.com.faragallah.R;


/**
 * Created by elmar7om on 10/01/2018.
 */

public class ImageLoader {
    public static void loadImage(Context context, final ProgressBar progress, ImageView imageView, String url) {
        if (url != null && !url.trim().isEmpty()) {
            progress.setVisibility(View.VISIBLE);
            Glide.with(context).load(url.trim()).diskCacheStrategy(DiskCacheStrategy.RESULT).error(R.drawable.ic_warning).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    progress.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    progress.setVisibility(View.GONE);
                    return false;
                }
            }).into(imageView);
        }
//            Picasso.with(context).load(url.trim()).error(R.drawable.ic_warning).into(imageView);

    }

    public static void loadBase64Image(Context context, ImageView imageView, String url) {
        if (url != null && !url.trim().isEmpty())
            Glide.with(context).load(getBase64DecodedBytes(url)).override(600, 400).error(R.drawable.ic_warning).into(imageView);

    }

    public static void loadBase64CircleImage(Context context, final ProgressBar progress, ImageView imageView, String url) {
        if (url != null && !url.trim().isEmpty())
            Glide.with(context).load(url.trim())
                    .error(R.drawable.ic_error).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    progress.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    progress.setVisibility(View.GONE);
                    return false;
                }
            }).into(imageView);
//        Picasso.with(context).load(url.trim()).error(R.drawable.ic_error).into(imageView);
    }

    private static byte[] getBase64DecodedBytes(String base64) {
        return Base64.decode(base64, Base64.DEFAULT);
//        imageView.setImageBitmap(BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length));
    }
}
