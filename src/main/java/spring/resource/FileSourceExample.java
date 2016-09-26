package spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

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
        EncodedResource encodedResource = new EncodedResource(res, "UTF-8");
        try {
            String context = FileCopyUtils.copyToString(encodedResource.getReader());//获取文件内容
            InputStream inputStream = res.getInputStream();
            System.out.println("res: " + res.getFilename());
            System.out.println("res1: " + res.getFile());
            System.out.println("inputStream: " + inputStream.read());
            System.out.println(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
