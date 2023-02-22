package com.telenav.kivakit.metrics.core.metrics;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.interfaces.function.Mapper;
import com.telenav.kivakit.metrics.core.Metric;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE_EXTENSIBLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.UNTESTED;

/**
 * A double-valued metric
 *
 * @author jonathanl (shibo)
 */
@TypeQuality(stability = STABLE_EXTENSIBLE,
             testing = UNTESTED,
             documentation = DOCUMENTED)
@SuppressWarnings("unused")
public class ScalarMetric extends BaseMetric<Double>
{
    private double value;

    public ScalarMetric()
    {
        this(0.0);
    }

    public ScalarMetric(double value)
    {
        this.value = value;
    }

    public ScalarMetric(BaseMetric<Double> that)
    {
        super(that);
        value = that.doubleValue();
    }

    @Override
    public ScalarMetric description(String description)
    {
        return (ScalarMetric) super.description(description);
    }

    @Override
    public double doubleValue()
    {
        return value;
    }

    public <T> Metric<T> mapped(Mapper<Double, T> mapper)
    {
        return new BaseMetric<>()
        {
            @Override
            public double doubleValue()
            {
                return value;
            }

            @Override
            public T measurement()
            {
                return mapper.map(value);
            }
        };
    }

    @Override
    public Double measurement()
    {
        return value;
    }

    @Override
    public ScalarMetric name(String name)
    {
        return (ScalarMetric) super.name(name);
    }

    @Override
    public ScalarMetric type(MetricType type)
    {
        return (ScalarMetric) super.type(type);
    }

    @Override
    public ScalarMetric unit(String unit)
    {
        return (ScalarMetric) super.unit(unit);
    }

    public ScalarMetric withMeasurement(double quantum)
    {
        var copy = new ScalarMetric(this);
        copy.value = quantum;
        return copy;
    }
}
