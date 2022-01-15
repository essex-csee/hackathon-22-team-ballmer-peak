package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.Card;
import Client.Game.Objects.Display.CardDisplay;
import Client.Game.Objects.Hand;
import Client.Game.Objects.SquareButton;
import Util.CONSTANTS;

public class CardButton extends SquareButton
{
    float scale = 1;

    CardButton()
    {
        super(0,
                ClientGame.getWindowWidth()/2 - CONSTANTS.CARD_WIDTH/2 - CONSTANTS.CARD_WIDTH_PADDING,
                ClientGame.getWindowHeight() * 0.6f - CONSTANTS.CARD_HEIGHT_PADDING,
                CONSTANTS.CARD_WIDTH,
                CONSTANTS.CARD_HEIGHT,
                "Whono/Assets/Cards/Green/GreenReverse.png"
        );
    }

    CardButton(int index, int handSize, Card c)
    {
        super(0,
                // TODO: Check CARD_WIDTH_PADDING, offset seems slightly strange
                (index-1) * cardWidth(handSize),
                ClientGame.getWindowHeight() - cardHeight(handSize),
                //(handSize-1) * cardHeight(handSize),
                //ClientGame.getWindowWidth()/2 - (CONSTANTS.CARD_WIDTH/2 * handSize) +( index * CONSTANTS.CARD_WIDTH) - CONSTANTS.CARD_WIDTH_PADDING,
                //ClientGame.getWindowHeight() * 1f - CONSTANTS.CARD_HEIGHT_PADDING,
                cardWidth(handSize),
                cardHeight(handSize),
                // Once state is implemented, this should work fine
                //CardDisplay.getCardImage(c);
                "Whono/Assets/Cards/Green/GreenReverse.png"
        );
    }

    public static int cardWidth(int handSize)
    {
        if(handSize < 7)
        {
            return CONSTANTS.CARD_WIDTH;
        }
        return (ClientGame.getWindowWidth() / handSize);
    }

    public static int cardHeight(int handSize)
    {
        if(handSize < 7)
        {
            return CONSTANTS.CARD_HEIGHT;
        }
        return ((CONSTANTS.CARD_HEIGHT / CONSTANTS.CARD_WIDTH) * cardWidth(handSize));
    }


    CardButton(int id)
    {
        super(id,
                ClientGame.getWindowWidth() * (id == 2 ? 0.5f : 0.8f) - CONSTANTS.CARD_WIDTH/2 - CONSTANTS.CARD_WIDTH_PADDING,
                ClientGame.getWindowHeight() * 0.5f - CONSTANTS.CARD_HEIGHT_PADDING,
                CONSTANTS.CARD_WIDTH,
                CONSTANTS.CARD_HEIGHT,
                // This needs to have a method to get the top card of the Pile
                (id == 2 ? "Whono/Assets/Cards/Green/GreenReverse.png" : "Whono/Assets/Cards/Back.png")
        );
        // Type 0: Deck
        // Type 1: Pile
    }
    @Override
    protected void onMousePress()
    {
        // click on card action
    }

    @Override
    protected void onMouseRelease()
    {

    }
}
