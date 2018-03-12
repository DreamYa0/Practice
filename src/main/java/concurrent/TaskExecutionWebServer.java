package concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author dreamyao
 * @title 基于线程池的Web服务
 * @date 2018/3/12 下午12:57
 * @since 1.0.0
 */
public class TaskExecutionWebServer {

    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        for (;;) {
            final Socket connect = socket.accept();
            Runnable runnable = () -> handleRequest(connect);
            exec.execute(runnable);
        }
    }

    private static void handleRequest(Socket connect) {

    }
}
