import kotlinx.coroutines.*

class Market() {
    var item = "unnamed"
    var qt  = 0
    var price = 0.0
    fun Input() {
        try {
            println("Введите название товара")
            item = readln()
            do {
                println("Введите количество товара")
                this.qt = readln()!!.toInt()
            } while (this.qt <= 0)
            do {
                println("Введите цену товара")
                this.price = readln()!!.toDouble()
            } while (this.price <= 0)

        } catch (e: Exception) {
            println("Данные введены неверно")
        }
    }

    fun GetPrice() {
        var answer = this.qt * this.price
        println("Цена ${this.item} за ${this.qt} шт. : ${answer}")
    }
     fun Output() {
        println("Товар ${this.item}")
         println("Количество товара ${this.qt} шт.")
         println("Количество товара ${this.price} шт.")
    }
}

class User() {
    public var name = "unnamed"
    public var password  = "unnamed"
    public var qt = 0
    public var closed = false
    fun Input(name : String) {
        try {
            this.name = name
            println("Введите пароль пользователя")
            this.password = readln()
            do {
                println("Введите количество репозиториев")
                this.qt = readln()!!.toInt()
            } while (this.qt <= 0)
            do {
                println("Открытый или закрытый репозиторий?")
                var enter = readln()
                if (enter == "Открытый")
                {
                    this.closed = false
                }
                else if (enter == "Закрытый")
                {
                    this.closed = true
                }

            } while (enter != "Закрытый" && enter != "Открытый")

        } catch (e: Exception) {
            println("Данные введены неверно")
        }
    }

   suspend fun Sort(users : List<User>) : List<User>
   {
       return users.sortedWith(compareBy{it.qt})
   }
}
