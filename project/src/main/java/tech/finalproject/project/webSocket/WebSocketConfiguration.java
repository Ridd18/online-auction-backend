package tech.finalproject.project.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {


    private final static String BID_ENDPOINT = "/auction/bid";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(getBidWebSocketHandler(),BID_ENDPOINT)
                .setAllowedOriginPatterns("*");

    }

    @Bean
    public WebSocketHandler getBidWebSocketHandler()
    {
        return new BidWebSocketHandler();
    }
}

//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer {
//
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//
//        registry.addEndpoint("/auction/bid")
//                .withSockJS();
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//
//        registry.enableSimpleBroker("/topic");
//        registry.setApplicationDestinationPrefixes("/app");
//    }
//}

//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
//
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config){
//        config.enableSimpleBroker("/start");
//        config.setApplicationDestinationPrefixes("/current");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry
//                .addEndpoint("/auction/bid")
//                .setAllowedOrigins("http://localhost:4200")
//                .withSockJS();
//    }
//}

