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
			((Image) new ImageIcon("Whono/Assets/b00g.png").getImage())
			);
	}

	@Override
	protected void onPress()
	{
		System.out.printf("pressed \n");
	}

	@Override
	protected void onRelease()
	{
		System.out.printf("released \n");
	}
}
