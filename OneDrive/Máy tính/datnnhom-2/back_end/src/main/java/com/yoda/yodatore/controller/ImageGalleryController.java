package com.yoda.yodatore.controller;


import com.yoda.yodatore.infrastructure.request.ImageGalleryRequest;
import com.yoda.yodatore.util.CloudinaryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/image-gallery")
public class ImageGalleryController {
    @Autowired
    private CloudinaryUtils cloudinaryUtils;

    @GetMapping("/{folderName}")
    public List<Map> getImagesInFolder(@PathVariable String folderName,
                                       @RequestParam(required = false, defaultValue = "50") Integer size) {
        return cloudinaryUtils.getImagesInFolder(folderName, size);
    }

    @PostMapping
    public String uploadImage(@ModelAttribute ImageGalleryRequest request) {
        List<String> url = cloudinaryUtils.uploadMultipleImages(request.getImages(), request.getFolder());
        if (url.isEmpty())
            return "Thất bại!";
        else
            return "Thêm thành công!";
    }
}
