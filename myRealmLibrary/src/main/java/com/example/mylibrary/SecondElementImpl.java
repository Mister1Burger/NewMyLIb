package com.example.mylibrary;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by java on 27.09.2017.
 */

public class SecondElementImpl extends RealmObject implements SecondElement  {
    @PrimaryKey
    private String name;
    private String info;


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                ", name=" + name +
                ", info='" + info + '\'' +
                '}';
    }
}
