package netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/19 下午4:47
 * @since 1.0.0
 */
public class HttpPipelineInitializer extends ChannelInitializer<Channel> {

    private final boolean isClient;

    public HttpPipelineInitializer(boolean isClient) {
        this.isClient = isClient;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if (isClient) {
            pipeline.addLast("decoder", new HttpResponseDecoder())
                    .addLast("encoder", new HttpRequestEncoder());
        } else {
            pipeline.addLast("encoder", new HttpRequestDecoder())
                    .addLast("decoder", new HttpResponseEncoder());
        }
    }
}
