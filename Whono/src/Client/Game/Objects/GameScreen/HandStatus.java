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
	public HandStatus(long ID, float x, float y, Hand h)
	{
		super(
				ID,
				x,
				y,
			CONSTANTS.CARD_WIDTH/4,
			CONSTANTS.CARD_HEIGHT/4,
			ImageManager.loadImage("Whono/Assets/whonoBack.png")
		);

		this.mHand = h;
		this.active = false;
		this.dead =  false;
	}

	@Override
	public void update(long deltaTime)
	{

	}

	public void active(boolean active)
	{
		this.active = active;
	}

	public void dead(boolean dead)
	{
		this.dead = dead;
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

			if(active)
			{
				g.setColor(Color.RED);
			}
			else
			{
				g.setColor(Color.WHITE);
			}

			if(dead)
			{
				g.setColor(Color.DARK_GRAY);
			}

			Font font = new Font("Serif", Font.PLAIN, 24);
			g.setFont(font);
			String cardsInHand = "Cards: " + (mHand.getHandSize()-1);
			g.drawString(cardsInHand, mX+mWidth+20, mY+mHeight/2+10);
		}
	}

	protected Hand mHand;
	protected boolean active;
	protected boolean dead;
}
