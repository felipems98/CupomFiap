package br.com.fiap.Ocr.Application;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;

import javax.imageio.ImageWriter;

import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.multipart.MultipartFile;

import br.com.fiap.Ocr.Dto.ResponseDataDto;

public class ProcessImage {

    public ResponseDataDto Process(MultipartFile Img){
        
       var file = new File("img.jpg");
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(Img.getBytes());
        }



        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
          .newBuilder()
          .uri(URI.create("https://reqbin.com/echo/post/json"))
          .POST(HttpRequest.BodyPublishers.ofFile(file.getName()))
          .header("Accept", "application/json")
          .build();
        
        return null;
    
    }
    
}
