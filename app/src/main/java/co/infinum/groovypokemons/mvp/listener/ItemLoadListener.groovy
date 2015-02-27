package co.infinum.groovypokemons.mvp.listener;

import java.util.ArrayList;

import co.infinum.groovypokemons.model.Item;

/**
 * Created by ivan on 13/06/14.
 */
public interface ItemLoadListener {

    public void success(ArrayList<Item> items);

    public void fail(String error);
}
