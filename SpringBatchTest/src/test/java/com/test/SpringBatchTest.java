package com.test;

import com.test.content.ContentSource;
import com.test.content.ContentTarget;
import com.test.processor.ContentProcessor;
import com.test.reader.mapper.ContentLineMapper;
import com.test.writer.aggregator.ContentLineAggregator;
import junit.framework.TestCase;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.Calendar;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/24 22:04
 */
public class SpringBatchTest extends TestCase {

    public void testBatch() throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        ResourcelessTransactionManager transactionManager = context.getBean(ResourcelessTransactionManager.class);
        JobRepository jobRepository = context.getBean(JobRepository.class);
        SimpleJobLauncher jobLauncher = context.getBean(SimpleJobLauncher.class);

        FlatFileItemReader<ContentSource> reader = new FlatFileItemReader<ContentSource>();
        reader.setResource(new ClassPathResource("dataSource.csv"));
        reader.setLineMapper(new ContentLineMapper());

        ContentProcessor processor = new ContentProcessor();

        FlatFileItemWriter<ContentTarget> writer = new FlatFileItemWriter<ContentTarget>();
        writer.setResource(new ClassPathResource(String.format("dataTarget-%s.csv", Calendar.getInstance().getTime().toString())));
        writer.setLineAggregator(new ContentLineAggregator());

        StepBuilderFactory stepBuilderFactory = new StepBuilderFactory(jobRepository, transactionManager);
        Step step = stepBuilderFactory.get("step")
                .<ContentSource, ContentTarget>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

        JobBuilderFactory jobBuilderFactory = new JobBuilderFactory(jobRepository);
        Job job = jobBuilderFactory.get("job").start(step).build();

        jobLauncher.run(job, new JobParameters());

    }

}
