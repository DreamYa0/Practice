package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * Created by dreamyao on 2018/3/22.
 */
public class ShortToByteEncoder extends MessageToMessageEncoder<Short>{
    @Override
    protected void encode(ChannelHandlerContext ctx, Short msg, List<Object> out) throws Exception {
        out.add(msg.byteValue());
    }
}
