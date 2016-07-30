package fr.pinguet62.pokemongo.api.dto;

import java.util.List;

public class ResultDto {

	private List<PokemonDto> pokemon;

	private String status;

	public List<PokemonDto> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<PokemonDto> pokemon) {
		this.pokemon = pokemon;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}