package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.SquareButton;
import Util.CONSTANTS;

import java.awt.*;

public class HighScoreDisplay extends SquareButton
{
	public HighScoreDisplay()
	{
		super(0,
			ClientGame.getWindowWidth()/2,
			ClientGame.getWindowHeight() * 1.2f - CONSTANTS.CARD_HEIGHT_PADDING,
			0,
			0,
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
			// TODO:Need score value here
			int score = 255;
			g.drawString("Congratulations!", mX+mHeight-130, mY+mHeight-50);
			g.drawString("Score: " + score, mX+mHeight-75, mY+mHeight);
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
		ClientGame.addLogicTarget(gs);
	}
}
