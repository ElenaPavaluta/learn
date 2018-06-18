package oc.p.chapters._9_NIO2.presentingNewStreamMethods.walkingADirectory.avoidingCircularPaths;

/**
 * walk() will not traverse symbolic links by default
 *
 * Change this behaviour by using FOLLOW_LINKS option as a vararg to the walk()
 *
 * It is recommended to specify an appropriate depth limit
 *
 * When this option is used, the walk() method will track the paths it has visited,
 * throwing a FileSystemLoopException if a cycle is detected
 */
class Avoid {
}
