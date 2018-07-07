package oc.p.chapters._9_NIO2.introducingNIO2;

/**
 * Path is an interface and not a class is because a file or a file
 * is considered a directory system–dependent task in NIO.2.
 * When you obtain a Path object from the default directory system in NIO.2,
 * the JVM gives you back an object that unlike
 * java.io.File transparently handles system-specific details
 * for the current platform
 *
 * If you didn’t use the factory pattern to create an dbInstance,
 * you would have to know what the underlying directory system was and use
 * this in every create method
 */
class CreatingInstancesWithFactoryAndHelperClasses {


}

