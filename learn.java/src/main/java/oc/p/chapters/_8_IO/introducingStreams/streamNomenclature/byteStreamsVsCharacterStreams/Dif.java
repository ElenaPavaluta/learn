package oc.p.chapters._8_IO.introducingStreams.streamNomenclature.byteStreamsVsCharacterStreams;

/**
 * The java.io API defines two sets of classes
 * for reading and writing streams:
 * those with
 * Stream in their name
 * and those with Reader/Writer in their name.
 *
 * 1. The stream classes are used for inputting and outputting
 * all types of binary or byte data.
 *
 * 2. The reader and writer classes are used for inputting and outputting
 * only character and String data.
 *
 * Byte stream classes can be used to input and output all types of binary data
 *
 * The advantage of using Reader/Writer classes, since these are specialized,
 * in working with Strings and Characters, is that there's no reason to worry
 * about the underlying byte encoding of the file.
 *
 * The java.io API is structured such that all of the
 * stream classes have the word InputStream or OutputStream in their name,
 * while
 * all Reader/Writer classes have either Reader or Writer in their name.
 */
class Dif {
}
