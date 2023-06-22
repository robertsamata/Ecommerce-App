package com.example.ecommerce;

import io.realm.annotations.RealmModule;
import com.example.ecommerce.User;

@RealmModule(classes = {User.class})
public class MyRealmModule {
}