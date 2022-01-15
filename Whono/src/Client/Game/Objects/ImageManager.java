package Client.Game.Objects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ImageManager
{
    String currentDirectory;
    ArrayList<Image> imageList;
    List<String> imageListNames;

    public ImageManager()
    {
        currentDirectory = System.getProperty("user.dir");
        imageList = new ArrayList<>();
        imageListNames = new ArrayList<String>();
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public List<String> getImageListNames() {
        return imageListNames;
    }

    public ArrayList<Image> getImageList() {
        return imageList;
    }

    public Image loadImage(String imageName)
    {
        String imagePath = currentDirectory + imageName;
        Image out = null;

        int i = imageListNames.indexOf(imageName);

        if( i != -1 )
        {
            out = ((Image) new ImageIcon(imagePath).getImage());
            imageListNames.add(imageName);
            imageList.add(out);
        }
        else
        {
            out = imageList.get(i);
        }

        return out;
    }

    public Image removeImage(String imageName)
    {
        String imagePath = currentDirectory + imageName;
        Image out = null;

        int i = imageListNames.indexOf(imageName);

        if( i != -1 )
        {
            out = imageList.get(i);
            imageList.remove(i);
            imageListNames.remove(i);
        }

        return out;

    }

    public void clear()
    {
        currentDirectory = "";
        imageList.clear();
        imageListNames.clear();
    }


}
