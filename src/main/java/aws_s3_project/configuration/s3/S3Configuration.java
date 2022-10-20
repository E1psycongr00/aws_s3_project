package aws_s3_project.configuration.s3;


import aws_s3_project.infra.S3Properties;
import aws_s3_project.infra.S3Uploader;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class S3Configuration {

    private final S3Properties s3Properties;

    @Bean
    public AmazonS3Client amazonS3Client() {
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
            .withRegion(s3Properties.getRegion())
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                s3Properties.getAccessKey(),
                s3Properties.getSecretKey())))
            .build();
    }

    @Bean
    public S3Uploader s3Uploader(AmazonS3Client amazonS3Client) {
        return new S3Uploader(amazonS3Client, s3Properties.getBucket());
    }
}
