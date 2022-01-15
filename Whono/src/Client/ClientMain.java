package Client;

import Client.Game.ClientGame;
import Client.Game.Objects.ImageManager;
import Client.Game.Objects.MainMenu.MainMenuInit;
import Client.Game.Objects.StaticImageObject;
import Client.Game.Objects.TestButton;

import javax.swing.*;
import java.awt.*;

public class ClientMain
{
	public ClientMain()
	{
		try
		{
			ClientGame cg = ClientGame.get();

			Thread cgThread = new Thread( cg );
			cgThread.setPriority(Thread.MAX_PRIORITY);
			cgThread.start();


			ImageManager imageManager = new ImageManager();

			MainMenuInit tb = new MainMenuInit();

			ClientGame.addLogicTarget(tb);

			ClientGame.addRenderTarget(tb);

			System.out.println(tb);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
