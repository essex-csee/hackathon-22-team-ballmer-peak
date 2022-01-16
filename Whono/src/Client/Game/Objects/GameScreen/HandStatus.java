package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.Hand;
import Client.Game.Objects.ImageManager;
import Client.Game.Objects.SquareButton;
import Client.Game.Objects.StaticImageObject;
import java.util.List;
import Util.CONSTANTS;

import java.awt.*;
import java.util.ArrayList;

public class HandStatus extends StaticImageObject
{
	int handSize;

	public HandStatus(long ID, float x, float y)
	{
		super(
				ID,
				x,
				y,
			CONSTANTS.CARD_WIDTH/4,
			CONSTANTS.CARD_HEIGHT/4,
			ImageManager.loadImage("Whono/Assets/whonoBack.png")
		);
	}

	public void setHandSize(int size)
	{
		handSize = size;
	}


	public void update(Hand h)
	{
		handSize = h.getHandSize();
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

			Font font = new Font("Serif", Font.PLAIN, 24);
			g.setFont(font);
			g.setColor(Color.WHITE);
			String cardsInHand = "Cards: " + handSize;
			g.drawString(cardsInHand, mX+mWidth+20, mY+mHeight/2+10);
		}
	}
}
