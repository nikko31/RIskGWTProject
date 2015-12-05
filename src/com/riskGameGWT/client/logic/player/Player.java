package com.riskGameGWT.client.logic.player;



import com.riskGameGWT.client.logic.Color;
import com.riskGameGWT.client.logic.board.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int playerID;
    private String playerName;
    private int freeUnits;
    private Color playerColor;
    private List<Card> cards;
    private List<String> continentList;

    public Player(int playerID, String playerName, int freeUnits, Color color) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.playerColor = color;
        this.freeUnits = freeUnits;
        this.cards = new ArrayList<>();
        this.continentList = new ArrayList<>();
    }

    public int getPlayerID() {
        return playerID;
    }


    public String getPlayerName() {
        return playerName;
    }


    public int getFreeUnits() {
        return freeUnits;
    }

    public void setFreeUnits(int freeUnits) {
        this.freeUnits = freeUnits;
    }

    public Color getPlayerColor() {
        return playerColor;
    }


    public List<String> getContinentList() {
        return continentList;
    }

    public void setContinentList(List<String> continentList) {
        this.continentList = continentList;
    }

    public void addPlayerCard(Card card){
        cards.add(card);
    }

    public void removePlayerCard(List<Card> cardsToRemove ){
        for(Card carditer : cardsToRemove){
            cards.remove(carditer);
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
