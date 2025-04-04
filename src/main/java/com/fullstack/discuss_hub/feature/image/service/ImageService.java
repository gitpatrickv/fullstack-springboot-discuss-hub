package com.fullstack.discuss_hub.feature.image.service;

import java.io.IOException;

public interface ImageService {
    byte[] getImages(String filename) throws IOException;
}
