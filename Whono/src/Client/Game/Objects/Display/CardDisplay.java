package Client.Game.Objects.Display;

import Client.Game.Objects.Card;
import Client.Game.Objects.GameObject;
import Client.Game.Objects.ImageManager;
import Util.ISubscribable;
import Util.ISubscriber;

import java.awt.*;

public class CardDisplay
{
	public static Image getCardImage(Card c)
	{
		String path = "Whono/Assets/Cards/";

		switch (c.getCardColour())
		{
			case BLACK:
				path+="Black/Black";
				break;
			case GREEN:
				path+="Green/Green";
				break;
			case PURPLE:
				path+="Purple/Purple";
				break;
			case RED:
				path+="Red/Red";
				break;
			case YELLOW:
				path+="Yellow/Yellow";
				break;
		}

		switch (c.getCardType())
		{
			case ONE     -> path+="1.png";
			case TWO     -> path+="2.png";
			case THREE   -> path+="3.png";
			case FOUR    -> path+="4.png";
			case FIVE    -> path+="5.png";
			case SIX     -> path+="6.png";
			case SEVEN   -> path+="7.png";
			case EIGHT   -> path+="8.png";
			case NINE    -> path+="9.png";
			case DRAW2   -> path+="Plus2.png";
			case REVERSE -> path+="Reverse.png";
			case SKIP    -> path+="Skip.png";
			case WILD    -> path+="Wild";
			case WILD4   -> path+="Wild4";
		}

		return ImageManager.loadImage(path);
	}
}
