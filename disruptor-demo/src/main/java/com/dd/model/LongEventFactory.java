package com.dd.model;

import com.lmax.disruptor.EventFactory;

/**
 * @author DechuYe
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
