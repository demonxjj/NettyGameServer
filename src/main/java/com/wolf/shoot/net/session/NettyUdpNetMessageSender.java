package com.wolf.shoot.net.session;

import com.wolf.shoot.common.exception.NetMessageException;
import com.wolf.shoot.net.message.NetMessage;

/**
 * Created by jiangwenping on 17/2/15.
 * udp的消息发送器
 */
public class NettyUdpNetMessageSender implements INetMessageSender{
    private final NettySession nettySession;

    public NettyUdpNetMessageSender(NettySession nettySession) {
        this.nettySession = nettySession;
    }

    @Override
    public boolean sendMessage(NetMessage message) throws NetMessageException {
        try {
            nettySession.write(message);
        }catch (Exception e){
            throw new NetMessageException("write udp netmessage error", e);
        }
        return true;
    }

    @Override
    public void close() throws NetMessageException {

    }
}