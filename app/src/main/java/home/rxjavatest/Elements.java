package home.rxjavatest;

import com.example.mylibrary.SecondElement;
import com.levup.mylibrary.Element;

/**
 * Created by java on 27.09.2017.
 */

public class Elements implements Element, SecondElement {
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId(long id) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void setInfo(String info) {

    }
}
