package Client;

import Client.Game.ClientGame;
import Client.Game.Objects.StaticImageObject;

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

			Image img = new ImageIcon("Whono/Assets/b00g.png").getImage();

			System.out.printf("%d, %d \n", img.getWidth(null), img.getHeight(null));

			StaticImageObject staticImage = new StaticImageObject(0,0,0,640,480,img);

			ClientGame.addLogicTarget(staticImage);

			ClientGame.addRenderTarget(staticImage);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
