package com.test.processor;

import com.test.content.ContentSource;
import com.test.content.ContentTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/24 21:48
 */
@Slf4j
public class ContentProcessor implements ItemProcessor<ContentSource, ContentTarget> {
    public ContentTarget process(ContentSource contentSource) throws Exception {
        log.info(String.format("send message to device : %d"), contentSource.getId());

        ContentTarget contentTarget = new ContentTarget();
        contentTarget
                .setId(contentSource.getId())
                .setStatus("Finish");

        return contentTarget;
    }
}
