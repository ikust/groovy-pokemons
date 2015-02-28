package co.infinum.groovypokemons.mvp.modules
import co.infinum.groovypokemons.mvp.interactor.impl.AssetsMainInteractor
import co.infinum.groovypokemons.mvp.prestenter.impl.MainPresenterImpl
/**
 * This class represents a Dagger module.
 */
class MainModule {

    static def presenter = MainPresenterImpl.newInstance()

    static def interactor = AssetsMainInteractor.instance;

}