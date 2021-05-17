// 1.导入nodejs-websocket  包
const  ws = require("nodejs-websocket")
const  PORT =3000

// 2. 创建一个server  connect 表示一个用户的连接
// 2.1 如何处理用户发的信息

// 下面的写法是简化了函数的写法，connect是函数的参数，完整的写法可以参见websocket-nodejs的官方样例写法 https://github.com/sitegui/nodejs-websocket
// 每次只要有用户连接，函数就会被执行，会给当前连接的用户创建一个connect
const server= ws.createServer(connect =>{
    console.log('有用户链接上来了')
    // 注册一个 text事件，每当有用户传递过来的数据，这个事件就会被触发
    connect.on('text', data =>{
        console.log('接受到了用户的数据'+data)
        // 给用户返回一个响应
        connect.send(data.toUpperCase()+"!!!")
    })

    // 只要websocket连接断开了，close事件就会被触发
    connect.on('close',()=>{
        console.log('连接断开了')
    })

    // 因为断开连接的时候会产生一个error事件，需要处理一下，否则会导致程序崩溃
    connect.on('error',()=>{
        console.log('用户连接异常')
    })
})

//创建服务以后进行监听
server.listen(PORT,() =>{
    console.log('websocket启动成功了，监听了端口'+PORT)
})