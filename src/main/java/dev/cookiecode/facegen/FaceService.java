package dev.cookiecode.facegen;

import dev.cookiecode.facegen.api.model.FaceBuilder;
import dev.cookiecode.facegen.api.model.FacesResponse;
import dev.cookiecode.facegen.api.rest.ApiClient;
import dev.cookiecode.facegen.api.rest.FaceResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;

/**
 * @author Sebastien Vermeille
 */
@RequiredArgsConstructor
public class FaceService {

  private final String apiKey;
  private final boolean paidLicense;

  public FacesResponse generateFaces(@NonNull final FaceBuilder faceBuilder, final int quantity) {
    final var syncCall = ApiClient.createService(FaceResource.class, apiKey)
        .getFace(1,
            faceBuilder.getConfidence(),
            faceBuilder.getEmotion(),
            faceBuilder.getGender(),
            faceBuilder.getAge(),
            faceBuilder.getEthnicity(),
            faceBuilder.getEyeColor(),
            faceBuilder.getHairColor(),
            faceBuilder.getHairLength(),
            null,
            1,
            quantity
        );

    try {
      final Response<FacesResponse> response = syncCall.execute();
      final var facesResponse = response.body();
      return facesResponse;
    } catch (final Exception ex) {
      System.out.printf("OUPS");
      ex.printStackTrace();
    }
    return null;
  }

  public FacesResponse generateFace(@NonNull final FaceBuilder faceBuilder) {

    return generateFaces(faceBuilder, 1);
  }
}
