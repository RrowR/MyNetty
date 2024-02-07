//package com.study.company;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//
///**
// * @Author: hxd
// * @Date: 2021/12/28 4:41 下午
// */
//public class NettyDemo {
//    public static void main(String[] args) {
//        NioEventLoopGroup boss = new NioEventLoopGroup(1);      // boss,处理客户端连接请求
//        NioEventLoopGroup worker = new NioEventLoopGroup(2);    // worker，先处理客户端的业务员请求
//        ServerBootstrap bootstrap = new ServerBootstrap();               // 引导程序
//        bootstrap.group(boss,worker)    // 创建组
//                .channel(NioServerSocketChannel.class)  // 创建通道
//                .childHandler()
//
//
//    }
//}
