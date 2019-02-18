package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.Content;
import io.github.jhipster.application.repository.ContentRepository;
import io.github.jhipster.application.service.dto.ContentDTO;
import io.github.jhipster.application.service.util.ContentUtil;
import io.github.jhipster.application.web.rest.errors.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public List<ContentDTO> getContents() {
        List<Content> contents = contentRepository.findAll();
        return ContentUtil.contentsToContentDTOs(contents);
    }

    public void saveFile(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getName();
            String fileType = multipartFile.getContentType();
            byte[] fileInBytes = multipartFile.getBytes();
            Content content = new Content(fileName, fileType, fileInBytes);
            contentRepository.save(content);
        } catch (IOException e) {
            throw new FileException("Cannot save file");
        }
    }
}
