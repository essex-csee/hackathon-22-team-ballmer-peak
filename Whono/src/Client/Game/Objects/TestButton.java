package Client.Game.Objects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TestButton extends SquareButton
{
	public TestButton()
	{
		super(0,
			0,
			0,
			640,
			480,
			new ImageIcon("Whono/Assets/b00g.png").getImage()
			);
	}

	@Override
	protected void onPress()
	{
		System.out.println("Pressed");
	}

	@Override
	protected void onRelease()
	{
		System.out.println("Released");
	}

	@Override
	public String toString()
	{
		return "Client.Game.Objects.TestButton[x:'" + mX + "', y:'" + mX + "','" + this.mSpriteList.toString() + "']";
	}

}
