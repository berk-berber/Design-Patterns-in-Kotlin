abstract class Vehicle{
    protected var isEngineWorking = false
    abstract fun startEngine()
    abstract fun stopEngine()
    abstract fun moveForward()
    abstract fun moveBack()
}

class Car: Vehicle(){
    override fun startEngine() {
        println("Engine started")
        isEngineWorking = true
    }

    override fun stopEngine() {
        println("Engine stopped")
        isEngineWorking = false
    }

    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving back")
    }
}

class Bicycle: Vehicle(){
    override fun startEngine() {
        // TODO("Not yet implemented")
    }

    override fun stopEngine() {
        // TODO("Not yet implemented")
    }

    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving back")
    }
}