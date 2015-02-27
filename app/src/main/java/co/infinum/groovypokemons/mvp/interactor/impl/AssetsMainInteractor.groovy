package co.infinum.groovypokemons.mvp.interactor.impl
import co.infinum.groovypokemons.MvpApplication
import co.infinum.groovypokemons.R
import co.infinum.groovypokemons.model.Item
import co.infinum.groovypokemons.mvp.interactor.MainInteractor
import com.squareup.picasso.Picasso

AssetsMainInteractor : MainInteractor {

       def loadItems =
                    {
                        listener ->
                            ArrayList<Item> items = new ArrayList<Item>();

                            String[] pokemonNames = MvpApplication
                                    .getInstance()
                                    .getResources()
                                    .getStringArray(R.array.pokemons);

                            for (int i = 1; i <= pokemonNames.length; i++) {
                                items.add([
                                        getTitle      : {
                                            pokemonNames[i - 1]
                                        },

                                        getSubtitle   : {
                                            "#" + 1
                                        },

                                        setImageToView: { imageView ->
                                            Picasso.with(imageView.getContext())
                                                    .load({
                                                MvpApplication.getInstance()
                                                        .getResources().getIdentifier(
                                                        String.format("pokemon_%d", pokemonNumber),
                                                        "drawable",
                                                        MvpApplication.getInstance().getPackageName()
                                                );
                                            })
                                                    .into(imageView);
                                        }
                                ] as Item)
                            }

                            listener.success(items);
                    }


}
