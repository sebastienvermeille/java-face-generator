package dev.cookiecode.facegen.api.model;

import java.util.List;
import lombok.Data;

/**
 * @author Sebastien Vermeille
 */
@Data
public class FaceMetaData {

  private final Float confidence;
  private final List<FaceGender> gender;
  private final List<FaceAge> age;
  private final List<FaceEthnicity> ethnicity;
  private final List<FaceEyeColor> eyeColor;
  private final List<FaceHairColor> hairColor;
  private final List<FaceHairLength> hairLength;
  private final List<FaceEmotion> emotion;


}
