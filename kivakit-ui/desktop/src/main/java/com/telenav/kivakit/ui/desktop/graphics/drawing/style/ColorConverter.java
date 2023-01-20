package com.telenav.kivakit.ui.desktop.graphics.drawing.style;

import com.telenav.kivakit.conversion.BaseStringConverter;
import com.telenav.kivakit.core.messaging.Listener;
import com.telenav.kivakit.core.string.Align;

public class ColorConverter extends BaseStringConverter<Color>
{
    public ColorConverter(Listener listener)
    {
        super(listener, Color.class);
    }

    @Override
    protected String onToString(Color value)
    {
        return Align.rightAlign(Integer.toHexString(value.rgba()), 8, '0');
    }

    @Override
    protected Color onToValue(String value)
    {
        if (value.length() == 8)
        {
            var alpha = Integer.parseInt(value.substring(0, 2), 16);
            var red = Integer.parseInt(value.substring(2, 4), 16);
            var green = Integer.parseInt(value.substring(4, 6), 16);
            var blue = Integer.parseInt(value.substring(6, 8), 16);
            return Color.rgba(red, green, blue, alpha);
        }
        return null;
    }
}
