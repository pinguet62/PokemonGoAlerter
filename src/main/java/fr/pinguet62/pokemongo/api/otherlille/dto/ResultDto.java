package fr.pinguet62.pokemongo.api.otherlille.dto;

import java.util.List;

public class ResultDto {

    private List<PokemonDto> pokemons;

    private List<PokestopDto> pokestops;

    public List<PokemonDto> getPokemons() {
        return pokemons;
    }

    public List<PokestopDto> getPokestops() {
        return pokestops;
    }

    public void setPokemons(List<PokemonDto> pokemons) {
        this.pokemons = pokemons;
    }

    public void setPokestops(List<PokestopDto> pokestops) {
        this.pokestops = pokestops;
    }

}