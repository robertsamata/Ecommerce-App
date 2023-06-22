package com.example.ecommerce;

import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.annotations.RealmModule;


public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .allowWritesOnUiThread(true)
                .schemaVersion(1)
                .name("myrealm.realm")
                .modules(new MyRealmModule())
                .build();
        Realm.setDefaultConfiguration(config);
    }
}