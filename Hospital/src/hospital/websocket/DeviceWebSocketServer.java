package hospital.websocket;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ApplicationScoped
@ServerEndpoint("/actions")
public class DeviceWebSocketServer {
	
	  @OnOpen
      public void open(Session session) {
		  System.out.println("merge sau nu merge");
  }

  @OnClose
      public void close(Session session) {
  }

  @OnError
      public void onError(Throwable error) {
  }

  @OnMessage
      public void handleMessage(String message, Session session) {
  }

}
