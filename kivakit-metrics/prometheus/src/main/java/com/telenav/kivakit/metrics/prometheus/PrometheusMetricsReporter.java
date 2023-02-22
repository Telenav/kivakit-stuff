package com.telenav.kivakit.metrics.prometheus;

import com.telenav.kivakit.annotations.code.quality.TypeQuality;
import com.telenav.kivakit.component.BaseComponent;
import com.telenav.kivakit.core.messaging.Listener;
import com.telenav.kivakit.metrics.core.Metric;
import com.telenav.kivakit.metrics.core.MetricsReporter;
import com.telenav.third.party.prometheus.client.Counter;
import com.telenav.third.party.prometheus.client.Gauge;
import com.telenav.third.party.prometheus.client.Histogram;
import com.telenav.third.party.prometheus.client.SimpleCollector;
import com.telenav.third.party.prometheus.client.hotspot.DefaultExports;

import java.util.HashMap;
import java.util.Map;

import static com.telenav.kivakit.annotations.code.quality.Documentation.DOCUMENTED;
import static com.telenav.kivakit.annotations.code.quality.Stability.STABLE_EXTENSIBLE;
import static com.telenav.kivakit.annotations.code.quality.Testing.UNTESTED;

/**
 * Reports metrics to Prometheus
 *
 * @author jonathanl (shibo)
 */
@TypeQuality(stability = STABLE_EXTENSIBLE,
             testing = UNTESTED,
             documentation = DOCUMENTED)
public class PrometheusMetricsReporter extends BaseComponent implements MetricsReporter
{
    /** Collectors (gauges, counters and histograms) for each metric by name */
    private final Map<String, SimpleCollector<?>> collectors = new HashMap<>();

    /**
     * @param listener The listener to report any problems to
     */
    public PrometheusMetricsReporter(Listener listener)
    {
        DefaultExports.initialize();
        listener.listenTo(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void reportMetric(Metric<?> metric)
    {
        var collector = collectors.get(metric.name());

        switch (metric.type())
        {
            case COUNTER -> count(metric, (Counter) collector);
            case GAUGE -> gauge(metric, (Gauge) collector);
            case HISTOGRAM -> histogram(metric, (Histogram) collector);
        }
    }

    private void count(Metric<?> metric, Counter counter)
    {
        if (counter == null)
        {
            counter = Counter.build()
                .name(metric.name())
                .unit(metric.unit())
                .help(metric.description())
                .register();

            collectors.put(metric.name(), counter);
        }

        counter.inc(metric.longValue());
    }

    private void histogram(Metric<?> metric, Histogram histogram)
    {
        if (histogram == null)
        {
            histogram = Histogram.build()
                .name(metric.name())
                .unit(metric.unit())
                .help(metric.description())
                .register();

            collectors.put(metric.name(), histogram);
        }

        histogram.observe(metric.doubleValue());
    }

    private void gauge(Metric<?> metric, Gauge gauge)
    {
        if (gauge == null)
        {
            gauge = Gauge.build()
                .name(metric.name())
                .unit(metric.unit())
                .help(metric.description())
                .register();

            collectors.put(metric.name(), gauge);
        }

        gauge.set(metric.longValue());
    }
}
