package com.example.mylibrary;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 27.09.2017.
 */

public class DataBaseControler {

    Context context;
    public DataBaseControler(Context context) {
        this.context = context;
    }
    public void saveToBase (SecondElement secondElement){
        RealmThing realmThing = new RealmThing();
        SecondElementImpl secondElement1 = new SecondElementImpl();
        secondElement1.setName(secondElement.getName());
        secondElement1.setInfo(secondElement.getInfo());
        realmThing.saveElement(context, secondElement1);

   }

   public void deleteFromBase (String name){
       RealmThing realmThing = new RealmThing();
       realmThing.removeElement(context, name);
   }

   public List<SecondElement>  readFromBase (){
       RealmThing realmThing = new RealmThing();
       List<SecondElement> list = new ArrayList<>();
       for (SecondElement e:realmThing.readElement(context)) {
       SecondElementImpl secondElement = new SecondElementImpl();
           secondElement.setName(e.getName());
           secondElement.setInfo(e.getInfo());
           list.add(secondElement);
       }
       return list;

   }

}
