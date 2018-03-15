// Generated code from Butter Knife. Do not modify!
package yackeen.com.faragallah.Products;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import yackeen.com.faragallah.R;

public class ProductsAdapter$ViewHolder2_ViewBinding implements Unbinder {
  private ProductsAdapter.ViewHolder2 target;

  private View view2131230769;

  @UiThread
  public ProductsAdapter$ViewHolder2_ViewBinding(final ProductsAdapter.ViewHolder2 target,
      View source) {
    this.target = target;

    View view;
    target.productName = Utils.findRequiredViewAsType(source, R.id.productName, "field 'productName'", TextView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler, "field 'recyclerView'", RecyclerView.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.logo, "field 'imageView'", ImageView.class);
    target.qrImageView = Utils.findRequiredViewAsType(source, R.id.qr, "field 'qrImageView'", ImageView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progressBar'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.card, "method 'OnItemViewClicked'");
    view2131230769 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnItemViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductsAdapter.ViewHolder2 target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.productName = null;
    target.recyclerView = null;
    target.imageView = null;
    target.qrImageView = null;
    target.progressBar = null;

    view2131230769.setOnClickListener(null);
    view2131230769 = null;
  }
}
