package com.test.reader.mapper;

import com.test.content.ContentSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.LineMapper;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/24 21:27
 */
@Slf4j
public class ContentLineMapper implements LineMapper<ContentSource> {
    public ContentSource mapLine(String lineContent, int lineNumber) throws Exception {
        log.info(String.format("the %d(st) line content is : %s", lineNumber, lineContent));

        ContentSource contentSource = new ContentSource();
        String[] contents = lineContent.split(",");

        contentSource
                .setId(Integer.parseInt(contents[0]))
                .setStatus(contents[1]);

        return contentSource;
    }
}
