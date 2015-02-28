package co.infinum.groovypokemons.mvp.listener

import co.infinum.groovypokemons.models.Item;

/**
 * Created by ivan on 13/06/14.
 */
public interface ItemLoadListener {

    public void success(ArrayList<Item> items);

    public void fail(String error);
}
