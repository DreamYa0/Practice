package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class FrameChunkDecoder extends ByteToMessageDecoder {

    private final int maxSize;

    public FrameChunkDecoder(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int readableBytes = in.readableBytes();
        if (readableBytes > maxSize) {
            // 丢弃
            in.clear();
            throw new RuntimeException();
        }
        ByteBuf buf = in.readBytes(readableBytes);
        out.add(buf);
    }
}
