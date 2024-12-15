package org.samid.infrastructure.rest;

import lombok.Builder;

@Builder
public record SchoolResponse(String name,
                             String city,
                             String country
                             ) {
}
