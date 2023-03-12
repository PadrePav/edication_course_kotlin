enum class ActionMachine(val action: String) {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit")
}

private enum class Coffee(val water: Int, val milk: Int, val coffee: Int, val price: Int) {
    ESPRESSO(250, 0, 16,4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6)
}

class CoffeeMachine () {
    private var water = 400
    private var milk = 540
    private var coffee = 120
    private var money = 550
    private var cups = 9

    fun writeAction() = println("Write action (${ActionMachine.BUY.action}, ${ActionMachine.FILL.action}, ${ActionMachine.TAKE.action}, ${ActionMachine.REMAINING.action}, ${ActionMachine.EXIT.action}):")

    fun actionBuy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu::")
        when (readln()) {
            "1" -> buyEspresso()
            "2" -> buyLatte()
            "3" -> buyCappuccino()
            "back" -> return
        }
        println()
    }

    private fun buyEspresso() {
        if (this.water - Coffee.ESPRESSO.water >= 0 && this.coffee - Coffee.ESPRESSO.coffee >= 0 && this.cups - 1 >= 0) {
            this.water -= Coffee.ESPRESSO.water
            this.coffee -= Coffee.ESPRESSO.coffee
            this.cups -= 1
            this.money += Coffee.ESPRESSO.price
        } else {
            println("I have enough resources, making you a coffee!")
        }
    }
    private fun buyLatte() {
        if (this.water - Coffee.LATTE.water >= 0 && this.milk - Coffee.LATTE.milk >= 0 && this.coffee - Coffee.LATTE.coffee >= 0 && this.cups - 1 >= 0) {
            this.water -= Coffee.LATTE.water
            this.milk -= Coffee.LATTE.milk
            this.coffee -= Coffee.LATTE.coffee
            this.cups -= 1
            this.money += Coffee.LATTE.price
        } else {
            println("I have enough resources, making you a coffee!")
        }
    }
    private fun buyCappuccino() {
        if (this.water - Coffee.CAPPUCCINO.water >= 0 && this.milk - Coffee.CAPPUCCINO.milk >= 0 && this.coffee - Coffee.CAPPUCCINO.coffee >= 0 && this.cups - 1 >= 0) {
            this.water -= Coffee.CAPPUCCINO.water
            this.milk -= Coffee.CAPPUCCINO.milk
            this.coffee -= Coffee.CAPPUCCINO.coffee
            this.cups -= 1
            this.money += Coffee.CAPPUCCINO.price
        } else {
            println("I have enough resources, making you a coffee!")
        }
    }
    //Replenishes our coffee machine
    fun actionFill() {
        println("Write how many ml of water you want to add:")
        this.water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        this.milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        this.coffee += readln().toInt()
        println("Write how many disposable cups you want to add:")
        this.cups += readln().toInt()
        println()
    }
    //cashes out all the money (sets the "money" variable to zero)
    fun actionTake() {
        println("I gave you $${this.money}")
        println()
        this.money = 0
    }
    //Shows the values of all data
    fun menu() {
        println()
        println("""
        The coffee machine has:
        ${this.water} ml of water
        ${this.milk} ml of milk
        ${this.coffee} g of coffee beans
        ${this.cups} disposable cups
        $${this.money} of money
    """.trimIndent())
        println()
    }
}

fun main() {
    val machine = CoffeeMachine()
    while (true) {
        machine.writeAction()
        when (readln()) {
            ActionMachine.BUY.action -> machine.actionBuy()
            ActionMachine.FILL.action -> machine.actionFill()
            ActionMachine.TAKE.action -> machine.actionTake()
            ActionMachine.REMAINING.action -> machine.menu()
            ActionMachine.EXIT.action -> break
        }
    }
}