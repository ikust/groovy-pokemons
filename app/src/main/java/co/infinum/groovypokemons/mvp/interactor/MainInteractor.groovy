package co.infinum.groovypokemons.mvp.interactor;

import co.infinum.groovypokemons.mvp.listener.ItemLoadListener;

/**
 * Created by ivan on 13/06/14.
 */
public interface MainInteractor {

    public void loadItems(ItemLoadListener listener);
}
