package com.juaracoding.test.listeners;

import org.testng.IExecutionListener;

import com.juaracoding.test.DriverSingleton;

public class Hook implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.err.println("TestNG is commencing execution");
        DriverSingleton.createOrGetDriver();
    }

    @Override
    public void onExecutionFinish() {
        System.err.println("TestNG is finished execution");
        DriverSingleton.quitDriver();
    }
}
