package com.telenav.kivakit.ui.desktop.component.fader;

import com.telenav.kivakit.core.time.Duration;
import com.telenav.kivakit.ui.desktop.component.Components;
import com.telenav.kivakit.ui.desktop.graphics.drawing.style.Color;

import javax.swing.JLabel;

/**
 * @author jonathanl (shibo)
 */
public class Fader extends JLabel
{
    private final Color color;

    private final Duration every;

    private final int alphaStep;

    /**
     * @param initialAlpha Initial alpha level from 0 to 255
     * @param alphaStep Amount of alpha change at each step
     * @param every Time between alpha changes
     */
    public Fader(Color color, int initialAlpha, int alphaStep, Duration every)
    {
        this.color = color;
        this.every = every;
        this.alphaStep = alphaStep;

        setOpaque(true);
        setVisible(true);

        color.withAlpha(initialAlpha).applyAsBackground(this);
    }

    public void fadeIn()
    {
        Components.fadeIn(this, color, every, alphaStep);
    }

    public void fadeOut()
    {

        Components.fadeOut(this, color, every, alphaStep);
    }
}
