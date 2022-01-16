package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.ImageManager;
import Client.Game.Objects.SquareButton;
import Util.CONSTANTS;

public class DeckButton extends SquareButton
{
	public DeckButton(long ID)
	{
		super(ID,
			ClientGame.getWindowWidth()  / 2f - CONSTANTS.CARD_HEIGHT_PADDING,
			ClientGame.getWindowHeight() / 2f - CONSTANTS.CARD_HEIGHT_PADDING,
			CONSTANTS.CARD_WIDTH,
			CONSTANTS.CARD_HEIGHT,
			ImageManager.loadImage("Whono/Assets/whonoBack.png")
		);
	}

	@Override
	protected void onMousePress()
	{

	}

	@Override
	protected void onMouseRelease()
	{
		notifySubscribers();
	}
}
