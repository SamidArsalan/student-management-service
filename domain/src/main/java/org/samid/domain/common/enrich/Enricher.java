package org.samid.domain.common.enrich;

public interface Enricher<T> {
    T enrich(T item);
}
