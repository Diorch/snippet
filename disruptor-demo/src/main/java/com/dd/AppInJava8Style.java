package com.dd;

import com.dd.model.LongEvent;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * @author DechuYe
 */
@Slf4j
public class AppInJava8Style {

    public static void main(String[] args) throws InterruptedException {
        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE,
                ProducerType.SINGLE, new BusySpinWaitStrategy());

        // Connect the handler
//        disruptor.handleEventsWith((LongEvent event, long sequence, boolean endOfBatch) -> { int i = 0; })
//                .then((LongEvent event, long sequence, boolean endOfBatch) -> { int i = 0; })
//                .then((LongEvent event, long sequence, boolean endOfBatch) -> { int i = 0; });
//        ;
        disruptor.handleEventsWith((LongEvent event, long sequence, boolean endOfBatch) -> { int i = 0; });
        disruptor.handleEventsWith((LongEvent event, long sequence, boolean endOfBatch) -> { int i = 0; });

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        ByteBuffer bb = ByteBuffer.allocate(8);
        long start = System.currentTimeMillis();
        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            ringBuffer.publishEvent((LongEvent event, long sequence, ByteBuffer buffer) -> event.set(buffer.getLong(0)), bb);
//            ringBuffer.publishEvent((LongEvent event,long sequence) -> event.set(bb.getLong(0)));
//            Thread.sleep(1000);
            if (l % 1_000_000 == 0) {
                log.info("100w cost: {}", System.currentTimeMillis() - start);
                start = System.currentTimeMillis();
            }
        }
    }
}
