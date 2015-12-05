package com.riskGameGWT.client.gui;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface MapSVG extends ClientBundle {

    @ClientBundle.Source("map/Risk_board.svg")
    TextResource riskMap();
}