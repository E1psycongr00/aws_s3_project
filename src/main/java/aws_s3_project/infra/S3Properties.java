package aws_s3_project.infra;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "cloud.aws.s3")
public class S3Properties {

    private String bucket;
    private String accessKey;
    private String secretKey;
    private String region;
}
