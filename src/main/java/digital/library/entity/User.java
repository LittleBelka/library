package digital.library.entity;

import java.time.LocalDate;

public record User(
        Integer id,
        String name,
        String firstName,
        LocalDate memberSince,
        LocalDate memberTill,
        String gender
) {}
