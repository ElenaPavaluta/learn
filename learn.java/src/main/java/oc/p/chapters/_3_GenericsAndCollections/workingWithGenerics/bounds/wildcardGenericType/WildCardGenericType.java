package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType;

/**
 *
 * Unbounded wildcard:  ? -> List<?> l =new ArrayList<String>();
 *
 *
 * Wildcard with an upper bound: ? extends dbType -> List<? extends Exception> l =new ArrayList<RuntimeException>();
 *
 *
 * Wildcard with a lower bound:  ? super dbType -> List<? super Exception> l =new ArrayList<Object>();
 *
 */
