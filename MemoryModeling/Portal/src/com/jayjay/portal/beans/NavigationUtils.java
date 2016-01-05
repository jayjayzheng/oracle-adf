package com.jayjay.portal.beans;

import oracle.adf.share.ADFContext;

public class NavigationUtils {

    public boolean isLinkVisible() {
        System.out.println("called in navigation utils.");
        ADFContext adfc = ADFContext.getCurrent();
        if (adfc.getSecurityContext().isAuthenticated()) {
            return true;
        }
        return false;
    }
}
