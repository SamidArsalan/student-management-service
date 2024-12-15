package org.samid.domain.common.enrich;

import java.util.List;

public class CompositeEnricher<T> implements Enricher<T> {

    private List<Enricher<T>> enrichers;

    @Override
    public T enrich(T item) {
        var result = item;
        for(Enricher<T> enricher : enrichers) {
            result = enricher.enrich(result);
        }
        return result;
    }

}
