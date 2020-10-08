class PolymorphismHuaweiClass: PolymorphismBaseClass() {
    override fun runMobileServiceOnDevice() {
        println("This device can work with Huawei Mobile Services.")
    }

    override fun mobileServicesName(): String = "Huawei Mobile Services"
}