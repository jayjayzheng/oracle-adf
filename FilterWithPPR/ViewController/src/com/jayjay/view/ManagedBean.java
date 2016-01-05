package com.jayjay.view;

import javax.faces.event.ActionEvent;

import oracle.adf.share.ADFContext;

public class ManagedBean {

    public void setParams(ActionEvent ae) {
        ADFContext adfc = ADFContext.getCurrent();
        adfc.getRequestScope().put("Page", "test3");
    }
}
