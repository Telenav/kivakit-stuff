/*
 * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * //
 * // © 2011-2021 Telenav, Inc.
 * //
 * // Licensed under the Apache License, Version 2.0 (the "License");
 * // you may not use this file except in compliance with the License.
 * // You may obtain a copy of the License at
 * //
 * // https://www.apache.org/licenses/LICENSE-2.0
 * //
 * // Unless required by applicable law or agreed to in writing, software
 * // distributed under the License is distributed on an "AS IS" BASIS,
 * // WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * // See the License for the specific language governing permissions and
 * // limitations under the License.
 * //
 * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 *
 */

package com.telenav.kivakit.ui.desktop.graphics.drawing.geometry.measurements;

import com.telenav.kivakit.core.value.level.Percent;
import com.telenav.kivakit.ui.desktop.graphics.drawing.Coordinated;
import com.telenav.kivakit.ui.desktop.graphics.drawing.geometry.objects.DrawingPoint;

import static com.telenav.kivakit.ui.desktop.graphics.drawing.geometry.DrawingCoordinateSystem.PIXELS;

/**
 * @author jonathanl (shibo)
 */
public class DrawingHeight extends DrawingLength
{
    public static DrawingHeight height(Coordinated coordinates, double units)
    {
        return new DrawingHeight(coordinates, units);
    }

    public static DrawingHeight pixels(double units)
    {
        return height(PIXELS, units);
    }

    protected DrawingHeight(Coordinated coordinates, double units)
    {
        super(coordinates, units);
    }

    public DrawingPoint asPoint()
    {
        return point(0, units());
    }

    @Override
    public DrawingHeight rounded()
    {
        return height(Math.round(units()));
    }

    @Override
    public DrawingHeight scaledBy(Percent percent)
    {
        return (DrawingHeight) super.scaledBy(percent);
    }

    @Override
    public DrawingHeight scaledBy(double scaleFactor)
    {
        return (DrawingHeight) super.scaledBy(scaleFactor);
    }

    @Override
    public DrawingHeight toCoordinates(Coordinated that)
    {
        return coordinates().toCoordinates(that, this);
    }

    @Override
    public String toString()
    {
        return super.toString() + " tall";
    }

    @Override
    protected DrawingHeight newInstance(double units)
    {
        return height(units);
    }
}
