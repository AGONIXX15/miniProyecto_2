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
                        Attack.FLAMETHROWER, Attack.FIRE_BLAST, Attack.TACKLE, Attack.DOUBLE_KICK
                }),
                new Pokemon("Squirtle", 100, TypePokemon.AGUA, new Attack[]{
                        Attack.WATER_GUN, Attack.TACKLE, Attack.DOUBLE_KICK, Attack.QUICK_ATTACK
                }),
                new Pokemon("Bulbasaur", 100, TypePokemon.PLANTA, new Attack[]{
                        Attack.VINE_WHIP, Attack.SOLAR_BEAM, Attack.RAZOR_LEAF, Attack.TACKLE
                }),
                new Pokemon("Pikachu", 90, TypePokemon.ELECTRICO, new Attack[]{
                        Attack.THUNDERBOLT, Attack.THUNDER, Attack.SHOCK_WAVE, Attack.QUICK_ATTACK
                }),
                new Pokemon("Arcanine", 110, TypePokemon.FUEGO, new Attack[]{
                        Attack.FIRE_BLAST, Attack.FLAMETHROWER, Attack.QUICK_ATTACK, Attack.TACKLE
                }),
                new Pokemon("Scyther", 100, TypePokemon.PLANTA, new Attack[]{
                        Attack.LEAF_BLADE, Attack.SLASH, Attack.DOUBLE_KICK, Attack.TACKLE
                }),
                new Pokemon("Electabuzz", 95, TypePokemon.ELECTRICO, new Attack[]{
                        Attack.THUNDERBOLT, Attack.THUNDER, Attack.SHOCK_WAVE, Attack.QUICK_ATTACK
                })

        };
    }

    public static Pokemon createPokemonFromZero() {
        Scanner sc = new Scanner(System.in);
        System.out.print(WHITE_BOLD + "Nombre del Pokémon: " + RESET);
        String namePokemon = sc.nextLine();

        System.out.print(WHITE_BOLD + "Salud: " + RESET);
        int salud = Integer.parseInt(sc.nextLine());

        System.out.println(WHITE_BOLD + "Tipo de Pokémon:"+ RESET);
        for (TypePokemon type : TypePokemon.values()) {
            System.out.println(WHITE_BOLD + type);
        }
        System.out.print(WHITE_BOLD + "Elige el tipo: " + RESET);
        TypePokemon typepokemon = TypePokemon.valueOf(sc.nextLine().toUpperCase());

        Attack[] attacks = new Attack[4];
        System.out.println(WHITE_BOLD + "Crea los ataques para tu pokemon "+ GREEN +namePokemon+RESET+"(4 ataques):");
        for (int i = 0; i < attacks.length; i++) {
            System.out.println(WHITE_BOLD + "----- Ataque " + (i + 1) + " -----" + RESET);
            System.out.print(WHITE_BOLD + "Nombre del ataque: " + RESET);
            String nameAttack = sc.nextLine();

            System.out.print(WHITE_BOLD + "Poder del ataque: " + RESET  );
            short power = (short) Integer.parseInt(sc.nextLine());


            System.out.println(WHITE_BOLD + "Tipo de daño del ataque:" + RESET);
            TypeDamage[] type = TypeDamage.values();
            for (int j = 0; j < type.length; j++) {
                System.out.println((j + 1) + ". " + type[j]);
            }
            System.out.print(WHITE_BOLD + "Elige una opción (número): " + RESET);
            int optionType = Integer.parseInt(sc.nextLine());
            TypeDamage typeAttack = type[optionType - 1];

            attacks[i] = new Attack(nameAttack, power, typeAttack);
        }


        return new Pokemon(namePokemon, salud, typepokemon, attacks);
    }



}
