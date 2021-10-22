package br.com.logtech.domain.model.maps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDetails {


    @JsonProperty("geometry")
    private PlaceGeometry geometry;

    public PlaceGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(PlaceGeometry geometry) {
        this.geometry = geometry;
    }
}
