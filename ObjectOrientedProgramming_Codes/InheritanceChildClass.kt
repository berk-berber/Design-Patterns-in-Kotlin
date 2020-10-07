class InheritanceChildClass: InheritanceParentClass() {
    fun methodChildClass1() = "This is first method in InheritanceParentClass"

    override fun methodParentClass2() = "This method has overridden in child class"

    fun printAttributeParentClass1(){
        println("$attributeParentClass1")
        attributeParentClass1 = "Attribute in Child Class"
        println("$attributeParentClass1")
    }
}