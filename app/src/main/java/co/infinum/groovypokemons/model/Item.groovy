package co.infinum.groovypokemons.model;

import android.widget.ImageView;

/**
 * Created by ivan on 13/06/14.
 */
public interface Item {

    public String getTitle();

    public String getSubtitle();

    public void setImageToView(ImageView imageView);
}
