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

    @Override
    protected void onMousePress()
    {
        // check ID for button pressed
        // if < 4
        //      specific function i.e. pause/exit/deck/pile
    }

    @Override
    protected void onMouseRelease()
    {

    }
}
