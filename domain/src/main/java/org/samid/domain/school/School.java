package org.samid.domain.school;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class School {

    private String name;

    private String city;

    private String country;
}
