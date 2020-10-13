data class User(
    var id: Long,
    var name: String,
    var password: String
){
    fun signIn(){
        // This method will do signing in operations
    }

    fun signOut(){
        // This method will do signing out operations
    }
}