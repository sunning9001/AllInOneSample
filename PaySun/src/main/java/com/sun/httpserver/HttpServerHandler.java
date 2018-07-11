
package com.sun.httpserver;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.sun.BillHandleCenter;
import com.sun.config.ConfigUtil;
import com.sun.config.InfConstants;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.AsciiString;

/**
 * 参见：https://my.oschina.net/xinxingegeya/blog/295408
 * 
 * @author sunning
 *
 */
public class HttpServerHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);
	private static final AsciiString CONTENT_TYPE = AsciiString.cached("Content-Type");
	private static final AsciiString CONTENT_LENGTH = AsciiString.cached("Content-Length");
	private static final AsciiString CONNECTION = AsciiString.cached("Connection");
	private static final AsciiString KEEP_ALIVE = AsciiString.cached("keep-alive");

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	/**
	 * 接口名称和消息体的风格符号: 例如： "wp_outer_bill_pay_query_response": {"code":"000000"}
	 */
	private static final String separatorchars = ":";

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		if (msg instanceof FullHttpRequest) {
			FullHttpRequest req = (FullHttpRequest) msg;

			ByteBuf cttByteBuf = req.content();
			if (cttByteBuf.readableBytes() > 0) {
				byte[] cttBytes = ByteBufUtil.getBytes(cttByteBuf);

				// 把字节序按照GBK格式 转换成字符串
				String postBody = new String(cttBytes, Charset.forName(ConfigUtil.getEncoding()));
				logger.debug("received postBody:{ }", postBody);
			
				

				String method = (String)JSONObject.parseObject(postBody).get("method");
			     
			      
			     System.out.println(method);

				// 根据接口名称,把postBody中消息体转换成消息对象
				Class clazz = InfConstants.getInfRequestClazz(method);

				// 转换消息对象
				Object obj = JSONObject.parseObject(postBody, clazz);

				// 业务处理中心
				BillHandleCenter.getInstance().handle(obj, clazz, ctx);
			}

		}
	}

	/**
	 * 写入消息并关闭
	 * 
	 * @param ctx
	 * @param msg
	 */
	public static void writeAndClose(ChannelHandlerContext ctx, Object msg) {
		// 把对象Object 转换成json字符串
		String jsonString = JSONObject.toJSONString(msg);
		// 把json字符串 转换成二进制字节码
		byte[] content = jsonString.getBytes(Charset.forName("GBK"));
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(content));
		response.headers().set(CONTENT_TYPE, "application/json");
		response.headers().setInt(CONTENT_LENGTH, response.content().readableBytes());
		ctx.write(response).addListener(ChannelFutureListener.CLOSE);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
