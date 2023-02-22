package com.telenav.kivakit.metrics.core;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.TESTING_NOT_NEEDED;

/**
 * Reports a series of measurements via {@link #reportMetric(Metric)}
 *
 * @author jonathanl (shibo)
 */
@SuppressWarnings("unused")
@TypeQuality(stability = STABLE,
             testing = TESTING_NOT_NEEDED,
             documentation = DOCUMENTED)
public interface MetricsReporter
{
    /**
     * Reports the given metric
     *
     * @param metric The measurement to report
     */
    void reportMetric(Metric<?> metric);
}
