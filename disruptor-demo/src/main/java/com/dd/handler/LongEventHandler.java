package com.dd.handler;

import com.dd.model.LongEvent;
import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author DechuYe
 */
@Slf4j
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        event.set(-1L);
        log.info("Event: " + event);
    }
}
