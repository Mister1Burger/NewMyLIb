package home.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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

        currencyListView.setAddListener(element -> Log.d("TAG", "add " + element.toString()));
        currencyListView.setRemoveListener(element -> Log.d("TAG", "remove " + element.toString()));


        List list = new ArrayList();
        Element element = new Element();
        element.setInfo("info");
        element.setName("name");
        list.add(element);
        currencyListView.addAll(list);

    }
}
