package oc.a.chapters.c5_class_design.understantingPolymorfism.virtualMethods;

/**
 * A virtual method is a method in which the specific implementation is not
 * determined until runtime. 
 * 
 * In fact, all 
 * 
 * non-final, 
 * 
 * nonstatic, 
 * 
 * and non-private
 * 
 * Java interfaceMethods are considered virtual interfaceMethods, since any of them can be
 * overridden at runtime. What makes a virtual method special in Java is that if
 * you call a method on an object that overrides a method, you get the
 * overridden method, even if the call to the method is on a parent reference or
 * within the parent class.
 *
 */
class VirtualMethods {

}
