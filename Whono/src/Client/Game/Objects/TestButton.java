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
				360,
				"Whono/Assets/test.png"
		);
	}
	//new ImageIcon("Whono/Assets/test.png").getImage()

	@Override
	protected void onMousePress()
	{
		System.out.println("Pressed");
	}

	@Override
	protected void onMouseRelease()
	{
		System.out.println("Released");
	}

	@Override
	public String toString()
	{
		return "Client.Game.Objects.TestButton[x:'" + mX + "', y:'" + mX + "']";
	}

}