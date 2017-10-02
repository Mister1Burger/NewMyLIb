package com.example.mylibrary;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.exceptions.RealmMigrationNeededException;

public class RealmThing {

    public RealmThing() {
    }

    private Realm init(Context context) {
        Realm.init(context);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("reminder.realm")
                .modules(new MyLibraryModule())
                .build();

        try {
            return Realm.getInstance(realmConfiguration);
        } catch (RealmMigrationNeededException e) {
            try {
                Log.e("TAG", String.valueOf(e));
                Realm.deleteRealm(realmConfiguration);
                //Realm file has been deleted.
                return Realm.getInstance(realmConfiguration);
            } catch (Exception ex) {
                //No Realm file to remove.
                Log.e("TAG", String.valueOf(ex));
            }
        }

        return null;
    }


    public List<SecondElementImpl> readElement(Context context) {
        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        try {
            assert realm != null;
            RealmResults<SecondElementImpl> list = realm.where(SecondElementImpl.class).findAll();
            Log.d("TAG", String.valueOf(realmFile.length()));
            if (list == null)
                return new ArrayList<>();
            return list;
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    public void saveElement(Context context, SecondElementImpl secondElement) {

        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(secondElement);
            Log.d("TAG", String.valueOf(realmFile.length()));
            realm.commitTransaction();
        } catch (NullPointerException ignore) {
        }
    }


    public void removeElement(Context context, String name) {
        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
            SecondElementImpl secondElement = realm.where(SecondElementImpl.class)
                    .equalTo("name", name).findFirst();
            if (secondElement != null) {
                realm.beginTransaction();
                secondElement.deleteFromRealm();
                realm.commitTransaction();
            }
            Log.d("TAG", String.valueOf(realmFile.length()));
        } catch (NullPointerException ignore) {
        }
    }


    public void onDestroy(Context context) {
        Realm realm = init(context);
        assert realm != null;
        realm.close();
    }
}