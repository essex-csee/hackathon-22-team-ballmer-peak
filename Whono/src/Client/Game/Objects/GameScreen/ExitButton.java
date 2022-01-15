package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.SquareButton;
import Util.CONSTANTS;

public class ExitButton extends SquareButton
{


	public ExitButton()
	{
		// Change position of exit button
		super(0,
			ClientGame.getWindowWidth()/2 - CONSTANTS.CARD_WIDTH/2 + CONSTANTS.CARD_WIDTH_PADDING,
			ClientGame.getWindowHeight() * 0.6f - CONSTANTS.CARD_HEIGHT_PADDING,
			CONSTANTS.CARD_WIDTH,
			CONSTANTS.CARD_HEIGHT,
			"Whono/Assets/Cards/Red/RedSkip.png"
		);
	}

	@Override
	protected void onMousePress()
	{

	}

	@Override
	protected void onMouseRelease()
	{
		ClientGame.requestWindowClose();
	}
}
