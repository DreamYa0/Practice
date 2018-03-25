package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.ImmediateEventExecutor;

import javax.annotation.concurrent.ThreadSafe;
import java.net.InetSocketAddress;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/25 下午3:51
 * @since 1.0.0
 */
@ThreadSafe
public class ChatServer {

    private final ChannelGroup channelGroup = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);
    private final EventLoopGroup bossGroup = new NioEventLoopGroup(1,new DefaultThreadFactory("bossGroup"));
    private final EventLoopGroup workGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("workGroup"));
    private volatile Channel channel;

    public ChannelFuture start(InetSocketAddress address) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(createInitializer(channelGroup));
        ChannelFuture future = bootstrap.bind(address);
        future.syncUninterruptibly();
        channel = future.channel();
        return future;
    }

    public void destroy(){
        if (channel != null) {
            channel.close();
        }
        channelGroup.close();
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }

    protected ChannelInitializer<Channel> createInitializer(ChannelGroup group) {
        return new ChatServerInitializer(group);
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Please give port as argument");
            System.exit(1);
        }
        int port = Integer.parseInt(args[0]);
        ChatServer endPoint = new ChatServer();
        ChannelFuture future = endPoint.start(new InetSocketAddress(port));
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                endPoint.destroy();
            }
        });
        future.channel().closeFuture().syncUninterruptibly();
    }
}
