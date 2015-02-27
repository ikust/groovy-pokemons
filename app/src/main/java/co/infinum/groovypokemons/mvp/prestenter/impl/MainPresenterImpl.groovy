package co.infinum.groovypokemons.mvp.prestenter.impl
import co.infinum.groovypokemons.model.Item
import co.infinum.groovypokemons.mvp.interactor.MainInteractor
import co.infinum.groovypokemons.mvp.interactor.impl.RemoteMainInteractor
import co.infinum.groovypokemons.mvp.listener.ItemLoadListener
import co.infinum.groovypokemons.mvp.prestenter.MainPresenter
import co.infinum.groovypokemons.mvp.view.MainView
/**
 * Created by ivan on 13/06/14.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    private MainInteractor mainInteractor = new RemoteMainInteractor(   );

    @Override public void init() {
        mainView.showLoadingLayout();
        mainInteractor.loadItems([
                success: { items ->
                    mainView.hideLoadingLayout();
                    mainView.showItems(items);
                },

                fail: { error ->

                }
        ] as ItemLoadListener);
    }

    @Override public void onItemClick(Item item) {
        mainView.showDialog(item);
    }

}
