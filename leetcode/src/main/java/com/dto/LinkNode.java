package com.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author diorch
 */

@Data
@ToString
public class LinkNode {

    public Object key;
    public Object value;

    public LinkNode next;
    public LinkNode prev;

    public LinkNode(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
