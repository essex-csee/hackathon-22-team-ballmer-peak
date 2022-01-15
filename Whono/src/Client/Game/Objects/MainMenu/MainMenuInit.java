package Client.Game.Objects.MainMenu;

import Client.Game.Objects.Card;
import Client.Game.Objects.Display.CardDisplay;
import Client.Game.Objects.InitObject;
import Client.Game.Objects.StaticImageObject;

public class MainMenuInit extends InitObject
{
	public MainMenuInit()
	{
		super();
	}

	@Override
	protected void setup()
	{
		addGameObject(new PlayButton());
		addGameObject(new ExitButton());

		Card c = new Card();

		c.setCardColour(Card.Colour.RED);
		c.setCardType(Card.Type.NINE);

		addGameObject( new StaticImageObject(0,64,96,64,96,CardDisplay.getCardImage(c) ) );
	}

}
