package Client.Game.Objects.GameScreenSolo;

import Client.Game.ClientGame;
import Client.Game.Objects.GameScreen.ExitButton;
import Client.Game.Objects.GameScreen.HighScoreDisplay;
import Client.Game.Objects.ImageManager;
import Client.Game.Objects.InitObject;
import Client.Game.Objects.MainMenu.PlayButton;
import Client.Game.Objects.StaticImageObject;

public class WinScreenInitSolo extends InitObject
{
    private boolean win;
    public WinScreenInitSolo()
    {
    }

    @Override
    protected void setup()
    {
        //PlayerController player = new PlayerController();
        //int winTurn = player.getTurn();
        //JPanel panel = new JPanel();
        //JLabel winText = new JLabel("You Won on turn: " + winTurn);


        int titleWidth  = (int) (362f * 1.4f);
        int titleHeight = (int) (242f * 1.4f);
        // title
        StaticImageObject background = new StaticImageObject(
                1,
                0,
                0,
                ClientGame.getWindowWidth(),
                ClientGame.getWindowHeight(),
                ImageManager.loadImage("Whono/Assets/BackgroundTile.png"));

        StaticImageObject logo = new StaticImageObject(
                0,
                ClientGame.getWindowWidth()/2 - titleWidth/2,
                0,
                titleWidth,
                titleHeight,
                ImageManager.loadImage("Whono/Assets/whonoTilt.png")
        );


        addGameObject(background);
        addGameObject(logo);
        addGameObject(new ExitButton());
        addGameObject(new PlayButton());
        HighScoreDisplay hs = new HighScoreDisplay();
        hs.setCon(true);
        addGameObject(hs);
        //Leaderboard
        //panel.setBounds(40, 80, ClientGame.getWindowWidth(), ClientGame.getWindowHeight());
        //panel.setBackground(Color.BLACK);


        //panel.add(winText);
        //winText.setForeground(Color.WHITE);
        //winText.setFont(new Font("TimesRoman", Font.PLAIN, 32));


    }


}