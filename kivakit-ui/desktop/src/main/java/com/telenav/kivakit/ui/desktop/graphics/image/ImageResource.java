package com.telenav.kivakit.ui.desktop.graphics.image;

import com.telenav.kivakit.core.messaging.Listener;
import com.telenav.kivakit.resource.resources.PackageResource;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;

/**
 * @author jonathanl (shibo)
 */
public class ImageResource
{
    public static ImageResource of(PackageResource resource)
    {
        return new ImageResource(resource);
    }

    public static ImageResource of(Listener listener, Class<?> type, String path)
    {
        return of(PackageResource.packageResource(listener, type, path));
    }

    private final PackageResource resource;

    public ImageResource(PackageResource resource)
    {
        this.resource = resource;
    }

    public Image image()
    {
        try (var input = resource.openForReading())
        {
            return ImageIO.read(input);
        }
        catch (IOException ignored)
        {
            return null;
        }
    }

    public Image image(int width, int height)
    {
        return image().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
