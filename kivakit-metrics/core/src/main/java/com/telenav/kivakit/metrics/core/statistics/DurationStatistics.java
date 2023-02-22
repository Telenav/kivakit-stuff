package com.telenav.kivakit.metrics.core.statistics;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.core.time.Duration;
import com.telenav.kivakit.metrics.core.Metric;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE_EXTENSIBLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.UNTESTED;

/**
 * A metric which tracks an average duration
 *
 * @author jonathanl (shibo)
 */
@TypeQuality(stability = STABLE_EXTENSIBLE,
             testing = UNTESTED,
             documentation = DOCUMENTED)
public class DurationStatistics extends BaseStatistics<Duration>
{
    public DurationStatistics()
    {
        super(Duration::seconds);
    }

    @Override
    public DurationStatistics description(String description)
    {
        return (DurationStatistics) super.description(description);
    }

    @Override
    public DurationStatistics name(String name)
    {
        return (DurationStatistics) super.name(name);
    }

    @Override
    public DurationStatistics type(Metric.MetricType type)
    {
        return (DurationStatistics) super.type(type);
    }

    @Override
    public DurationStatistics unit(String unit)
    {
        return (DurationStatistics) super.unit(unit);
    }
}
