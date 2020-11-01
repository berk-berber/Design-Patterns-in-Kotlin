interface Animal{
    fun eat()
    fun sleep()
}

interface FlyingAnimal{
    fun fly()
}

class Cat: Animal{
    override fun eat() {
        println("Cat is eating fish")
    }

    override fun sleep() {
        println("Cat is sleeping on its owner's bed")
    }
}

class Bird: Animal, FlyingAnimal{
    override fun eat() {
        println("Bird is eating forage")
    }

    override fun sleep() {
        println("Bird is sleeping in the nest")
    }

    override fun fly() {
        println("Bird is flying so high")
    }
}