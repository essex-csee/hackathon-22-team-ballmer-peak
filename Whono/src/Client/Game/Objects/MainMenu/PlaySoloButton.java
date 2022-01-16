package Client.Game.Objects.MainMenu;

import Client.Game.ClientGame;
import Client.Game.Objects.GameScreen.GameScreenInit;
import Client.Game.Objects.SquareButton;
import Util.CONSTANTS;

import java.awt.*;

public class PlaySoloButton extends SquareButton
{
	public PlaySoloButton()
	{
		super(0,
			ClientGame.getWindowWidth()/2 - CONSTANTS.CARD_WIDTH/2 - CONSTANTS.CARD_WIDTH_PADDING,
			ClientGame.getWindowHeight() * 0.5f - CONSTANTS.CARD_HEIGHT_PADDING,
			CONSTANTS.CARD_WIDTH/2,
			CONSTANTS.CARD_HEIGHT/2,
				"Whono/Assets/Cards/Green/GreenReverse.png"
		);
	}

	@Override
	public void draw(Graphics2D g)
	{
		if (
				mSpriteList != null       // don't try if we aren't using sprites
						&& !mSpriteList.isEmpty() // need an actual image to draw
		)
		{
			g.drawImage(mSpriteList.get(mImageIndex),
					(int) mX,
					(int) mY,
					mWidth,
					mHeight,
					mImageObserver
			);
			g.setRenderingHint(
					RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			Font font = new Font("Serif", Font.PLAIN, 32);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Play Solo", mX-10, mY+mHeight+30);
		}
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
		gs.setSolo(true);
		ClientGame.addLogicTarget(gs);
	}
}
