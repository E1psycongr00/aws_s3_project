package aws_s3_project.controller;

import aws_s3_project.infra.S3Uploader;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final S3Uploader s3Uploader;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("images") MultipartFile multipartFile)
        throws IOException {
        String upload = s3Uploader.upload(multipartFile);
        return ResponseEntity.status(HttpStatus.CREATED).body(upload);

    }
}
