package com.jayjay.view;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;

public class ManagedBean implements Serializable {
    
    private String selection;

    public List<Integer> getIterateList() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        return list;
    }

    public void onSelect(ValueChangeEvent vce) {
//        System.out.println("selecting new value...");
        String newValue = (String)vce.getNewValue();
        System.out.println("The new value is : " + newValue);
        this.setSelection(newValue);
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getSelection() {
        return selection;
    }
}
