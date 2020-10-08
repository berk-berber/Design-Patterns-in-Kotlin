class PolymorphismGoogleClass: PolymorphismBaseClass() {
    override fun runMobileServiceOnDevice() {
        println("This device can work with Google Mobile Services.")
    }

    override fun mobileServicesName(): String = "Google Mobile Services"
}