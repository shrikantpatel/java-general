package com.shri.general.java17.sealed;

/**
 The final modifier on a class doesn’t allow anyone to extend it. What about when we want to extend a class but only allow it for some classes?

 We are back at our car dealership business. We are so proud of our algorithm for calculating prices that we want to expose it. We don’t want anyone using our Vehicle representation, though. It is valid just for our business. We can see a bit of a problem here. We need to expose class but constrain it also.

 This is where Java 17 comes into play with sealed classes. The sealed class allows us to make class effectively final for everyone except explicitly mentioned classes.

 public sealed class Vehicle permits Bicycle, Car {...}
 We added a sealed modifier to our Vehicle class, and we had to add the permits keyword with a list of classes that we allow to extend it. After this change, we are still getting errors from the compiler.

 There is one more thing that we need to do here.

 We need to add final, sealed, or non-sealed modifiers to classes that will extend our class.

 public final class Bicycle extends Vehicle {...}

 */
public sealed class Vehicle permits Bicycle {
}
