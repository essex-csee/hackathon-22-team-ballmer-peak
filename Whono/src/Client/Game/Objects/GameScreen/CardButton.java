package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.Card;
import Client.Game.Objects.Hand;
import Client.Game.Objects.SquareButton;
import Util.CONSTANTS;

public class CardButton extends SquareButton
{
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
                ClientGame.getWindowWidth()/2 - (CONSTANTS.CARD_WIDTH/2 * handSize) +( index * CONSTANTS.CARD_WIDTH) - CONSTANTS.CARD_WIDTH_PADDING,
                ClientGame.getWindowHeight() * 1f - CONSTANTS.CARD_HEIGHT_PADDING,
                CONSTANTS.CARD_WIDTH,
                CONSTANTS.CARD_HEIGHT,
                //c.getAsset();
                "Whono/Assets/Cards/Green/GreenReverse.png"
        );
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
