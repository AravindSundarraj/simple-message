package com.test.notification.awsmessage.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {


    @Bean
    public AmazonSQS amazonSQS()
    {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials("<Access key ID>"
        ,"<Secret Key Id >");
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                        .withRegion(Regions.US_EAST_1).
                build();
        return amazonSQS;
    }

}
