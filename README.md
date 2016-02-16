# AndroidFlux-Helloworld
Android Flux http://androidflux.github.io/docs/overview.html#content

基本设计思路是采用单向数据流。
* 1.Control-View（即activity或者fragment）调用ActionCreator对象发送消息
* 2.ActionCreator创建相应的Action对象，绑定上类型和数据，调用Dispatcher分派执行
* 3.Dispather循环调用注册的Store的方法，匹配的Store获取Action，得到相应的Action数据来更新数据
* 4.更新数据后，Store利用订阅模式调用Control-View的方法，方法中获取Store的数据更新到view

需要注意第4点，示例中使用了EventBus http://square.github.io/otto/ 简化了订阅模式中Control-View与Store的强耦合，
如果不用这个方式，需要自己实现Store与Control-View的订阅模式。
