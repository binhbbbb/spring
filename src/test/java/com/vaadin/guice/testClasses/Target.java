package com.vaadin.guice.testClasses;

import com.google.inject.Inject;

public class Target {
    @Inject
    private Prototype1 prototype1;

    @Inject
    private Singleton1 singleton1;

    @Inject
    private UIScoped1 uiScoped1;

    @Inject
    private UIScoped2 uiScoped2;

    @Inject
    private ViewScoped1 viewScoped1;

    @Inject
    private ViewScoped2 viewScoped2;

    public Prototype1 getPrototype1() {
        return prototype1;
    }

    public void setPrototype1(Prototype1 prototype1) {
        this.prototype1 = prototype1;
    }

    public Singleton1 getSingleton1() {
        return singleton1;
    }

    public void setSingleton1(Singleton1 singleton1) {
        this.singleton1 = singleton1;
    }

    public UIScoped1 getUiScoped1() {
        return uiScoped1;
    }

    public void setUiScoped1(UIScoped1 uiScoped1) {
        this.uiScoped1 = uiScoped1;
    }

    public UIScoped2 getUiScoped2() {
        return uiScoped2;
    }

    public void setUiScoped2(UIScoped2 uiScoped2) {
        this.uiScoped2 = uiScoped2;
    }

    public ViewScoped1 getViewScoped1() {
        return viewScoped1;
    }

    public void setViewScoped1(ViewScoped1 viewScoped1) {
        this.viewScoped1 = viewScoped1;
    }

    public ViewScoped2 getViewScoped2() {
        return viewScoped2;
    }

    public void setViewScoped2(ViewScoped2 viewScoped2) {
        this.viewScoped2 = viewScoped2;
    }
}