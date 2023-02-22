package com.telenav.kivakit.metrics.core.reporters;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.metrics.core.Metric;
import com.telenav.kivakit.metrics.core.MetricsReporter;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE_EXTENSIBLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.UNTESTED;

/**
 * A {@link MetricsReporter} that does nothing
 *
 * @author jonathanl (shibo)
 */
@TypeQuality(stability = STABLE_EXTENSIBLE,
             testing = UNTESTED,
             documentation = DOCUMENTED)
public class NullMetricsReporter implements MetricsReporter
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void reportMetric(Metric<?> metric)
    {
    }
}
