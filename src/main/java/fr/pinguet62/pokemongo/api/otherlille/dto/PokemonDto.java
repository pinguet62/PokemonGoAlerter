package fr.pinguet62.pokemongo.api.otherlille.dto;

import java.util.Date;
import java.util.List;

public class PokemonDto {

    private Integer capture_probability_1;

    private Integer capture_probability_2;

    private Integer capture_probability_3;

    private Date disappear_time;

    private String encounter_id;

    private Double height;

    private Integer individual_attack;

    private Integer individual_defense;

    private Integer individual_stamina;

    private Double iv;

    private Double latitude;

    private Double longitude;

    private Integer move_1;

    private Integer move_2;

    private Integer pokemon_id;

    private String pokemon_name;

    private String pokemon_rarity;

    private List<PokemonTypeDto> pokemon_types;

    private String spawnpoint_id;

    private Integer stamina;

    private Integer stamina_max;

    private Double weight;

    public Integer getCapture_probability_1() {
        return capture_probability_1;
    }

    public Integer getCapture_probability_2() {
        return capture_probability_2;
    }

    public Integer getCapture_probability_3() {
        return capture_probability_3;
    }

    public Date getDisappear_time() {
        return disappear_time;
    }

    public String getEncounter_id() {
        return encounter_id;
    }

    public Double getHeight() {
        return height;
    }

    public Integer getIndividual_attack() {
        return individual_attack;
    }

    public Integer getIndividual_defense() {
        return individual_defense;
    }

    public Integer getIndividual_stamina() {
        return individual_stamina;
    }

    public Double getIv() {
        return iv;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getMove_1() {
        return move_1;
    }

    public Integer getMove_2() {
        return move_2;
    }

    public Integer getPokemon_id() {
        return pokemon_id;
    }

    public String getPokemon_name() {
        return pokemon_name;
    }

    public String getPokemon_rarity() {
        return pokemon_rarity;
    }

    public List<PokemonTypeDto> getPokemon_types() {
        return pokemon_types;
    }

    public String getSpawnpoint_id() {
        return spawnpoint_id;
    }

    public Integer getStamina() {
        return stamina;
    }

    public Integer getStamina_max() {
        return stamina_max;
    }

    public Double getWeight() {
        return weight;
    }

    public void setCapture_probability_1(Integer capture_probability_1) {
        this.capture_probability_1 = capture_probability_1;
    }

    public void setCapture_probability_2(Integer capture_probability_2) {
        this.capture_probability_2 = capture_probability_2;
    }

    public void setCapture_probability_3(Integer capture_probability_3) {
        this.capture_probability_3 = capture_probability_3;
    }

    public void setDisappear_time(Date disappear_time) {
        this.disappear_time = disappear_time;
    }

    public void setEncounter_id(String encounter_id) {
        this.encounter_id = encounter_id;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setIndividual_attack(Integer individual_attack) {
        this.individual_attack = individual_attack;
    }

    public void setIndividual_defense(Integer individual_defense) {
        this.individual_defense = individual_defense;
    }

    public void setIndividual_stamina(Integer individual_stamina) {
        this.individual_stamina = individual_stamina;
    }

    public void setIv(Double iv) {
        this.iv = iv;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setMove_1(Integer move_1) {
        this.move_1 = move_1;
    }

    public void setMove_2(Integer move_2) {
        this.move_2 = move_2;
    }

    public void setPokemon_id(Integer pokemon_id) {
        this.pokemon_id = pokemon_id;
    }

    public void setPokemon_name(String pokemon_name) {
        this.pokemon_name = pokemon_name;
    }

    public void setPokemon_rarity(String pokemon_rarity) {
        this.pokemon_rarity = pokemon_rarity;
    }

    public void setPokemon_types(List<PokemonTypeDto> pokemon_types) {
        this.pokemon_types = pokemon_types;
    }

    public void setSpawnpoint_id(String spawnpoint_id) {
        this.spawnpoint_id = spawnpoint_id;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public void setStamina_max(Integer stamina_max) {
        this.stamina_max = stamina_max;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}