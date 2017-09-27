package home.rxjavatest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mylibrary.DataBaseControler;
import com.example.mylibrary.SecondElement;
import com.levup.mylibrary.CurrencyListView;
import com.levup.mylibrary.Element;
import com.levup.mylibrary.ElementImpl;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view);

        CurrencyListView currencyListView = (CurrencyListView) findViewById(R.id.currency_list_view);
        DataBaseControler dbc = new DataBaseControler(getBaseContext());

        currencyListView.setAddListener(elementImpl -> Log.d("TAG", "add " + elementImpl.toString()));
        currencyListView.setRemoveListener(elementImpl -> Log.d("TAG", "remove " + elementImpl.toString()));


        List<Element> list = new ArrayList();
        ElementImpl elementImpl = new ElementImpl();
        Elements elements = new Elements();
        elementImpl.setInfo("info");
        elementImpl.setName("name");
        list.add(elementImpl);
        currencyListView.addAll(list);
        elements.setInfo(elementImpl.getInfo());
        elements.setName(elementImpl.getName());


    }
}
