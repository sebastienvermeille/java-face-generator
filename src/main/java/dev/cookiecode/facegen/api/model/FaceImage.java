package dev.cookiecode.facegen.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sebastien Vermeille
 */
@Getter
@Setter
@AllArgsConstructor
public class FaceImage {

  private final ImageFormat format;
  private final String url;

}
