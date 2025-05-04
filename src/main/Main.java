package main;
import models.Trainer;
import models.pokemon.Pokemon;
import models.pokemon.utils.Attack;
import models.pokemon.utils.TypeDamage;
import models.pokemon.utils.TypePokemon;
import utils.PokemonFactory;
//import view.Menu;


public class
Main {
    public static void main(String[] args) {
        PokemonFactory pokemonFactory = new PokemonFactory();


Trainer trainer = new Trainer("sebas",pokemonFactory.loadAvailablePokemons());
trainer.randomTeam();
trainer.getTeam();
    }
}

