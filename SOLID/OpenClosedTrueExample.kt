class MobilePhone{
    lateinit var brandName: String
}

class MobilePhoneUser{
    fun runMobileDevice(mobileServices: IMobileServices, mobilePhone: MobilePhone){
        mobileServices.addMobileServiceToPhone(mobilePhone)
    }
}

interface IMobileServices{
    fun addMobileServiceToPhone(mobilePhone: MobilePhone)
}

class HuaweiMobileServices: IMobileServices{
    override fun addMobileServiceToPhone(mobilePhone: MobilePhone){ println("Huawei Mobile Services") }
}

class GoogleMobileServices: IMobileServices{
    override fun addMobileServiceToPhone(mobilePhone: MobilePhone){ println("Google Mobile Services") }
}