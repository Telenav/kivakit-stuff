package com.telenav.kivakit.metrics.core.statistics;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.core.value.count.Count;
import com.telenav.kivakit.metrics.core.Metric;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE_EXTENSIBLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.UNTESTED;

/**
 * A metric which tracks an average count
 *
 * @author jonathanl (shibo)
 */
@TypeQuality(stability = STABLE_EXTENSIBLE,
             testing = UNTESTED,
             documentation = DOCUMENTED)
public class CountStatistics extends BaseStatistics<Count>
{
    public CountStatistics()
    {
        super(Count::count);
    }

    @Override
    public CountStatistics description(String description)
    {
        return (CountStatistics) super.description(description);
    }

    @Override
    public CountStatistics name(String name)
    {
        return (CountStatistics) super.name(name);
    }

    @Override
    public CountStatistics type(Metric.MetricType type)
    {
        return (CountStatistics) super.type(type);
    }

    @Override
    public CountStatistics unit(String unit)
    {
        return (CountStatistics) super.unit(unit);
    }
}
