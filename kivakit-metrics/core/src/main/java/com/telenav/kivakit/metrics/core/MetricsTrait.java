package com.telenav.kivakit.metrics.core;

import com.telenav.kivakit.core.registry.RegistryTrait;

public interface MetricsTrait extends RegistryTrait
{
    default void reportMetric(Metric<?> metric)
    {
        reporter().reportMetric(metric);
    }

    default MetricsReporter reporter()
    {
        return require(MetricsReporter.class);
    }
}
