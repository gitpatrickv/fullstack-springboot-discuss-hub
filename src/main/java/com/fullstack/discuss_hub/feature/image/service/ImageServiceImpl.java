package com.fullstack.discuss_hub.feature.image.service;

import com.fullstack.discuss_hub.common.util.StrUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
@Service
public class ImageServiceImpl implements ImageService{
    @Override
    public byte[] getImages(String filename) throws IOException {
        return Files.readAllBytes(Paths.get(StrUtil.PHOTO_DIRECTORY + filename));
    }

}
