package digital.library.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record User (
        Integer id,
        String name,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("member_since") LocalDate memberSince,
        @JsonProperty("member_till") LocalDate memberTill,
        String gender
) {}
