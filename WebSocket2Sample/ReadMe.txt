
Spring4.0
A new spring-websocket module provides comprehensive support for WebSocket-based, two-way communication between client and server in web applications.
 It is compatible with JSR-356, the Java WebSocket API
 in addition provides SockJS-based fallback options (i.e. WebSocket emulation) for use in browsers that don’t yet support the WebSocket protocol (e.g. Internet Explorer < 10).
 
 
 JSR-356
 https://tyrus-project.github.io/
 
 https://github.com/javaee/websocket-spec
 Java API for WebSocket (JSR-356) defines a standard API for creating web socket applications.
 
 
 
 STOMP 协议
 A new spring-messaging module adds support for STOMP as the WebSocket sub-protocol to use in applications along with an annotation programming model for routing and processing STOMP messages from WebSocket clients. 
 As a result an @Controller can now contain both @RequestMapping and @MessageMapping methods for handling HTTP requests and messages from WebSocket-connected clients. 
 
 
 Spring Framework’s support for WebSocket-style messaging in web applications including use of STOMP as an application level WebSocket sub-protocol.
 
 The WebSocket Protocol
 https://tools.ietf.org/html/rfc6455
 
 
 浏览器对WebSocket的支持
 https://caniuse.com/#feat=websockets
 
 build a WebSocket application today, fallback options are required in order to simulate the WebSocket API where necessary. 
 
 http://sockjs.org  SockJS协议,来模拟WebSocket协议
 An attempt to define SockJS protocol 
 
 
  WebSocket application may use a single URL only for the initial HTTP handshake.
   All messages thereafter share and flow on the same TCP connection.
   This points to an entirely different, asynchronous, event-driven, messaging architecture. 
   One that is much closer to traditional messaging applications (e.g. JMS, AMQP).
   
   
   Sub-Protocol Support in WebSocket
   
WebSocket does imply a messaging architecture but does not mandate the use of any specific messaging protocol. 
It is a very thin layer over TCP that transforms a stream of bytes into a stream of messages (either text or binary) and not much more.
It is up to applications to interpret the meaning of a message.


Unlike HTTP, which is an application-level protocol, in the WebSocket protocol there is simply not enough information in an incoming message for a framework or container to know how to route it or process it.
 During the handshake, the client and server can use the header Sec-WebSocket-Protocol to agree on a sub-protocol, i.e. a higher, application-level protocol to use. 
 
 
 The Spring Framework provides support for using STOMP
 STOMP is widely supported and well suited for use over WebSocket and over the web.
 
 
 
 The best fit for WebSocket is in web applications where the client and server need to exchange events at high frequency and with low latency. 
  
  
  
  https://github.com/sockjs/sockjs-client/
  
  https://github.com/Atmosphere/atmosphere
  https://github.com/sockjs/sockjs-client
  http://stomp.github.io/implementations.html
  
  
  
  WebSocket is not supported in all browsers yet and may be precluded by restrictive network proxies.
  Spring provides fallback options that emulate the WebSocket API as close as possible based on the SockJS protocol
  The goal of SockJS is to let applications use a WebSocket API but fall back to non-WebSocket alternatives when necessary at runtime
  
  SockJS is designed for use in browsers. It goes to great lengths to support a wide range of browser versions using a variety of techniques.
   Transports fall in 3 general categories: WebSocket, HTTP Streaming, and HTTP Long Polling. 
   The SockJS client begins by sending "GET /info" to obtain basic information from the server. After that it must decide what transport to use.
   
    If possible WebSocket is used. If not, in most browsers there is at least one HTTP streaming option and if not then HTTP (long) polling is used.
    
    A SockJS Java client is provided in order to connect to remote SockJS endpoints without using a browser. 
    
    
    
    
    SockJS-client
    
    SockJS is a browser JavaScript library that provides a WebSocket-like object. 
    SockJS gives you a coherent, cross-browser, Javascript API which creates a low latency, full duplex, cross-domain communication channel between the browser and the web server.
    
    Under the hood SockJS tries to use native WebSockets first. If that fails it can use a variety of browser-specific transport protocols and presents them through WebSocket-like abstractions.
    SockJS is intended to work for all modern browsers and in environments which don't support the WebSocket protocol -- for example, behind restrictive corporate proxies.
    
    
    
    
    
    STOMP
    
    The WebSocket protocol defines two types of messages, text and binary, but their content is undefined.
     It’s expected that the client and server may agree on using a sub-protocol (i.e. a higher-level protocol) to define message semantics.
     
     
     
     
   