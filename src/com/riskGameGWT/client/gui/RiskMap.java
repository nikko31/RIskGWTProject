package com.riskGameGWT.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.riskGameGWT.client.GameResources;
import org.vectomatic.dom.svg.OMElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Dark-Linux on 04/12/2015.
 */
public class RiskMap extends Composite {
    interface RiskMapUiBinder extends UiBinder<Widget, RiskMap> {
    }


    private final MapSVG riskMapSVG;
    private OMSVGSVGElement boardElt;
    private List<HandlerRegistration> territoryHandlers = new ArrayList<HandlerRegistration>();

    /*---------default colors----------*/
    private static final String DEFAULT_FILL_PROPERTY_VALUE_RED = "red";

    private static final String DEFAULT_STROKE = "stroke:#000000";
    private static final String SELECTED_STROKE = "stroke:#000000";
    private static final String DEFAULT_STROKE_WIDTH = "stroke-width:1.20000005";
    private static final String SELECTED_STROKE_WIDTH = "stroke-width:5";
    private static final String DEFAULT_FILL = "fill:#ffffff";
    /*<------------------------------->*/
    @UiField
    FlowPanel display;

    @UiField
    HTML mapContainer;

    public RiskMap() {
        riskMapSVG = GWT.create(MapSVG.class);
        RiskMapUiBinder ourUiBinder = GWT.create(RiskMapUiBinder.class);
        initWidget(ourUiBinder.createAndBindUi(this));
        display.getElement().setId("container");
        mapContainer.getElement().setId("map");
        boardElt = OMSVGParser.parse(riskMapSVG.riskMap().getText());
        mapContainer.getElement().appendChild(boardElt.getElement());
        display.setStyleName("map");
        mapContainer.getElement().getStyle().setWidth(70, Style.Unit.PCT);

        territoryHandlers.addAll(addHandlers(GameResources.SVG_ID_MAP));

    }

    private List<HandlerRegistration> addHandlers(Map<String, Integer> svgNameMap) {
        List<HandlerRegistration> handlerRegistrations = new ArrayList<HandlerRegistration>();
        for (String territory : svgNameMap.keySet()) {
            final OMElement territoryEl = boardElt.getElementById(territory);
            final OMElement territoryText = boardElt.getElementById(territory + "_text");
            final OMElement territoryUnits = boardElt.getElementById(territory + "_units");

            MouseDownHandler handler = new MouseDownHandler() {
                @Override
                public void onMouseDown(MouseDownEvent event) {
                    String style = territoryEl.getAttribute("style");
                    style = style.replaceFirst(DEFAULT_STROKE_WIDTH, SELECTED_STROKE_WIDTH);

                    territoryEl.setAttribute("style", style);

                    String curUnits = territoryUnits.getFirstChild().getFirstChild().getNodeValue();
                    territoryUnits.getFirstChild().getFirstChild().setNodeValue(Integer.toString(Integer.parseInt(curUnits) + 1));
                }
            };


            handlerRegistrations.add(territoryEl.addDomHandler(handler, MouseDownEvent.getType()));
            handlerRegistrations.add(territoryText.addDomHandler(handler, MouseDownEvent.getType()));
            handlerRegistrations.add(territoryUnits.addDomHandler(handler, MouseDownEvent.getType()));
        }
        return handlerRegistrations;
    }

}