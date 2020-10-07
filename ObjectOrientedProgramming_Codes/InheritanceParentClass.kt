open class InheritanceParentClass{
    var attributeParentClass1 = "Attribute in Parent Class"
    private var attributeParentClass2 = "We can't reach this attribute in child class. Because we defined it as private"

    fun methodParentClass1() = "This is first method in InheritanceParentClass"

    open fun methodParentClass2() = "This is second method in InheritanceParentClass. We will override this one."
}