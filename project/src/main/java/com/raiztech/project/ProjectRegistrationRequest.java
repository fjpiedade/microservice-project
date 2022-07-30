package com.raiztech.project;

import java.time.LocalDate;

public record ProjectRegistrationRequest(
        String name,
        String description,
        String link,
        String image
) {
}
