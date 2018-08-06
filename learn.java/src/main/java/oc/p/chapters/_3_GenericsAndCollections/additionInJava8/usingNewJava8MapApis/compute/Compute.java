package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute;

/**
 *
 * default V	compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
 * Attempts to compute a mapping for the specified key and its current mapped value (or null
 * if there is no current mapping).
 *
 * default V	computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
 * If the specified key is not already associated with a value (or is mapped to null),
 * attempts to compute its value using the given mapping function and enters it into this map unless null.
 *
 * default V	computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
 * If the value for the specified key is present and non-null,
 * attempts to compute a new mapping given the key and its current mapped value.
 */

