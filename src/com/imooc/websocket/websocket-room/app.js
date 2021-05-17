// 1.导入nodejs-websocket  包
const  ws = require("nodejs-websocket")
const  PORT =3000

let count = 0
// 每次只要有用户连接，函数就会被执行，会给当前连接的用户创建一个connect
const server= ws.createServer(connect =>{
    console.log('有新的用户连接')
    count++
    connect.userName = `用户${count}`
    //1. 告诉所有用户，有人加入了聊天室
    broadcast(`${connect.userName}进入了聊天室`)



    // 接收到了浏览器的数据
    connect.on('text', data =>{
        // console.log('收到了消息'+data)
        // 2. 当我们接收到某个用户的消息时，告诉所有用户的，发送的消息的内容是什么
        broadcast(data)
    })


    // 关闭连接时触发
    connect.on('close',()=>{
        console.log('用户关闭连接')
        count--
        // 3. 告诉所有人，有人离开了聊天室
        broadcast(`${connect.userName}离开了聊天室`)
    })


    // 发生异常时触发
    connect.on('error',()=>{
        console.log('发生异常处理')
    })
})

//  广播的函数，给所有用户发送消息
function broadcast(msg){
    // server.connections :表示当前所有用户
    server.connections.forEach(item =>{
        item.send(msg)
    })
}

//创建服务以后进行监听
server.listen(PORT,() =>{
    console.log('websocket启动成功了，监听了端口'+PORT)
})