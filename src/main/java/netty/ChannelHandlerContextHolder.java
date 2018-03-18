package netty;

import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ChannelHandlerContextHolder {

    private static final ConcurrentMap<String, ChannelHandlerContext> channelHandlerContext = new ConcurrentHashMap<>();

    public static void setContext(String name, ChannelHandlerContext context) {
        channelHandlerContext.putIfAbsent(name, context);
    }

    public static ChannelHandlerContext getContext(String name) {
        return channelHandlerContext.get(name);
    }
}
