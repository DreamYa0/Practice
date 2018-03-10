package netty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dreamyao on 2018/3/10.
 */
public class PlainoioServer {

    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        for (;;) {
            final Socket clientSocket = socket.accept();
            System.out.println("Accepted connection form " + clientSocket);
            ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));
            executor.submit(() -> {
                OutputStream out;
                try {
                    out = clientSocket.getOutputStream();
                    out.write("Hi\r\n".getBytes(Charset.defaultCharset()));
                    out.flush();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
