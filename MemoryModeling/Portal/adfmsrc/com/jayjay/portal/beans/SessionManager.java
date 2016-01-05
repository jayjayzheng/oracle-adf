package com.jayjay.portal.beans;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class SessionManager implements HttpSession {
    public SessionManager() {
        super();
    }

    public long getCreationTime() {
        return 0L;
    }

    public String getId() {
        return null;
    }

    public long getLastAccessedTime() {
        return 0L;
    }

    public ServletContext getServletContext() {
        return null;
    }

    public void setMaxInactiveInterval(int i) {
    }

    public int getMaxInactiveInterval() {
        return 0;
    }

    public HttpSessionContext getSessionContext() {
        return null;
    }

    public Object getAttribute(String string) {
        return null;
    }

    public Object getValue(String string) {
        return null;
    }

    public Enumeration getAttributeNames() {
        return null;
    }

    public String[] getValueNames() {
        return new String[0];
    }

    public void setAttribute(String string, Object object) {
    }

    public void putValue(String string, Object object) {
    }

    public void removeAttribute(String string) {
    }

    public void removeValue(String string) {
    }

    public void invalidate() {
    }

    public boolean isNew() {
        return false;
    }
}
