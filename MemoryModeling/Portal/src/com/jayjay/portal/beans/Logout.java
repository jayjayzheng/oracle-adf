package com.jayjay.portal.beans;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Logout {
    public Logout() {
    }

    public String doLogout() {

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        String url =
            ectx.getRequestContextPath() + "/adfAuthentication?logout=true&end_url=../";
        try {
            ectx.redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fctx.responseComplete();
        return null;
    }

    public String WebCenterLogout() {
        Class[] args = new Class[] { };
        String value =
            (String)this.resloveMethodExpression("#{o_w_s_l_LoginBackingBean.doLogout}",
                                                 String.class, args, null);
        System.out.println("The value from default webcenter logout bean: " +
                           value);
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();

        HttpSession session = (HttpSession)ectx.getSession(false);
        if (session != null) {
            System.out.println("session is not null");
            session.setMaxInactiveInterval(5);
            session.invalidate();
        }
        HttpServletRequest req = (HttpServletRequest)ectx.getRequest();
        String server = req.getServerName();
        String url = req.getScheme() + "://" + server + ":" + req.getServerPort();        
        System.err.println(url);

        try {
            ectx.redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fctx.responseComplete();
        return null;
    }

    private Object resloveMethodExpression(String expression, Class returnType,
                                           Class[] argTypes,
                                           Object[] argValues) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        MethodExpression methodExpression =
            elFactory.createMethodExpression(elContext, expression, returnType,
                                             argTypes);
        return methodExpression.invoke(elContext, argValues);
    }
}
