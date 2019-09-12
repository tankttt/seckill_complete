package org.seckill.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.ttf.ssm.index.entity.UserInfo;

/**
 * 该对象作为页面连接websocket服务的拦截器
 * @author afeid
 */
public class SpringWebSocketHandlerInterceptor extends
		HttpSessionHandshakeInterceptor {
	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest()
					.getSession(false);
			if (session != null) {
				UserInfo userInfo = (UserInfo) session
						.getAttribute("USER_SESSION");
				if (userInfo == null) {
					userInfo =  new UserInfo();
					userInfo.setUserNickName("default_user_name");
				}
				/*
				 * 为WebSocketSession.getHandshakeAttributes()提供属性:
				 * UserInfo userInfo= (UserInfo) WebSocketSession.getHandshakeAttributes().get("WEBSOCKET_USER")可以获得该对象,UserInfo为普通的POJO;
				 */
				attributes.put("WEBSOCKET_USER", userInfo);
			}
		}
		return super.beforeHandshake(request, response, wsHandler, attributes);

	}

	@Override
	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		// TODO Auto-generated method stub
		super.afterHandshake(request, response, wsHandler, ex);
	}
}