package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author dreamyao
 * @title @Sharable标识一个ChannelHandler可以被多个Channel安全地共享
 * @date 2018/3/8 下午9:33
 * @since 1.0.0
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(ctx.name());
        ByteBuf in = (ByteBuf) msg;
        String string = in.toString(CharsetUtil.UTF_8);
        if ("Netty rocks".equals(string)) {
            // 将消息记录到控制台
            System.out.println("Server received: " + string);
            // 将接收到消息写给发送者，而不冲刷出站消息
            ctx.write(in);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 打印异常栈跟踪
        cause.printStackTrace();
        // 关闭Channel
        ctx.close();
    }
}
