package oc.p.chapters._7_Concurrency.usingConcurrentCollections.ocpCollections;

import java.util.Collection;
import java.util.Collections;

import static oc.p.chapters._7_Concurrency.usingConcurrentCollections.ocpCollections.Ocp.TREE_SET;

class Collection_ {

    Collection <Ocp> collection = Collections.synchronizedCollection(TREE_SET);
}
