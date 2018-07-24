package com.test.writer.aggregator;

import com.test.content.ContentTarget;
import org.springframework.batch.item.file.transform.LineAggregator;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/24 22:00
 */
public class ContentLineAggregator implements LineAggregator<ContentTarget> {
    public String aggregate(ContentTarget contentTarget) {
        StringBuilder result = new StringBuilder();
        result
                .append(contentTarget.getId())
                .append(",")
                .append(contentTarget.getStatus());
        return result.toString();
    }
}
