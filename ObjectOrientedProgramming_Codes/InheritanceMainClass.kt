fun main(){
    var parentClass = InheritanceParentClass()
    var childClass = InheritanceChildClass()

    println("Parent Class - methodParentClass1: ${parentClass.methodParentClass1()}")
    println("Parent Class - methodParentClass2: ${parentClass.methodParentClass2()}")

    println("Child Class - methodChildClass1: ${childClass.methodChildClass1()}")
    println("Child Class - methodParentClass2: ${childClass.methodParentClass2()}")
    childClass.printAttributeParentClass1()
}