package Client.Game.Objects.MainMenu;

import Client.Game.ClientGame;
import Client.Game.Objects.GameScreen.GameScreenInit;
import Client.Game.Objects.SquareButton;
import Util.CONSTANTS;

import javax.swing.*;

public class PlayButton extends SquareButton
{
	PlayButton()
	{
		super(0,
			ClientGame.getWindowWidth()/2 - CONSTANTS.CARD_WIDTH/2 - CONSTANTS.CARD_WIDTH_PADDING,
			ClientGame.getWindowHeight() * 0.8f - CONSTANTS.CARD_HEIGHT_PADDING,
			CONSTANTS.CARD_WIDTH,
			CONSTANTS.CARD_HEIGHT,
				"Whono/Assets/Cards/Green/GreenReverse.png"
		);
	}

	@Override
	protected void onMousePress()
	{
		// change context to GameScreen
	}

	@Override
	protected void onMouseRelease()
	{
		GameScreenInit gs = new GameScreenInit();
		ClientGame.addLogicTarget(gs);
	}
}
