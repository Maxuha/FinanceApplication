package com.coffesoft.financeapplication.util;

import org.springframework.stereotype.Component;

@Component
public class CalculatePercentImpl implements CalculatePercent {
    private final Integer MAX_PERCENT = 100;

    @Override
    public Integer getValueForPercent(Integer percent, Integer value) {
        return (value * percent) / MAX_PERCENT;
    }
}
