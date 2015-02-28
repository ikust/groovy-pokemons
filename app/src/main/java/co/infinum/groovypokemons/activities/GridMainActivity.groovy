package co.infinum.groovypokemons.activities
import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ProgressBar
import co.infinum.groovypokemons.R
import co.infinum.groovypokemons.adapters.ItemAdapter
import co.infinum.groovypokemons.models.Item
import co.infinum.groovypokemons.mvp.prestenter.MainPresenter
import co.infinum.groovypokemons.mvp.prestenter.impl.MainPresenterImpl
import co.infinum.groovypokemons.mvp.view.MainView
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
/**
 * 1. models/impl/PokemonRemoteItem
 * 2. interactor/impl/RemoteMainInteractor
 * 3. retrofit/ApiInterface
 * 4. dodat internet permission u AndroidManifest
 */
public class GridMainActivity extends Activity implements MainView {

    @InjectView(R.id.gridView) GridView gridView;
    @InjectView(R.id.progressBar) ProgressBar progressBar;

    private ItemAdapter adapter;

    private MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_main);

        SwissKnife.inject(this);
        SwissKnife.restoreState(this, savedInstanceState);

        adapter = new ItemAdapter(this, R.layout.griditem, new ArrayList<Item>());

        gridView.setOnItemClickListener(
                {
                    parent, view, position -> mainPresenter.onItemClick(adapter.getItem(position))
                } as AdapterView.OnItemClickListener
        );

        gridView.setAdapter(adapter);

        mainPresenter = new MainPresenterImpl(mainView: this);
        mainPresenter.init();
    }

    @Override public void showItems(ArrayList<Item> items) {
        adapter.clear();

        adapter.addAll(items);
    }

    @Override public void showLoadingLayout() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideLoadingLayout() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void showDialog(Item item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(item.getTitle());
        builder.setMessage(item.getSubtitle());

        builder.show();
    }
}
