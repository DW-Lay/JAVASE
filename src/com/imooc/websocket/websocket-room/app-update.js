// 1.导入nodejs-websocket  包
const  ws = require("nodejs-websocket")
const  PORT =3000
const TYPE_ENTER = 0
const TYPE_LEAVE = 1
const TYPE_MSG = 2
let count = 0

const server= ws.createServer(connect =>{
    console.log('有新的用户连接')
    count++
    connect.userName = `用户${count}`


    broadcast({
        type: TYPE_ENTER,
        msg: `${connect.userName}进入了聊天室`,
        time: new Date().toLocaleTimeString()
    })


    // 接收到了浏览器的数据
    connect.on('text', data =>{
        broadcast({
            type: TYPE_MSG,
            msg:`${connect.userName}: `+data,
            time:new Date().toLocaleTimeString()
        })
    })


    // 关闭连接时触发
    connect.on('close',()=>{
        console.log('用户关闭连接')
        count--
        broadcast({
            type:TYPE_LEAVE,
            msg:`${connect.userName}离开了聊天室`,
            time: new Date().toLocaleTimeString()
        })

    })


    // 发生异常时触发
    connect.on('error',()=>{
        console.log('发生异常处理')
    })
})

//  广播的函数，给所有用户发送消息
function broadcast(msg){
    server.connections.forEach(item =>{
        // 通过send 方法只能发字符串类型的，要是对象类型，得用json转为字符串
        item.send(JSON.stringify(msg))
    })
    // console.log(msg.type)
}

//创建服务以后进行监听
server.listen(PORT,() =>{
    console.log('websocket启动成功了，监听了端口'+PORT)
})