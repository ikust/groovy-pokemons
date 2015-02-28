package co.infinum.groovypokemons.mvp.prestenter.impl

import co.infinum.groovypokemons.models.Item
import co.infinum.groovypokemons.mvp.interactor.MainInteractor
import co.infinum.groovypokemons.mvp.listener.ItemLoadListener
import co.infinum.groovypokemons.mvp.prestenter.MainPresenter
import co.infinum.groovypokemons.mvp.view.MainView

/**
 * Created by ivan on 13/06/14.
 */
class MainPresenterImpl implements MainPresenter {

    def MainView view;

    def MainInteractor interactor;

    def void init() {
        view.showLoadingLayout();
        interactor.loadItems([
                success: { items ->
                    view.hideLoadingLayout();
                    view.showItems(items);
                },
                fail: { error ->

                }
        ] as ItemLoadListener)
    }

    def void onItemClick(Item item) {
        view.showDialog(item);
    }

}
