package Javaprojectcards;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static void gameEngine() {
        Scanner scanner = new Scanner(System.in);
        Deck startingDeck = new Deck();
        Deck.Card newOne;
        String[] cardsColors = new String[]{"clubs", "diamonds", "hearts", "spades"};
        String[] cardsRanks = new String[]{"Ace", "King", "Queen", "Jack"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newOne = new Deck.Card(cardsRanks[i], cardsColors[j]);
                startingDeck.addCard(newOne);
            }
        }
        startingDeck.shuffleDeck();
        Deck computersDeck = new Deck();
        computersDeck = startingDeck.firstPlayerCardsDraw();
        Deck humansPlayerDeck = new Deck();
        humansPlayerDeck = startingDeck.secondPlayerCardsDraw();
        Random randomInt = new Random();
        int indexComp;
        int indexHuman;
        Deck computerWinHands = new Deck();
        Deck humanWinHands = new Deck();
        Random intForTurn = new Random();
        boolean computerWins = true;
        int forTurn = intForTurn.nextInt(1, 3);
        if (forTurn == 1) {
            System.out.println("Computer will be first!");
            humansPlayerDeck.printDeck();
            indexComp = randomInt.nextInt(0, computersDeck.cards.size());
            Deck.Card cardComp = computersDeck.cardDraw(indexComp);
            System.out.println("Computer gave: " + cardComp.rank + " of " + cardComp.color);
            System.out.println("Choose a card:");
            indexHuman = Integer.parseInt(scanner.nextLine());
            Deck.Card cardHuman = humansPlayerDeck.cardDraw(indexHuman);
            System.out.println("You gave: " + cardHuman.rank + " of " + cardHuman.color);
            int win = Deck.compareTwoCards(cardComp, cardHuman);
            if (win == 1) {
                System.out.println("Computer wins this round!");
                computerWinHands.addCard(cardComp);
                computerWinHands.addCard(cardHuman);
                computerWins = true;
            } else {
                computerWins = false;
                System.out.println("You win this round!");
                humanWinHands.addCard(cardComp);
                humanWinHands.addCard(cardHuman);
            }
        } else {
            System.out.println("You will be fist!");
            humansPlayerDeck.printDeck();
            indexHuman = Integer.parseInt(scanner.nextLine());
            Deck.Card cardHuman = humansPlayerDeck.cardDraw(indexHuman);
            System.out.println("You gave: " + cardHuman.rank + " of " + cardHuman.color);
            int compCardIndex = 0;
            boolean computerHasABiggerCard = false;
            for (int i = 0; i < computersDeck.cards.size(); i++) {
                if (cardHuman.cardRank < computersDeck.cards.get(i).cardRank) {
                    compCardIndex = i;
                    computerHasABiggerCard = true;
                    break;
                }
            }
            if (!computerHasABiggerCard) {
                compCardIndex = randomInt.nextInt(0, computersDeck.cards.size());
            }
            Deck.Card cardComp = computersDeck.cardDraw(compCardIndex);
            System.out.println("Computer gave: " + cardComp.rank + " of " + cardComp.color);
            System.out.println("Choose a card:");
            int win = Deck.compareTwoCards(cardComp, cardHuman);
            if (win == 1) {
                System.out.println("Computer wins this round!");
                computerWinHands.addCard(cardComp);
                computerWinHands.addCard(cardHuman);
                computerWins = true;
            } else {
                computerWins = false;
                System.out.println("You win this round!");
                humanWinHands.addCard(cardComp);
                humanWinHands.addCard(cardHuman);
            }
        }

        for (int i = 0; i < 4; i++) {
            if (computerWins) {
                System.out.println("Computer will be first this round!");
                humansPlayerDeck.printDeck();
                indexComp = randomInt.nextInt(0, computersDeck.cards.size());
                Deck.Card cardComp = computersDeck.cardDraw(indexComp);
                System.out.println("Computer gave: " + cardComp.rank + " of " + cardComp.color);
                System.out.println("Choose a card:");
                indexHuman = Integer.parseInt(scanner.nextLine());
                Deck.Card cardHuman = humansPlayerDeck.cardDraw(indexHuman);
                System.out.println("You gave: " + cardHuman.rank + " of " + cardHuman.color);
                int win = Deck.compareTwoCards(cardComp, cardHuman);
                if (win == 1) {
                    System.out.println("Computer wins this round!");
                    computerWinHands.addCard(cardComp);
                    computerWinHands.addCard(cardHuman);
                    computerWins = true;
                } else {
                    computerWins = false;
                    System.out.println("You win this round!");
                    humanWinHands.addCard(cardComp);
                    humanWinHands.addCard(cardHuman);
                }
            } else {
                System.out.println("You will be fist this round!");
                humansPlayerDeck.printDeck();
                indexHuman = Integer.parseInt(scanner.nextLine());
                Deck.Card cardHuman = humansPlayerDeck.cardDraw(indexHuman);
                System.out.println("You gave: " + cardHuman.rank + " of " + cardHuman.color);
                int compCardIndex = 0;
                boolean computerHasABiggerCard = false;
                for (int j = 0; j < computersDeck.cards.size(); j++) {
                    if (cardHuman.cardRank < computersDeck.cards.get(j).cardRank) {
                        compCardIndex = j;
                        computerHasABiggerCard = true;
                        break;
                    }
                }
                if (!computerHasABiggerCard) {
                    compCardIndex = randomInt.nextInt(0, computersDeck.cards.size());
                }
                Deck.Card cardComp = computersDeck.cardDraw(compCardIndex);
                System.out.println("Computer gave: " + cardComp.rank + " of " + cardComp.color);
                System.out.println("Choose a card:");
                int win = Deck.compareTwoCards(cardComp, cardHuman);
                if (win == 1) {
                    System.out.println("Computer wins this round!");
                    computerWinHands.addCard(cardComp);
                    computerWinHands.addCard(cardHuman);
                    computerWins = true;
                } else {
                    computerWins = false;
                    System.out.println("You win this round!");
                    humanWinHands.addCard(cardComp);
                    humanWinHands.addCard(cardHuman);
                }
            }
        }

        int computersPoints = 0;
        int humansPoints = 0;

        for (int i = 0; i < computerWinHands.cards.size(); i++) {
            computersPoints += computerWinHands.cards.get(i).cardRank;
        }

        for (int i = 0; i < humanWinHands.cards.size(); i++) {
            humansPoints += humanWinHands.cards.get(i).cardRank;
        }

        if (computersPoints > humansPoints) {
            System.out.println("");
            System.out.println("Game over! You loose!");
        } else if (computersPoints < humansPoints) {
            System.out.println("");
            System.out.println("Congratulations! You win!");
        } else {
            System.out.println("");
            System.out.println("Draw!");
        }
        Menu.playAgain();
    }

}

