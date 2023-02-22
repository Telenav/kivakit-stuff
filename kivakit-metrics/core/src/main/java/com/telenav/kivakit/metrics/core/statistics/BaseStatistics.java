package com.telenav.kivakit.metrics.core.statistics;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.core.time.Time;
import com.telenav.kivakit.interfaces.function.Mapper;
import com.telenav.kivakit.interfaces.value.DoubleValued;
import com.telenav.kivakit.interfaces.value.Source;
import com.telenav.kivakit.metrics.core.Metric;
import com.telenav.kivakit.metrics.core.Statistics;
import com.telenav.kivakit.metrics.core.metrics.ScalarMetric;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE_EXTENSIBLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.UNTESTED;
import static com.telenav.kivakit.core.time.Time.now;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * An aggregate metric is an {@link Statistics} for arbitrary {@link DoubleValued#doubleValue()}d objects.
 *
 * <p><b>Aggregate Metrics</b></p>
 * <ul>
 *     <li>{@link #total()}</li>
 *     <li>{@link #minimum()}</li>
 *     <li>{@link #maximum()}</li>
 *     <li>{@link #average()}</li>
 *     <li>{@link #samples()}</li>
 * </ul>
 *
 * @author jonathanl (shibo)
 */
@SuppressWarnings("unused")
@TypeQuality(stability = STABLE_EXTENSIBLE,
             testing = UNTESTED,
             documentation = DOCUMENTED)
public abstract class BaseStatistics<T extends DoubleValued> implements Statistics<T>
{
    /** The time at which this metric was created */
    private final Time created = now();

    /** The logical name of the metric */
    private String name;

    /** A human-readable description of the metric */
    private String description;

    /** The unit of the metric */
    private String unit;

    /** The kind of metric */
    private Metric.MetricType type;

    /** The total of all added samples */
    private double total;

    /** The maximum of all added samples */
    private double maximumSample;

    /** The minimum of all added samples */
    private double minimumSample;

    /** The number of samples */
    private int samples;

    /**
     * Converts from a double value to the type of aggregated metric
     */
    private final Mapper<Double, T> mapper;

    protected BaseStatistics(Mapper<Double, T> mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public Metric<T> average()
    {
        return scalarMetric(() -> total / samples, "average");
    }

    @Override
    public Time createdAt()
    {
        return created;
    }

    @Override
    public String description()
    {
        return description;
    }

    public BaseStatistics<T> description(String description)
    {
        this.description = description;
        return this;
    }

    @Override
    public Metric<T> maximum()
    {
        return scalarMetric(() -> maximumSample, "maximum");
    }

    @Override
    public Metric<T> minimum()
    {
        return scalarMetric(() -> minimumSample, "minimum");
    }

    public BaseStatistics<T> name(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public String name()
    {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onAdd(T metric)
    {
        double value = metric.doubleValue();

        total += value;
        maximumSample = max(maximumSample, value);
        minimumSample = min(minimumSample, value);
        samples++;

        return true;
    }

    @Override
    public Metric<T> samples()
    {
        return scalarMetric(() -> (double) samples, "samples");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size()
    {
        // This Addable is not SpaceLimited
        return 0;
    }

    /**
     * Removes the given metric value from this aggregate. The maximum and minimum sample cannot be reversed since it's
     * not known what the previous maximum or minimum were without the sample to be removed.
     *
     * @param metric The metric to remove
     * @return True if it was removed
     */
    public boolean subtract(T metric)
    {
        total -= metric.doubleValue();
        samples--;
        return true;
    }

    @Override
    public Metric<T> total()
    {
        return scalarMetric(() -> total, "total");
    }

    public BaseStatistics<T> type(Metric.MetricType type)
    {
        this.type = type;
        return this;
    }

    @Override
    public Metric.MetricType type()
    {
        return type;
    }

    @Override
    public String unit()
    {
        return unit;
    }

    public BaseStatistics<T> unit(String unit)
    {
        this.unit = unit;
        return this;
    }

    private Metric<T> scalarMetric(Source<Double> source, String metricType)
    {
        return new ScalarMetric(source.get())
            .description(description)
            .name(name + " (" + metricType + ")")
            .type(type)
            .unit(unit)
            .mapped(mapper);
    }
}
