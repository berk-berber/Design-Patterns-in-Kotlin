[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)
# Design-Patterns-in-Kotlin
Design patterns can speed up our software development process because they provide tested, proven development paradigms.<br/><br/>
Design patterns are solutions to common problems that software developers encounter during software development process. These solutions have been achieved through trial and error by numerous software developers over a long period of time. Later, they gave names to these solutions which they found for certain problems.<br/><br/>
In this repository, I will explain design patterns, object oriented programming and SOLID principles with examples.

## Contents
1. [Object Oriented Programming](#object-oriented-programming)
   - [Object Oriented Programming Concepts](#object-oriented-programming-concepts)
     - [Encapsulation](#encapsulation)
     - [Abstraction](#abstraction)
     - [Inheritance](#inheritance)
     - [Polymorphism](#polymorphism)

## Object Oriented Programming
Object oriented programming(OOP) is a programming paradigm which depends on classes and objects. It helps software developers to structure their codes and make them reusable pieces.<br/><br/>
Software developers are creating many different classes for that.<br/>
Classes are user defined data types which have their own attributes and methods. These methods can determine the logical operations of the class. And attributes can hold data which a class can have.<br/>
We can create as many instances from a class as we want. These instances are called as object.

### Object Oriented Programming Concepts
Object-oriented programming has four basic concepts. These concepts might seem a little bit complex to you, if you are not familiar with them before. But understanding the how these concepts are working may help you so much for your software development career.

#### Encapsulation
Encapsulation means the attributes of a class is hidden from any other class and can be accessed only through any member methods of own class in which attributes are declared.<br/>
To do that, we can define attributes as private. Then, we can add getter-setter methods  as public for an attribute.<br/>
There are 3 visibility types for variables and methods. These are:
- <b>public:</b> If variables or methods are defined as public, can be accessed from any other class..
- <b>private:</b> If variables or methods are defined as private, can be accessed only in the class which we have defined the variables or methods.
- <b>protected:</b> If variables or methods are defined as protected, can only be accessed from within the class in which variables or methods were defined, or within other classes which have extended from that class which have variables or methods.

I will give you an example about encapsulation. But we don't need to worry about encapsulation in Kotlin. I will explain the reason after I give you the code
```kotlin
class EncapsulationExample {
    private var testString: String = ""
    private var testInteger: Int = 0
}
```
We don't need to worry about encapsulation in Kotlin. Because Kotlin compiler for JVM compiles Kotlin source files into Java class files. Thus, our code will be compiled as below:<br/>
(Name of the class won't change. I changed it to make it more understandable.)
```java
public class EncapsulationCompiled {
    private String testString = "";
    private int testInteger = 0;

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public int getTestInteger() {
        return testInteger;
    }

    public void setTestInteger(int testInteger) {
        this.testInteger = testInteger;
    }
}
```

#### Abstraction
Abstraction is a process of hiding the internal details of a class from the outer world.<br/>
We can define abstract methods or abstract classes. If one class has one abstract method at least, that means that class can be abstract class. Abstract classes are generally used to gather objects with common properties under one roof.
```kotlin
abstract class AbstractionExample{
    abstract fun abstractMethod()
    
    fun methodWithBody(){
        println("This method has a body.")
    }
} 
```
But, if all methods are abstract methods and there is not any method with a body, that means this is an interface.
```java
interface InterfaceExample {
    fun methodOne()
    fun methodTwo()
}
```

#### Inheritance
Inheritance means that one class acquires the attributes and methods of another class. That means, we can create new classes over existing classes.<br/>
Main purpose of inheritance is to provide the reusability of code. So, a class has to write only the unique attributes and methods. Rest of the common attributes and methods can be extended from the another class.<br/>
Here, two new terms come up. Parent class and child class.
- <b>Parent Class:</b> This the class whose attributes and methods will be using by child class.
- <b>Child Class:</b> This is class that extends the features of parent class.

<b>Note:</b> If we want to create extendable class (parent class) in Kotlin, we should add 'open' keyword before 'class' keyword. Otherwise, we can't extend this class from other classes. As same with classes, if we want to override a method in child class, we should add 'open' keyword before 'fun' keyword in parent class.
```kotlin
open class InheritanceParentClass{
    var attributeParentClass1 = "Attribute in Parent Class"
    private var attributeParentClass2 = "We can't reach this attribute in child class. Because we defined it as private"

    fun methodParentClass1() = "This is first method in InheritanceParentClass"

    open fun methodParentClass2() = "This is second method in InheritanceParentClass. We will override this one."
}
```
As we learnt in Encapsulation section, we can't reach attributes or methods in child class, which have defined as private in parent class. So if we want them to usable in child class, we shouldn't add private keyword.
```kotlin
class InheritanceChildClass: InheritanceParentClass() {
    fun methodChildClass1() = "This is first method in InheritanceParentClass"

    override fun methodParentClass2() = "This method has overridden in child class"

    fun printAttributeParentClass1(){
        println("$attributeParentClass1")
        attributeParentClass1 = "Attribute in Child Class"
        println("$attributeParentClass1")
    }
}
```
I will give very basic main method to print these methods
```kotlin
fun main(){
    var parentClass = InheritanceParentClass()
    var childClass = InheritanceChildClass()

    println("Parent Class - methodParentClass1: ${parentClass.methodParentClass1()}")
    println("Parent Class - methodParentClass2: ${parentClass.methodParentClass2()}")

    println("Child Class - methodChildClass1: ${childClass.methodChildClass1()}")
    println("Child Class - methodParentClass2: ${childClass.methodParentClass2()}")
    childClass.printAttributeParentClass1()
}
```
<b>Output</b>
```
Parent Class - methodParentClass1: This is first method in InheritanceParentClass
Parent Class - methodParentClass2: This is second method in InheritanceParentClass. We will override this one.
Child Class - methodChildClass1: This is first method in InheritanceParentClass
Child Class - methodParentClass2: This method has overridden in child class
Attribute in Parent Class
Attribute in Child Class
```

#### Polymorphism
With the help of polymorphism we can perform a single action in different ways. To do that, we need to define one interface, class or abstract class and we will have multiple implementations.<br/>
I will give a brief example. You will see that, with the help of polymorphism, a method can perform different operations based on the object that it is acting upon.<br/><br/>
First, we will have parent class called as 'PolymorphismBaseClass'
```kotlin
open abstract class PolymorphismBaseClass {
    open fun runMobileServiceOnDevice(){
        println("This device is not running any mobile services.")
    }

    abstract fun mobileServicesName(): String
}
```
Then we can create child classes from this parent class. Our child classes will use same method. These methods will do different but similar operations.
```kotlin
class PolymorphismHuaweiClass: PolymorphismBaseClass() {
    override fun runMobileServiceOnDevice() {
        println("This device can work with Huawei Mobile Services.")
    }

    override fun mobileServicesName(): String = "Huawei Mobile Services"
}
```
```kotlin
class PolymorphismGoogleClass: PolymorphismBaseClass() {
    override fun runMobileServiceOnDevice() {
        println("This device can work with Google Mobile Services.")
    }

    override fun mobileServicesName(): String = "Google Mobile Services"
}
```

## License
Design-Patterns-in-Kotlin is published under the terms of the Apache License(Version 2.0). See <a href="https://github.com/berkberberr/Design-Patterns-in-Kotlin/blob/main/LICENSE">license</a> file for details.
