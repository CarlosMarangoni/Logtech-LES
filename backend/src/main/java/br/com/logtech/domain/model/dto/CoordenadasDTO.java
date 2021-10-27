package br.com.logtech.domain.model.dto;

public class CoordenadasDTO {

    private String latitude;

    private String longitude;

    public CoordenadasDTO() {
    }

    public CoordenadasDTO(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
