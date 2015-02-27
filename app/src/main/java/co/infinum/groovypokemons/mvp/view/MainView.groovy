package co.infinum.groovypokemons.mvp.view;

import java.util.ArrayList;

import co.infinum.groovypokemons.model.Item;

/**
 * Created by ivan on 13/06/14.
 */
public interface MainView {

    public void showItems(ArrayList<Item> items);

    public void showLoadingLayout();

    public void hideLoadingLayout();

    void showDialog(Item item);
}
