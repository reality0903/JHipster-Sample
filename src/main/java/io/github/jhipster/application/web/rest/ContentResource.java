package io.github.jhipster.application.web.rest;


import io.github.jhipster.application.service.ContentService;
import io.github.jhipster.application.service.dto.ContentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * REST controller for getting and saving files.
 */
@RestController
@RequestMapping("/api/content")
public class ContentResource {

    private final ContentService contentService;

    @Autowired
    public ContentResource(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ContentDTO>> getFiles() {
        return ResponseEntity.ok(contentService.getContents());
    }

    @PostMapping("/uploadFile")
    @ResponseStatus(HttpStatus.OK)
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        contentService.saveFile(file);
    }
}
