package io.github.caiovvieira.movie_review.service;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditingService implements AuditorAware {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}
