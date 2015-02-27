package co.infinum.groovypokemons.mvp.prestenter;

import co.infinum.groovypokemons.model.Item;

/**
 * Created by ivan on 13/06/14.
 */
public interface MainPresenter {

    public void init();

    public void onItemClick(Item item);

}