package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;

import java.net.InetSocketAddress;

public class DatagramChannelClient {

    public void start(int port) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        OioEventLoopGroup group = new OioEventLoopGroup();
        try {
            bootstrap.group(group)
                    .channel(DatagramChannel.class)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new SimpleChannelInboundHandler<DatagramPacket>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {

                                }
                            });
                        }
                    });
            ChannelFuture future = bootstrap.bind(new InetSocketAddress(port)).sync();
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("Server bound");
                    } else {
                        System.err.println("Bind attempt failed");
                        future.cause().printStackTrace();
                    }
                }
            });
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
