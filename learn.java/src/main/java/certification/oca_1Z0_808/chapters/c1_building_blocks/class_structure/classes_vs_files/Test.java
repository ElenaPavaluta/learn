package chapters.c1_building_blocks.class_structure.classes_vs_files;

/*
 * In the Test.jva file:
 * - only class Test can be public
 * - there's no compile error if this class doesn't exist at all, but no other class existing in it can be public
 */
//class Test {
//
//}

class tT2 {

}

interface T3 {

}

abstract class T4 {

}

final class T5 {

}

/*
 * Compile error: llegal modifier for the class T6; only public, abstract &
 * final are permitted
 */
// protected class T6{}

/*
 * Compiler error: The name of the file has to match the name of the public
 * class
 */
// public class T7{}
// public class test{}

