package oc.p.chapters._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation;

/**
 * When you deserialize an object,
 * the constructor of the serialized class is not called.
 * In fact, Java calls the first no-arg constructor
 * for the first NONSERIALIZABLE parent class,
 * skipping the constructors of any serialized
 * class in between. Furthermore, any static
 * variables or default initializations are ignored.
 */
class Info {
}
