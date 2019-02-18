package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, String> {
}
