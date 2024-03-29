import kotlinx.coroutines.*


//suspend fun main() { // 1 ЗАДАНИЕ
//    do {
//        println("Введите количество вводимых товаров")
//        var i = readln()!!.toInt()
//    } while (i <= 0)
//    GlobalScope.launch { for (i in 0..i-1){
//        var market = Market()
//        market.Input()
//        market.GetPrice()
//        market.Output()
//    } }
//   runBlocking { delay(10000000L) }
//}

suspend fun main() {
    var users: MutableList<User> = mutableListOf()
    var enabled = true
    while (enabled == true) {
        var user = User()
        println("Введите имя пользователя || (БЛОКИРОВКА - чтобы закончить)")
        var name = readln()!!.toString()
        if (name == "БЛОКИРОВКА") {
            enabled = false
        } else {
            user.Input(name)
            users.add(user)
        }
    }
    delay(5000L)
    var user = User()
    var sorted = users.first().Sort(users)
    for (element in sorted) {
        if (element.closed == false) {
            println("Имя пользователя - ${element.name},пароль пользователя - ${element.password},количество репозиториев - ${element.qt}")
        }
//    }
//}
