package com.telenav.kivakit.primitive.collections;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.interfaces.numeric.Zeroable;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.TESTING_NOT_NEEDED;

/***
 * A quantizable object that can be turned into a <i>double</i> value.
 *
 * @author jonathanl (shibo)
 */
@TypeQuality(stability = STABLE,
             testing = TESTING_NOT_NEEDED,
             documentation = DOCUMENTED)
public interface DoubleQuantizable extends Zeroable
{
    @Override
    default boolean isZero()
    {
        return quantumDouble() == 0.0;
    }

    /**
     * Returns the double quantum value
     */
    double quantumDouble();
}
