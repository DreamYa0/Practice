package netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/25 下午4:12
 * @since 1.0.0
 */
public class SecureChatServerInitializer extends ChatServerInitializer{

    private final SslContext context;

    public SecureChatServerInitializer(ChannelGroup group, SslContext context) {
        super(group);
        this.context = context;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        super.initChannel(ch);
        SSLEngine engine = context.newEngine(ch.alloc());
        engine.setUseClientMode(false);
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new SslHandler(engine));
    }
}
