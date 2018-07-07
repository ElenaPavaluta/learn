package oc.p.chapters._2_PatternsAndPrinciples.workingWithDesignPatterns.creatingImmutableObjects;

/*

 1. Use a constructor to set all properties of the object.
 2. Mark all of the dbInstance variables private and final .
 3. Don’t define any setter methods.
 4. Don’t allow referenced mutable objects to be modified or accessed directly.
 5. Prevent methods from being overridden :
 	- final class or final methods
 	or
 	- private constructor + factory pattern

 */
