class MobilePhone{
    lateinit var brandName: String
}

class MobilePhoneUser{
    fun runMobileDevice(mobileServices: Any, mobilePhone: MobilePhone){
        if(mobileServices is HuaweiMobileServices)
            println("This device is running with Huawei Mobile Services")
    }
}

class HuaweiMobileServices{
    fun addMobileServiceToPhone(mobilePhone: MobilePhone){ println("Huawei Mobile Services") }
}