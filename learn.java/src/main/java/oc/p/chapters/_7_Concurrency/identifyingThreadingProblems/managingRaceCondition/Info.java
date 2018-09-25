package oc.p.chapters._7_Concurrency.identifyingThreadingProblems.managingRaceCondition;

/**
 * Race conditions tend to appear in highly concurrent applications.
 * As a software system grows and more users are added,
 * they tend to appear more frequently.
 * One solution is to use a monitor to synchronize on the relevant overlapping task.
 * In the previous example, the relevant task is the method that determines
 * whether an account username is in use and reserves it in the system
 * if it is available.
 * We could also use singletons to coordinate access to shared resources.
 */
class Info {
}
