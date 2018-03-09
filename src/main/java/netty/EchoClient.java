package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import javax.annotation.concurrent.Immutable;
import java.net.InetSocketAddress;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/9 上午10:24
 * @since 1.0.0
 */
@Immutable
public class EchoClient {

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host,port)).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new EchoClientHandler());
                }
            });
            // 连接到远程节点，阻塞等待直到连接完成
            ChannelFuture future = b.connect().sync();
            // 阻塞，直到Channel关闭
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        /*if (args.length != 2) {
            System.out.println("Usage: " + EchoClient.class.getSimpleName() + "<host> <port>");
        }

        String host = args[0];
        Integer port = Integer.parseInt(args[1]);*/

        System.out.println("Usage: " + EchoClient.class.getSimpleName() + "<host> <port>");
        new EchoClient("127.0.0.1", 8888).start();
    }
}
