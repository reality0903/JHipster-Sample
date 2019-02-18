package io.github.jhipster.application.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;

public class FileException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public FileException(String defaultMessage) {
        throw new RuntimeException(defaultMessage);
    }
}
