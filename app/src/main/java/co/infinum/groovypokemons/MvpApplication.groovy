package co.infinum.groovypokemons;

import android.app.Application;

/**
 * Created by ivan on 13/06/14.
 */
public class MvpApplication extends Application {

    private static MvpApplication instance;

    @Override public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static MvpApplication getInstance() {
        instance;
    }
}
