
package com.kojavaee.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;

/**
 * httpServer服务启动类
 * 
 * @author lzh
 */
public class HttpServerMain {

    public static void main(String[] args) {
        
    }

    public static void start(int port) {
        // 配置服务器，使用java线程作为解释线程
        // TODO：需要了解serverbootstrap
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
        
        // 设置 pipeline factory
        bootstrap.setPipelineFactory(new ServerPipelineFactory());
        
        bootstrap.bind(new InetSocketAddress(port));
        System.out.println("http start on " + port);
    }

    private static class ServerPipelineFactory implements
            ChannelPipelineFactory {
        public ChannelPipeline getPipeline() throws Exception {
            // Create a default pipeline implementation.
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("decoder", new HttpRequestDecoder());
            pipeline.addLast("encoder", new HttpResponseEncoder());
            // http处理handler
            //pipeline.addLast("handler", new HttpServerHandler());
            return pipeline;
        }
    }

}
