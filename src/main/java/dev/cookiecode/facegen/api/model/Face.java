package dev.cookiecode.facegen.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * @author Sebastien Vermeille
 */
@Data
public class Face {

  private final String id;
  private final String version;
  private final List<FaceImage> urls = new ArrayList<>();
  private final FaceMetaData meta;

  public Map<ImageFormat, String> getUrls() {
    final Map<ImageFormat, String> urlsMap = new HashMap<>();

    for (final var url : urls) {
      urlsMap.put(url.getFormat(), url.getUrl());
    }

    return urlsMap;
  }

}
