interface Vehicle{
    fun moveForward()
    fun moveBack()
}

abstract class VehicleWithEngine: Vehicle{
    private var isEngineWorking = false
    open fun startEngine(){ isEngineWorking = true }
    open fun stopEngine(){ isEngineWorking = false }
}

class Car: VehicleWithEngine(){
    override fun startEngine() {
        super.startEngine()
        println("Engine started")
    }

    override fun stopEngine() {
        super.stopEngine()
        println("Engine stopped")
    }

    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving back")
    }
}

class Bicycle: Vehicle{
    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving back")
    }
}