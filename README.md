# cloud
待解决错误
    com.netflix.turbine.monitor.instance.InstanceMonitor$MisconfiguredHostException: [{"timestamp":"2019-08-22T11:34:53.585+0000","status":404,"error":"Not Found","message":"No message available","path":"/xl/hystrix.stream"}]

springboot版本为：  (v2.1.7.RELEASE)
maven：3.5
jdk 1.8




问题
 springcloud config server集群为两个
 springcloud config client 集群为两个
 当我在client集群两个机器上引入mq配置shi
 ### 刷新时，关闭安全验证
#management.security.enabled=false
### 开启消息跟踪
#spring.cloud.bus.trace.enabled=true
#
#spring.rabbitmq.host=192.168.9.89
#spring.rabbitmq.port=567
#spring.rabbitmq.username=admin
#spring.rabbitmq.password=123456

执行刷新失败

当我把其中一台的mq配置隐藏掉时刷新成功

情况
a，b两台
a台引入mq配置   b台没有引入

a控制塔打印
2019-08-23 15:59:44.137  WARN 14676 --- [YK49joI2tiLBQ-4] o.s.a.r.l.SimpleMessageListenerContainer : Consumer raised exception, processing can restart if the connection factory supports it. Exception summary: org.springframework.amqp.AmqpConnectException: java.net.ConnectException: Connection timed out: connect
2019-08-23 15:59:44.137  INFO 14676 --- [YK49joI2tiLBQ-4] o.s.a.r.l.SimpleMessageListenerContainer : Restarting Consumer@744f432a: tags=[[]], channel=null, acknowledgeMode=AUTO local queue size=0
2019-08-23 15:59:44.137  INFO 14676 --- [YK49joI2tiLBQ-5] o.s.a.r.c.CachingConnectionFactory       : Attempting to connect to: [192.168.9.89:5672]

b控制台打印
2019-08-23 16:00:41.903  WARN 14876 --- [iDl6QKgLCYMQ-62] o.s.a.r.l.SimpleMessageListenerContainer : Consumer raised exception, processing can restart if the connection factory supports it. Exception summary: org.springframework.amqp.AmqpConnectException: java.net.ConnectException: Connection refused: connect
2019-08-23 16:00:41.903  INFO 14876 --- [iDl6QKgLCYMQ-62] o.s.a.r.l.SimpleMessageListenerContainer : Restarting Consumer@7887af65: tags=[[]], channel=null, acknowledgeMode=AUTO local queue size=0
2019-08-23 16:00:41.903  INFO 14876 --- [iDl6QKgLCYMQ-63] o.s.a.r.c.CachingConnectionFactory       : Attempting to connect to: [localhost:5672]

现在刷新a  失败  curl -X POST http://xl-config-client:8098/bus/refresh
{"timestamp":"2019-08-23T08:01:54.019+0000","status":404,"error":"Not Found","message":"No message available","path":"/bus/refresh"}


刷新b    curl -X POST http://xl-config-client:8013/bus/refresh 失败
貌似是连接不上mq

 
Consumer raised exception, processing can restart if the connection factory supports it.

之前成功的一次刷新 是因为我一开始两台都引入了mq配置，执行刷新命令不成功，则改为一台引入mq配置 则成功 


现在两台都重新启动引入配置，在修改配置文件在重新刷新 看看效果
发觉是没有连接到mq 但是成功那一次 我发送刷新请求成功

现在测试server 可以正常取到git最新文件 



