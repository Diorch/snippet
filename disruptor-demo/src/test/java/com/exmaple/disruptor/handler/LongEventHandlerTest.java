package com.exmaple.disruptor.handler;

import com.exmaple.disruptor.model.LongEvent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author dechuye
 */
public class LongEventHandlerTest {
    @Mock
    Logger log;
    @InjectMocks
    LongEventHandler longEventHandler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testOnEvent() throws Exception {

        // final ArgumentCaptor<LongEvent> longEventArgumentCaptor = ArgumentCaptor.forClass(LongEvent.class);

        // final LongEventHandler mock = mock(LongEventHandler.class);
        // doThrow(RuntimeException.class).when(mock).onEvent(longEventArgumentCaptor.capture(), anyLong(), anyBoolean());
        // mock.onEvent(longEventArgumentCaptor.capture(), anyLong(), anyBoolean());
        // assertEquals(-1L, longEventArgumentCaptor.getValue().getValue());
        // System.out.println(longEventArgumentCaptor.getValue().getValue());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme