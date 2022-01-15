package Client.Game.Objects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageManager
{
    private class ImageMeta
    {
        String name;
        int usedCount;
        Image image;
        String imagePath;

        ImageMeta()
        {
        }

    }

    List<ImageMeta> imageMetaList;

    String currentDirectory;
    ArrayList<Image> imageList;
    List<String> imageListNames;


    public ImageManager()
    {
        currentDirectory = System.getProperty("user.dir");
        imageList = new ArrayList<>();
        imageListNames = new ArrayList<String>();

        imageMetaList = new ArrayList<>();
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
        ImageMeta meta = new ImageMeta();
        Image out = null;
        String imagePath = currentDirectory + imageName;

        // Check if image already loaded
        for(int i = 0; i < imageMetaList.size(); i++)
        {
            if (imageMetaList.get(i).name.equals(imageName))
            {
                imageMetaList.get(i).usedCount++;
                return imageMetaList.get(i).image;
            }
            else // Load image
            {
                meta.usedCount = 1;
                meta.name = imageName;
                meta.imagePath = imagePath;
                meta.image = ((Image) new ImageIcon(meta.imagePath).getImage());
                imageMetaList.add(meta);
                return meta.image;
            }
        }
        return null;
    }

    public Image removeImage(Image delete)
    {
        Image out = null;
        // Check if image already loaded
        for(int i = 0; i < imageMetaList.size(); i++)
        {
            if (delete == imageMetaList.get(i).image)
            {
                out = imageMetaList.get(i).image;
                // If only one image is used, remove it
                if (imageMetaList.get(i).usedCount < 1)
                {
                    imageMetaList.remove(i);
                    break;
                }
                // If more than one image is used, decrement usedCount
                else
                {
                    imageMetaList.get(i).usedCount--;
                }
            }
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