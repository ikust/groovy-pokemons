package co.infinum.groovypokemons.mvp.interactor.impl
import android.widget.ImageView
import co.infinum.groovypokemons.MvpApplication
import co.infinum.groovypokemons.R
import co.infinum.groovypokemons.models.Item
import co.infinum.groovypokemons.mvp.interactor.MainInteractor
import co.infinum.groovypokemons.mvp.listener.ItemLoadListener
import com.squareup.picasso.Picasso

/**
 * Interactor implementation that loads Pokemon data from assets.
 */
class AssetsMainInteractor implements MainInteractor {

    static def CACHED_IMAGE_FORMAT = "pokemon_%d";

    static def getPokemonId = { int pokemonNumber ->
        MvpApplication.getInstance().getResources()
                .getIdentifier(
                String.format(CACHED_IMAGE_FORMAT, pokemonNumber),
                "drawable",
                MvpApplication.getInstance().getPackageName()
        )
    }

    static def setImageToView(ImageView imageView, int pokemonNumber) {
        Picasso.with(imageView.getContext())
                .load(getPokemonId(pokemonNumber)).into(imageView);
    }

    @Override
    def void loadItems(ItemLoadListener listener) {
        ArrayList<Item> items = new ArrayList<Item>();

        String[] pokemonNames = MvpApplication
                .getInstance()
                .getResources()
                .getStringArray(R.array.pokemons);

        pokemonNames.eachWithIndex { String entry, int i ->
            items.add([
                    getTitle      : { entry },
                    getSubtitle   : { "#" + (i + 1) },
                    setImageToView: { imageView -> setImageToView(imageView, i + 1) }
            ] as Item)
        }

        listener.success(items);
    }

}


