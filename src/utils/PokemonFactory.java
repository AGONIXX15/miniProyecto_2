package utils;

import models.pokemon.Pokemon;
import models.pokemon.utils.Attack;
import models.pokemon.utils.TypeDamage;
import models.pokemon.utils.TypePokemon;
import java.util.Scanner;


public class PokemonFactory {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[91m";
    public static final String CYAN_BOLD = "\u001B[1;96m";
    public static final String WHITE_BOLD = "\u001B[1;97m";
    public static final String GREEN = "\u001B[32m";
    //metodo que crea y devuelve todos los pokemones predefinidos disponibles
    public static Pokemon[] loadAvailablePokemons() {
        return new Pokemon[]{
                new Pokemon("Charmander", 100, TypePokemon.FUEGO, new Attack[]{
                        AttackFactory.FLAMETHROWER, AttackFactory.FIRE_BLAST, AttackFactory.TACKLE, AttackFactory.DOUBLE_KICK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png"),

                new Pokemon("Squirtle", 100, TypePokemon.AGUA, new Attack[]{
                        AttackFactory.WATER_GUN, AttackFactory.TACKLE, AttackFactory.DOUBLE_KICK, AttackFactory.QUICK_ATTACK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/7.png"),

                new Pokemon("Bulbasaur", 100, TypePokemon.PLANTA, new Attack[]{
                        AttackFactory.VINE_WHIP, AttackFactory.SOLAR_BEAM, AttackFactory.RAZOR_LEAF, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"),

                new Pokemon("Pikachu", 90, TypePokemon.ELECTRICO, new Attack[]{
                        AttackFactory.THUNDERBOLT, AttackFactory.THUNDER, AttackFactory.SHOCK_WAVE, AttackFactory.QUICK_ATTACK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"),

                new Pokemon("Arcanine", 110, TypePokemon.FUEGO, new Attack[]{
                        AttackFactory.FIRE_BLAST, AttackFactory.FLAMETHROWER, AttackFactory.QUICK_ATTACK, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/59.png"),

                new Pokemon("Scyther", 100, TypePokemon.PLANTA, new Attack[]{
                        AttackFactory.LEAF_BLADE, AttackFactory.SLASH, AttackFactory.DOUBLE_KICK, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/123.png"),

                new Pokemon("Electabuzz", 95, TypePokemon.ELECTRICO, new Attack[]{
                        AttackFactory.THUNDERBOLT, AttackFactory.THUNDER, AttackFactory.SHOCK_WAVE, AttackFactory.QUICK_ATTACK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/125.png"),

                new Pokemon("Vulpix", 90, TypePokemon.FUEGO, new Attack[]{
                        AttackFactory.FLAMETHROWER, AttackFactory.FIRE_BLAST, AttackFactory.TACKLE, AttackFactory.QUICK_ATTACK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/37.png"),

                new Pokemon("Magmar", 105, TypePokemon.FUEGO, new Attack[]{
                        AttackFactory.FIRE_BLAST, AttackFactory.FLAMETHROWER, AttackFactory.SLASH, AttackFactory.QUICK_ATTACK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/126.png"),

                new Pokemon("Psyduck", 95, TypePokemon.AGUA, new Attack[]{
                        AttackFactory.WATER_GUN, AttackFactory.QUICK_ATTACK, AttackFactory.TACKLE, AttackFactory.DOUBLE_KICK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/54.png"),

                new Pokemon("Seel", 100, TypePokemon.AGUA, new Attack[]{
                        AttackFactory.WATER_GUN, AttackFactory.SLASH, AttackFactory.QUICK_ATTACK, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/86.png"),

                new Pokemon("Bellsprout", 85, TypePokemon.PLANTA, new Attack[]{
                        AttackFactory.VINE_WHIP, AttackFactory.SOLAR_BEAM, AttackFactory.TACKLE, AttackFactory.RAZOR_LEAF
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/69.png"),

                new Pokemon("Exeggcute", 95, TypePokemon.PLANTA, new Attack[]{
                        AttackFactory.RAZOR_LEAF, AttackFactory.VINE_WHIP, AttackFactory.SOLAR_BEAM, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/102.png"),

                new Pokemon("Magnemite", 90, TypePokemon.ELECTRICO, new Attack[]{
                        AttackFactory.THUNDERBOLT, AttackFactory.THUNDER, AttackFactory.SHOCK_WAVE, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/81.png"),

                new Pokemon("Jolteon", 110, TypePokemon.ELECTRICO, new Attack[]{
                        AttackFactory.THUNDER, AttackFactory.SHOCK_WAVE, AttackFactory.QUICK_ATTACK, AttackFactory.SLASH
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/135.png"),

                new Pokemon("Doduo", 90, TypePokemon.VOLADOR, new Attack[]{
                        AttackFactory.SLASH, AttackFactory.QUICK_ATTACK, AttackFactory.TACKLE, AttackFactory.DOUBLE_KICK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/84.png"),

                new Pokemon("Farfetch'd", 95, TypePokemon.VOLADOR, new Attack[]{
                        AttackFactory.SLASH, AttackFactory.LEAF_BLADE, AttackFactory.QUICK_ATTACK, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/83.png")};
    }}



