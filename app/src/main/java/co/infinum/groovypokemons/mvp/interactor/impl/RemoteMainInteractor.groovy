package co.infinum.groovypokemons.mvp.interactor.impl
import android.util.Log
import co.infinum.groovypokemons.MvpApplication
import co.infinum.groovypokemons.R
import co.infinum.groovypokemons.model.impl.PokemonRemoteItem
import co.infinum.groovypokemons.mvp.interactor.MainInteractor
import co.infinum.groovypokemons.mvp.listener.ItemLoadListener
import co.infinum.groovypokemons.retrofit.ApiInterface
import retrofit.Callback
import retrofit.RestAdapter
/**
 * Created by ivan on 09/06/14.
 */
class RemoteMainInteractor implements MainInteractor {

    public static final int ITEM_COUNT = 9;

    private static final int START_ID = 2;

    def apiInterface

    def items = []

    def callback

    @Override public void loadItems(ItemLoadListener listener) {
        String endpoint = MvpApplication.getInstance().getString(R.string.api_server);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLog(new RestAdapter.Log() {
                    @Override public void log(String message) {
                        Log.d("Retrofit", message);
                    }
                })
                .setEndpoint(endpoint)
                .build();

        apiInterface = restAdapter.create(ApiInterface.class);

        callback = [
                success: { item, response ->
                    items.add(item);

                    if(items.size() < ITEM_COUNT) {
                        apiInterface.getPokemon(items.size() + START_ID, callback);
                    } else {
                        listener.success(items);
                    }
                },
                failure: { error ->
                    error.printStackTrace();
                    listener.fail(MvpApplication.getInstance().getString(R.string.error_connectivity));
                }
        ] as Callback<PokemonRemoteItem>

        //Start from the second, first one doesn't return proper data.
        apiInterface.getPokemon(START_ID, callback);
    }
}
