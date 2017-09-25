package com.levup.mylibrary;


public class Element {

    private long id;
    private String name;
    private String info;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
                "id=" + id +
                ", name=" + name +
                ", info='" + info + '\'' +
                '}';
    }


}