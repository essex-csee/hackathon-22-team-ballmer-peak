package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.SquareButton;
import Util.CONSTANTS;

public class PauseButton extends SquareButton
{


	public PauseButton()
	{
		// Change position of exit button
		super(1,
			ClientGame.getWindowWidth() * 0.7f - CONSTANTS.CARD_WIDTH/2 + CONSTANTS.CARD_WIDTH_PADDING,
			ClientGame.getWindowHeight() * 0.45f - CONSTANTS.CARD_HEIGHT_PADDING,
			CONSTANTS.CARD_WIDTH/2,
			CONSTANTS.CARD_HEIGHT/2,
			"Whono/Assets/Cards/Red/Red1.png"
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
