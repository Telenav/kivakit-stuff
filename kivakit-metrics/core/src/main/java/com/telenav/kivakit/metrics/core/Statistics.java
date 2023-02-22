package com.telenav.kivakit.metrics.core;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.core.time.CreatedAt;
import com.telenav.kivakit.interfaces.collection.Addable;
import com.telenav.kivakit.interfaces.naming.Named;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE_EXTENSIBLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.TESTING_NOT_NEEDED;

/**
 * An aggregate metric is a metric for a set of measurements, added with {@link Addable#add(Object)}
 *
 * @author jonathanl (shibo)
 */
@TypeQuality(stability = STABLE_EXTENSIBLE,
             testing = TESTING_NOT_NEEDED,
             documentation = DOCUMENTED)
public interface Statistics<T> extends Addable<T>,
    Named,
    CreatedAt
{
    /**
     * Returns the average for this aggregated metric
     */
    Metric<T> average();

    /**
     * Human-readable description of this metric
     */
    String description();

    /**
     * Returns the maximum sample for this aggregated metric
     */
    Metric<T> maximum();

    /**
     * Returns the minimum sample for this aggregated metric
     */
    Metric<T> minimum();

    /**
     * Returns the number of samples for this aggregated metric
     */
    Metric<T> samples();

    /**
     * Returns the total of all samples for this aggregated metric
     */
    Metric<T> total();

    /**
     * Returns the type of measurement
     */
    Metric.MetricType type();

    /**
     * Returns the metric unit
     */
    String unit();
}
