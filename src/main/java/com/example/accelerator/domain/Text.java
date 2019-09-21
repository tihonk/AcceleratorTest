package com.example.accelerator.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Text {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private ArrayList<String> listXE;
    private String dataXe;

    public Text(){}

    public Text(String dataXe) {
        this.dataXe = dataXe;
    }

    public Text(ArrayList<String>listXE) {
        this.listXE = listXE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<String> getListXE() {
        return listXE;
    }

    public void setListXE(ArrayList<String> listXE) {
        this.listXE = listXE;
    }

    public String getDataXe() {
        return dataXe;
    }

    public void setDataXe(String dataXe) {
        this.dataXe = dataXe;
    }
}
