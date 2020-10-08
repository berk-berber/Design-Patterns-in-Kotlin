open abstract class PolymorphismBaseClass {
    open fun runMobileServiceOnDevice(){
        println("This device is not running any mobile services.")
    }

    abstract fun mobileServicesName(): String
}