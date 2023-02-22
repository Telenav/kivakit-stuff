package com.telenav.kivakit.metrics.core.statistics;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.core.time.Rate;
import com.telenav.kivakit.metrics.core.Metric.MetricType;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE_EXTENSIBLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.UNTESTED;

/**
 * A metric which tracks an average rate
 *
 * @author jonathanl (shibo)
 */
@TypeQuality(stability = STABLE_EXTENSIBLE,
             testing = UNTESTED,
             documentation = DOCUMENTED)
public class RateStatistics extends BaseStatistics<Rate>
{
    public RateStatistics()
    {
        super(Rate::perSecond);
    }

    @Override
    public RateStatistics description(String description)
    {
        return (RateStatistics) super.description(description);
    }

    @Override
    public RateStatistics name(String name)
    {
        return (RateStatistics) super.name(name);
    }

    @Override
    public RateStatistics type(MetricType type)
    {
        return (RateStatistics) super.type(type);
    }

    @Override
    public RateStatistics unit(String unit)
    {
        return (RateStatistics) super.unit(unit);
    }
}
