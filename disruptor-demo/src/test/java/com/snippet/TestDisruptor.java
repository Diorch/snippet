package com.snippet;

import org.junit.Test;

/**
 * @author DechuYe
 */
public class TestDisruptor {


    @Test
    public void t1() {
//        RingBuffer<LongEvent> ringBuffer =
//                new RingBuffer<LongEvent>(LongEvent.EVENT_FACTORY,
//                        new SingleThreadedClaimStrategy(RING_SIZE),
//                        new SleepingWaitStrategy());
//
//        SequenceBarrier<> barrier = ringBuffer.newBarrier();
//        BatchEventProcessor<LongEvent> eventProcessor = new BatchEventProcessor<LongEvent>(barrier, new LongEventHandler());
//        ringBuffer.setGatingSequences(eventProcessor.getSequence());
//
//// Each EventProcessor can run on a separate thread
//        EXECUTOR.submit(eventProcessor);
    }

}
