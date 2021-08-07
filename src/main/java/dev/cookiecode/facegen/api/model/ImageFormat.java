package dev.cookiecode.facegen.api.model;

import java.util.Arrays;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Sebastien Vermeille
 */
@RequiredArgsConstructor
@Getter
public enum ImageFormat {
  FORMAT_32_X_32("32", false),
  FORMAT_64_X_64("64", false),
  FORMAT_128_X_128("128", false),
  FORMAT_256_X_256("256", false),
  FORMAT_512_X_512("512", false),
  FORMAT_1024_X_1024("1024", false),
  // only with paid licenses format:
  FORMAT_TRANSPARENT_32_X_32("transparent_32", true),
  FORMAT_TRANSPARENT_64_X_64("transparent_64", true),
  FORMAT_TRANSPARENT_128_X_128("transparent_128", true),
  FORMAT_TRANSPARENT_256_X_256("transparent_256", true),
  FORMAT_TRANSPARENT_512_X_512("transparent_512", true),
  FORMAT_TRANSPARENT_1024_X_1024("transparent_1024", true);

  private final String restValue;
  private final boolean licenseRequired;

  public static ImageFormat of(@NonNull final String restValue) {
    return Arrays.stream(ImageFormat.values())
        .filter(imageFormat -> imageFormat.getRestValue().equalsIgnoreCase(restValue))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  @Override
  public String toString() {
    return restValue;
  }
}
