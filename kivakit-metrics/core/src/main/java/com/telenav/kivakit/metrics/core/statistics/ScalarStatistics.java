package com.telenav.kivakit.metrics.core.statistics;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.core.value.scalar.Scalar;
import com.telenav.kivakit.metrics.core.Metric.MetricType;

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
public class ScalarStatistics extends BaseStatistics<Scalar>
{
    public ScalarStatistics()
    {
        super(Scalar::scalar);
    }

    @Override
    public ScalarStatistics description(String description)
    {
        return (ScalarStatistics) super.description(description);
    }

    @Override
    public ScalarStatistics name(String name)
    {
        return (ScalarStatistics) super.name(name);
    }

    @Override
    public ScalarStatistics type(MetricType type)
    {
        return (ScalarStatistics) super.type(type);
    }

    @Override
    public ScalarStatistics unit(String unit)
    {
        return (ScalarStatistics) super.unit(unit);
    }
}
