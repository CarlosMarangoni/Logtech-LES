package br.com.logtech.domain.model.maps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDetailsResponse {

    @JsonProperty("results")
    private PlaceDetails[] results;

    @JsonProperty("status")
    private String status;

    public PlaceDetails[] getResults() {
        return results;
    }

    public void setResults(PlaceDetails[] results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
