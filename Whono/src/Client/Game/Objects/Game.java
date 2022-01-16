package Client.Game.Objects;

import Client.Game.Objects.GameScreen.Board;


public class Game extends Deck {

    Board board = new Board();

    //Get current card
    //Get previous placed card

    // Normal cards
    // Card must be same colour or number as last card

    // Plus Cards
    // Can always be played as +4
    // Must match last cards colour if +2

    // Skip & reverse cards
    // Must match last cards colour

    // Wildcard applies to all
    // Can always be played


    public static boolean canPlay(Card pileCard, Card toPlay) {

        if (toPlay.getCardColour() == Card.Colour.GREEN || toPlay.getCardColour() == Card.Colour.RED || toPlay.getCardColour() == Card.Colour.PURPLE || toPlay.getCardColour() == Card.Colour.YELLOW) {

            if (pileCard.getCardColour() == toPlay.getCardColour()) {

                return true;
            }
        }

        if (toPlay.getCardType() == Card.Type.ZERO || toPlay.getCardType() == Card.Type.ONE || toPlay.getCardType() == Card.Type.TWO || toPlay.getCardType() == Card.Type.THREE || toPlay.getCardType() == Card.Type.FOUR ||
                toPlay.getCardType() == Card.Type.FIVE || toPlay.getCardType() == Card.Type.SIX || toPlay.getCardType() == Card.Type.SEVEN || toPlay.getCardType() == Card.Type.EIGHT || toPlay.getCardType() == Card.Type.NINE) {

            if (pileCard.getCardType() == toPlay.getCardType()) {

                return true;
            }
        }

        return toPlay.getCardColour() == Card.Colour.BLACK;
    }

    /*    public Card Types(){
        return Card.Type.ZERO || Card.Type.ONE || Card.Type.TWO || Card.Type.THREE || Card.Type.FOUR || Card.Type.FIVE || Card.Type.SIX || Card.Type.SEVEN || Card.Type.EIGHT || Card.Type.NINE;
    } */
}