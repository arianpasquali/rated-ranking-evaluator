package io.sease.rre.core.domain.metrics.impl;

import io.sease.rre.core.domain.metrics.CompoundMetric;
import io.sease.rre.core.domain.metrics.Metric;

import java.math.BigDecimal;

import static io.sease.rre.Calculator.divide;

public class GMAP extends CompoundMetric {
    /**
     * Builds a new {@link GMAP} metric.
     */
    public GMAP() {
        super(metric -> AveragePrecision.NAME.equals(metric.getName()), "GMAP");
    }

    @Override
    public BigDecimal value() {
        if (metrics.size() == 0) return BigDecimal.ZERO;
        return BigDecimal.valueOf(
                Math.pow(
                    metrics.stream().map(Metric::value).reduce(BigDecimal.ONE, BigDecimal::multiply).doubleValue(),
                    1.0 / metrics.size()));
    }
}