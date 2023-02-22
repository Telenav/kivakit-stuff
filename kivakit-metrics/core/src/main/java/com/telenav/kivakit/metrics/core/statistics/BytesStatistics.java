package com.telenav.kivakit.metrics.core.statistics;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.core.value.count.Bytes;
import com.telenav.kivakit.metrics.core.Metric;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE_EXTENSIBLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.UNTESTED;

/**
 * A metric which tracks the average number of bytes
 *
 * @author jonathanl (shibo)
 */
@TypeQuality(stability = STABLE_EXTENSIBLE,
             testing = UNTESTED,
             documentation = DOCUMENTED)
public class BytesStatistics extends BaseStatistics<Bytes>
{
    public BytesStatistics()
    {
        super(Bytes::bytes);
    }

    @Override
    public BytesStatistics description(String description)
    {
        return (BytesStatistics) super.description(description);
    }

    @Override
    public BytesStatistics name(String name)
    {
        return (BytesStatistics) super.name(name);
    }

    @Override
    public BytesStatistics type(Metric.MetricType type)
    {
        return (BytesStatistics) super.type(type);
    }

    @Override
    public BytesStatistics unit(String unit)
    {
        return (BytesStatistics) super.unit(unit);
    }
}
