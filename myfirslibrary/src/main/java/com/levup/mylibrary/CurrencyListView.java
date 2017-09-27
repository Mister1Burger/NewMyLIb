package com.levup.mylibrary;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyListView extends LinearLayout {

    @BindView(R2.id.rv)
    RecyclerView resView;
    @BindView(R2.id.editText)
    EditText et_name;
    @BindView(R2.id.editText2)
    EditText et_info;
    @BindView(R2.id.button)
    Button btn_save;

    private ResViewAdapter adapter;

    private Context context;

    private ItemListener addListener;
    private ItemListener removeListener;

    public void setRemoveListener(ItemListener removeListener) {
        this.removeListener = removeListener;
    }

    public void setAddListener(ItemListener addListener) {
        this.addListener = addListener;
    }

    public CurrencyListView(Context context) {
        super(context);
        init(context);
    }

    public CurrencyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler, this);
        this.context = context;

        ButterKnife.bind(this, view);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        resView.setLayoutManager(llm);

        adapter = new ResViewAdapter(new ArrayList<>(), s -> remove(s));
        resView.setAdapter(adapter);


        btn_save.setOnClickListener(view1 -> add());

    }

    private void add() {
        ElementImpl elementImpl = new ElementImpl();
        elementImpl.setName(et_name.getText().toString());
        elementImpl.setInfo(et_info.getText().toString());
        adapter.addElement(elementImpl);
        addListener.getElement(elementImpl);

    }

    public void addAll(List<Element> list) {
        for (Element e : list) {
            ElementImpl element = new ElementImpl();
            element.setId(e.getId());
            element.setInfo(e.getInfo());
            element.setName(e.getName());
            adapter.addElement(element);
        }
    }

    private void remove(Element element) {
        adapter.getElementImpls().remove(element);
        adapter.notifyDataSetChanged();
        removeListener.getElement(element);
    }

}
