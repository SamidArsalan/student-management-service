package org.samid.infrastructure.repository;

public interface Mapper <D,E> {

    E toEntity(D domain);

    D toDomain(E entity);

}
