package oc.p.chapters._1_AdvancedClassDesign.usingInstanceof;

/**
 * The compilation check only applies when instanceof is called on a class. When checking
 * whether an object is an instanceof an interface, Java waits until runtime to do the
 * check. The reason is that a subclass could implement that interface and the compiler
 * wouldn’t know it.
 */
class Animal
{
}
