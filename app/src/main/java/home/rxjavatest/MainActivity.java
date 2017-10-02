package home.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mylibrary.DataBaseControler;
import com.example.mylibrary.SecondElement;
import com.example.mylibrary.SecondElementImpl;
import com.levup.mylibrary.CurrencyListView;
import com.levup.mylibrary.Element;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view);


        CurrencyListView currencyListView = (CurrencyListView) findViewById(R.id.currency_list_view);
        DataBaseControler dbc = new DataBaseControler(this);

        currencyListView.setAddListener(elementImpl -> Log.d("TAG", "add " + elementImpl.toString()));
        currencyListView.setRemoveListener(elementImpl -> Log.d("TAG", "remove " + elementImpl.toString()));


        currencyListView.setAddListener(element -> {
            SecondElementImpl secondElement = new SecondElementImpl();
            secondElement.setName(element.getName());
            secondElement.setInfo(element.getInfo());
            dbc.saveToBase(secondElement);
        });

        currencyListView.setRemoveListener(element ->
                dbc.deleteFromBase(element.getName()));


        List<Element> list = new ArrayList<>();
        for (SecondElement a : dbc.readFromBase()) {
            Elements element = new Elements();
            element.setInfo(a.getInfo());
            element.setName(a.getName());
            list.add(element);
        }
        currencyListView.addAll(list);


    }
}
