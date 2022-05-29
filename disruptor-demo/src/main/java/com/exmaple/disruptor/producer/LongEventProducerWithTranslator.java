package com.exmaple.disruptor.producer;

import com.exmaple.disruptor.model.LongEvent;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author DechuYe
 */
public class LongEventProducerWithTranslator {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    // 显示声明参数类型（可阅读性）
    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR =
            (LongEvent event, long sequence, ByteBuffer bb) -> event.set(bb.getLong(0));

    public void onData(ByteBuffer bb) {
        ringBuffer.publishEvent(TRANSLATOR, bb);
    }
}
