package Javaprojectcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    public List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void printDeck() {
        for (int i = 0; i < this.cards.size(); i++) {
            System.out.println("["+i+"] "+this.cards.get(i).rank +" of "+this.cards.get(i).color+" - "+this.cards.get(i).cardRank);
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public Deck firstPlayerCardsDraw() {
        Random number = new Random();
        int randomInt;
        Deck firstPlayerDeck = new Deck();
        int counter = 15;
        for (int i = 0; i < 5; i++) {
            randomInt = number.nextInt(0,counter);
            counter--;
            firstPlayerDeck.addCard(this.cards.get(randomInt));
            this.cards.remove(randomInt);
            counter--;
        }
        return firstPlayerDeck;
    }

    public Deck secondPlayerCardsDraw() {
        Random number = new Random();
        int randomInt;
        int counter = 10;
        Deck secondPlayerDeck = new Deck();
        for (int i = 0; i < 5; i++) {
            randomInt = number.nextInt(0,counter);
            secondPlayerDeck.addCard(this.cards.get(randomInt));
            this.cards.remove(randomInt);
            counter--;
        }
        return secondPlayerDeck;
    }

    public Card cardDraw(int index) {
        Card card = this.cards.get(index);
        this.cards.remove(index);
        return card;
    }

    public static Integer compareTwoCards(Card card1, Card card2) {
        if (card1.rankNumber > card2.rankNumber) {
            return 1;
        } else if (card1.rankNumber < card2.rankNumber){
            return 2;
        } else {
            if (card1.colorRank > card2.colorRank) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static class Card {
        public String rank;
        public int rankNumber;
        public int colorRank;
        public String color;
        public int cardRank;

        public Card(String rank, String color) {
            this.rank = rank;
            switch (this.rank) {
                case "Ace":
                    this.rankNumber = 11;
                    break;
                case "King":
                    this.rankNumber = 10;
                    break;
                case "Queen":
                    this.rankNumber = 9;
                    break;
                case "Jack":
                    this.rankNumber = 8;
                    break;
            }
            this.color = color;
            switch (this.color) {
                case "clubs":
                    this.colorRank = 1;
                    break;
                case "diamonds":
                    this.colorRank = 2;
                    break;
                case "hearts":
                    this.colorRank = 3;
                    break;
                case "spades":
                    this.colorRank = 4;
                    break;
            }
            this.cardRank = this.rankNumber*this.colorRank;
        }

        public void show() {
            System.out.println("Car: " + this.rank + " of " + this.color);
        }
    }
}
