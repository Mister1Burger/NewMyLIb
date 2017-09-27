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
        realmThing.saveReminder(context, secondElement1);

   }

   public void deleteFromBase (SecondElement secondElement){
       RealmThing realmThing = new RealmThing();
       SecondElementImpl secondElement1 = new SecondElementImpl();
       secondElement1.setName(secondElement.getName());
       realmThing.removePerson(context, secondElement1.toString());
   }

   private List<SecondElement>  readFromBase (){
       RealmThing realmThing = new RealmThing();
       List<SecondElement> list = new ArrayList<>();
       for (SecondElement e:realmThing.readPersons(context)) {
       SecondElementImpl secondElement = new SecondElementImpl();
           secondElement.setName(e.getName());
           secondElement.setInfo(e.getInfo());
           list.add(secondElement);
       }
       return list;

   }

}
