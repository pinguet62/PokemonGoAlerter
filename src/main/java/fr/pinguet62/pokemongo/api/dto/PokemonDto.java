package fr.pinguet62.pokemongo.api.dto;

import java.util.Date;
import java.util.Objects;

public class PokemonDto {

    private String data;

    private Long expiration_time;

    private Integer id;

    private Boolean is_alive;

    private Double latitude;

    private Double longitude;

    private Integer pokemonId;

    private String uid;

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof PokemonDto))
            return false;
        PokemonDto other = (PokemonDto) obj;
        return Objects.equals(pokemonId, other.pokemonId) && Objects.equals(latitude, other.latitude)
                && Objects.equals(longitude, other.longitude);
    }

    public String getData() {
        return data;
    }

    public Date getExpiration_time() {
        return new Date(expiration_time * 1_000);
    }

    public Integer getId() {
        return id;
    }

    public Boolean getIs_alive() {
        return is_alive;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public String getUid() {
        return uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonId, latitude, longitude);
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIs_alive(Boolean is_alive) {
        this.is_alive = is_alive;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}