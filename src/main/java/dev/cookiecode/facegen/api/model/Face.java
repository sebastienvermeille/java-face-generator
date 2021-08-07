package dev.cookiecode.facegen.api.model;

import java.util.ArrayList;
import java.util.EnumMap;
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
    final var urlsMap = new EnumMap<ImageFormat, String>(ImageFormat.class);

    for (final var url : urls) {
      urlsMap.put(url.getFormat(), url.getUrl());
    }
    return urlsMap;
  }

}
