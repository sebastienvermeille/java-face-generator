package dev.cookiecode.facegen.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import dev.cookiecode.facegen.api.model.FaceImage;
import dev.cookiecode.facegen.api.model.ImageFormat;
import java.lang.reflect.Type;

/**
 * @author Sebastien Vermeille
 */
public class FaceImageDeserializer implements JsonDeserializer<FaceImage> {

  @Override
  public FaceImage deserialize(final JsonElement json, final Type typeOfT,
      final JsonDeserializationContext context) throws JsonParseException {
    final JsonObject jsonObject = json.getAsJsonObject();

    final var props = jsonObject.entrySet();

    assert(props.size() == 1);

    ImageFormat format = null;
    String url = "";

    var p = props.stream().findFirst().orElseThrow(IllegalArgumentException::new);
      format = ImageFormat.of(p.getKey());
      url = p.getValue().getAsString();

    return new FaceImage(format, url);
  }
}
