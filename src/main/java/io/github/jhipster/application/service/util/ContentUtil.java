package io.github.jhipster.application.service.util;

import io.github.jhipster.application.domain.Content;
import io.github.jhipster.application.service.dto.ContentDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class ContentUtil {

    private ContentUtil() {
    }

    public static List<ContentDTO> contentsToContentDTOs(List<Content> contents) {
        return contents.stream()
            .map(content -> new ContentDTO(content.getId(), content.getFileName(), content.getFileType()))
            .collect(Collectors.toList());
    }
}
