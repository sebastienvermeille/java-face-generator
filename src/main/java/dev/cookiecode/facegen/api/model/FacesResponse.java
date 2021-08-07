package dev.cookiecode.facegen.api.model;

import java.util.List;
import lombok.Data;

/**
 * @author Sebastien Vermeille
 */
@Data
public class FacesResponse {

  private List<Face> faces;
  private Long total;
 
}
