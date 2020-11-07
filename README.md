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
2. [SOLID Principles](#solid-principles)
   - [Single Responsibility Principle](#single-responsibility-principle)
   - [Open-Closed Principle](#open-closed-principle)
   - [Liskov Substitution Principle](#liskov-substitution-principle)
   - [Interface Segregation Principle](#interface-segregation-principle)
   - [Dependency Inversion Principle](#dependency-inversion-principle)

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

## SOLID Principles
In object-oriented computer programming, SOLID is design principles intended to make software more understandable, flexible and maintainable.<br/>
SOLID helps us to write sustainable code while developing software. This means, when software requirements have changed or we want to make additions to existing software, the system won't resist this. We will add new requiremements and functions easily. In addition to these, there are reasons such as maintenance and being easy to understand.

### Single Responsibility Principle
Single-responsibility principle means that every module, class or method in a computer program should have responsibility over a single part of that program's functionality.<br/>
We shouldn't have objects which know too much and have unnecessary behavior. So, a class will do only one job. Thus, this class should have only one reason to change.<br/><br/>
For example, let's think that we have class called as user which holds the information about user. Then we will add sign in and sign out methods for this user to manage authentication operations.
```kotlin
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
```
But as you have learned with Single Responsibility Principle, all classes should have responsibility for a single process of a program.<br/>
If we would like to make some changes for authentication process in sign in or sign out methods, our User class will be affected too. So, we will add more than one responsibility to one class. We shouldn't do that and we should separate our classes.<br/>
That means, User class should do operations for only holding informations of the user. If we would like to manage authentication process of user like signing in and signing out, we should add a new class to manage authentication process.
```kotlin
data class User(
    var id: Long,
    var name: String,
    var password: String
)

class AuthenticationService(){
    fun signIn(){
        // This method will do signing in operations
    }

    fun signOut(){
        // This method will do signing out operations
    }
}
```

### Open-Closed Principle
There are two different important meanings for this principle.
- <b>Open:</b> Means that we can add new features to class. When there are some changes on our dependencies, we should be able to add new features to our class easily
- <b>Closed:</b> Means that base features of class shouldn't be able to change
Let's imagine that we have a MobilePhoneUser class which is holding mobile phone and mobile services. This class will do operations for users' mobile phones by working with mobile services. And there are 2 different mobile services(HMS and GMS)
```kotlin
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
```
In the above code, we are checking mobile service type with if-else condition. This is a bad example, because when we want to add new mobile services, we will always need to check mobile services with if-else conditions.<br/>
According to Open-Closed Principle, we should add one interface for all mobile services. Then, each mobile service types will implement this interface and will do their own business. Thus, we won't need to check mobile service type to make different operations
```kotlin
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
```

### Liskov Substitution Principle
We should be able to use subclasses instead of the parent classes which class they have extended, without the need to make any changes in our code. In simple words, child class must be substitutable for the parent class.<br/>
Since child classes extended from the parent classes, they inherit their behavior. If child classes can not perform the behaviors belonging to the parent classes, probably, we won't write any code in the method that does the behavior or we will throw an error when objects want to use it. But these actions cause code pollution and unnecessary code crowds.<br/><br/>
Let's think that we have an abstract class called as Vehicle. This abstract class have some methods about engine situation and moving forward/back. When we want to create child classes such as Car, Truck and etc. to extend Vehicle abstract class will be fine for us.
```kotlin
abstract class Vehicle{
    protected var isEngineWorking = false
    abstract fun startEngine()
    abstract fun stopEngine()
    abstract fun moveForward()
    abstract fun moveBack()
}

class Car: Vehicle(){
    override fun startEngine() {
        println("Engine started")
        isEngineWorking = true
    }

    override fun stopEngine() {
        println("Engine stopped")
        isEngineWorking = false
    }

    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving back")
    }
}

class Bicycle: Vehicle(){
    override fun startEngine() {
        // TODO("Not yet implemented")
    }

    override fun stopEngine() {
        // TODO("Not yet implemented")
    }

    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving back")
    }
}
```
But as you see in the above code, when we want to create child class called as Bicycle, it's startEngine and stopEngine methods will be unnecessary. Because bicycles don't have an engine.<br/>
To fix this situation, we can create a new child class which will extend the Vehicle. This class will work with vehicles which will have an engine.
```kotlin
interface Vehicle{
    fun moveForward()
    fun moveBack()
}

abstract class VehicleWithEngine: Vehicle{
    private var isEngineWorking = false
    open fun startEngine(){ isEngineWorking = true }
    open fun stopEngine(){ isEngineWorking = false }
}

class Car: VehicleWithEngine(){
    override fun startEngine() {
        super.startEngine()
        println("Engine started")
    }

    override fun stopEngine() {
        super.stopEngine()
        println("Engine stopped")
    }

    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving back")
    }
}

class Bicycle: Vehicle{
    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving back")
    }
}
```

### Interface Segregation Principle
In object-oriented programming, interfaces provide layers of abstraction that simplify code and create barriers which are preventing coupling to dependencies. Classes shouldn't implement interfaces which they are not going to use.<br/>
Programming languages support multiple interface implementation. So, if there are some methods which won't be implemented by some type of classes, we should separate these interface to different interfaces.<br/><br/>

So let's think that we have an animal interface. And this interface will have methods about behaviors which animals can do. Thus, animals can use this interface to behave.
```kotlin
interface Animal{
    fun eat()
    fun sleep()
    fun fly()
}

class Cat: Animal{
    override fun eat() {
        println("Cat is eating fish")
    }

    override fun sleep() {
        println("Cat is sleeping on its owner's bed")
    }

    override fun fly() {
        TODO("Not yet implemented") // Cats can't fly
    }
}

class Bird: Animal{
    override fun eat() {
        println("Bird is eating forage")
    }

    override fun sleep() {
        println("Bird is sleeping in the nest")
    }

    override fun fly() {
        println("Bird is flying so high")
    }
}
```
As you see, some animals can't fly such as cat. When we will create classes for these animals, it will be unnecessary to implement fly method.<br/>
To fix that issue, we will create new interface called as FlyingAnimal. We will remove fly method from Animal interface and we will add it to out new interface
```kotlin
interface Animal{
    fun eat()
    fun sleep()
}

interface FlyingAnimal{
    fun fly()
}

class Cat: Animal{
    override fun eat() {
        println("Cat is eating fish")
    }

    override fun sleep() {
        println("Cat is sleeping on its owner's bed")
    }
}

class Bird: Animal, FlyingAnimal{
    override fun eat() {
        println("Bird is eating forage")
    }

    override fun sleep() {
        println("Bird is sleeping in the nest")
    }

    override fun fly() {
        println("Bird is flying so high")
    }
}
```
<b>Note: </b>If we would like to we can implement Animal interface in FlyingAnimal interface. So, we won't need to implement two interfaces for classes which animals can fly such as Bird.

### Dependency Inversion Principle
Dependency Inversion Principle tells us about the coupling between the different classes or modules.<br/>
Higher level classes should not be dependent to lower level classes. Both should be dependent to abstractions. It is based on removing the dependency with the interface.<br/>
The dependence of a class or method on other classes that use it should be minimized. Changes made in the child classes should not affect parent classes.<br/><br/>
Let's think that we need to develop a mobile application for both Android and iOS. To do that, we need an Android Developer and an iOS Developer. These classes will have a method to develop a mobile application by using their own platform and programming language.
```kotlin
class AndroidDeveloper{
    fun developMobileApp(){
        println("Developing Android Application by using Kotlin")
    }
}

class IosDeveloper{
    fun developMobileApp(){
        println("Developing iOS Application by using Swift")
    }
}

fun main(){
    val androidDeveloper = AndroidDeveloper()
    val iosDeveloper = IosDeveloper()

    androidDeveloper.developMobileApp()
    iosDeveloper.developMobileApp()
}
```
To fix the problem in here, we can create an interface called as MobileDeveloper. AndroidDeveloper and IosDeveloper classes with implement this interface.<br/>
If we want to store some different datas for each developer type, we can use this principle. Also, maybe we want to separate mobile services for Android Developers. To do that, we can create different methods for Android Developer but developing mobile application will be same for both Android and iOS developers. So, we should have an interface for same operations.
```kotlin
interface MobileDeveloper{
    fun developMobileApp()
}

class AndroidDeveloper(var mobileService: MobileServices): MobileDeveloper{
    override fun developMobileApp(){
        println("Developing Android Application by using Kotlin. " +
                "Application will work with ${mobileService.serviceName}")
    }
    enum class MobileServices(var serviceName: String){
        HMS("Huawei Mobile Services"),
        GMS("Google Mobile Services"),
        BOTH("Huawei Mobile Services and Google Mobile Services")
    }
}

class IosDeveloper: MobileDeveloper{
    override fun developMobileApp(){
        println("Developing iOS Application by using Swift")
    }
}

fun main(){
    val developers = arrayListOf(AndroidDeveloper(AndroidDeveloper.MobileServices.HMS), IosDeveloper())
    developers.forEach { developer ->
        developer.developMobileApp()
    }
}
```

## License
Design-Patterns-in-Kotlin is published under the terms of the Apache License(Version 2.0). See <a href="https://github.com/berkberberr/Design-Patterns-in-Kotlin/blob/main/LICENSE">license</a> file for details.
