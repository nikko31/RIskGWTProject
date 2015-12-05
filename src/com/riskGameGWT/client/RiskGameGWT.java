package com.riskGameGWT.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.riskGameGWT.client.gui.RiskMap;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class RiskGameGWT implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        RootPanel.get().add(new RiskMap());
    }


}
