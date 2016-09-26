package spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-25.
 *         P55
 */
public class FileSourceExample {
    public static void main(String[] args) {
        Resource res = new ClassPathResource("/xsd/dataset.xsd");
        try {
            InputStream inputStream = res.getInputStream();
            System.out.println("res: " + res.getFilename());
            System.out.println("res1: " + res.getFile());
            System.out.println("inputStream: " + inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
