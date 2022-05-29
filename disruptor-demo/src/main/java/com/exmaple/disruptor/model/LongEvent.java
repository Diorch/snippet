package com.exmaple.disruptor.model;

import lombok.ToString;

/**
 * @author DechuYe
 */
@ToString
public class LongEvent {
    private long value;

    public void set(long value)
    {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
