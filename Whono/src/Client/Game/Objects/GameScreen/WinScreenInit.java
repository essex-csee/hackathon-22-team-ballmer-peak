package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.ImageManager;
import Client.Game.Objects.InitObject;
import Client.Game.Objects.MainMenu.ExitButton;
import Client.Game.Objects.MainMenu.PlayButton;
import Client.Game.Objects.StaticImageObject;
import Client.Game.Players.PlayerController;

import javax.swing.*;
import java.awt.*;

public class WinScreenInit extends InitObject
{
    public WinScreenInit()
    {
        super();
    }

    @Override
    protected void setup()
    {
        PlayerController player = new PlayerController();
        int winTurn = player.getTurn();
        JPanel panel = new JPanel();
        JLabel winText = new JLabel("You Won on turn: " + winTurn);

        // title
        StaticImageObject background = new StaticImageObject(
                1,
                0,
                0,
                ClientGame.getWindowWidth(),
                ClientGame.getWindowHeight(),
                ImageManager.loadImage("Whono/Assets/BackgroundTile.png"));
        //Leaderboard
        panel.setBounds(40, 80, ClientGame.getWindowWidth(), ClientGame.getWindowHeight());
        panel.setBackground(Color.BLACK);


        panel.add(winText);
        winText.setForeground(Color.WHITE);
        winText.setFont(new Font("TimesRoman", Font.PLAIN, 32));


    }


}