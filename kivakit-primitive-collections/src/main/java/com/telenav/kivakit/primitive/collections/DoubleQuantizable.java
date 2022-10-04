package com.telenav.kivakit.primitive.collections;

import com.telenav.kivakit.annotations.code.ApiQuality;
import com.telenav.kivakit.interfaces.numeric.Zeroable;

import static com.telenav.kivakit.annotations.code.ApiStability.API_STABLE;
import static com.telenav.kivakit.annotations.code.DocumentationQuality.DOCUMENTATION_COMPLETE;
import static com.telenav.kivakit.annotations.code.TestingQuality.TESTING_NOT_NEEDED;

/***
 * A quantizable object that can be turned into a <i>double</i> value.
 *
 * @author jonathanl (shibo)
 * @see LongValued
 */
@ApiQuality(stability = API_STABLE,
            testing = TESTING_NOT_NEEDED,
            documentation = DOCUMENTATION_COMPLETE)
public interface DoubleQuantizable extends Zeroable
{
    /**
     * Returns the double quantum value
     */
    double quantumDouble();

    @Override
    default boolean isZero()
    {
        return quantumDouble() == 0.0;
    }
}
