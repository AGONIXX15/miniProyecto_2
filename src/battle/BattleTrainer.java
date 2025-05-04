package battle;

import models.Trainer;
import models.pokemon.Pokemon;
//import view.PokemonMenu;

import java.util.Scanner;

public class BattleTrainer {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[91m";
    public static final String CYAN_BOLD = "\u001B[1;96m";
    public static final String WHITE_BOLD = "\u001B[1;97m";
    public static final String GREEN = "\u001B[32m";

    private Trainer player1, player2;

    public BattleTrainer(Trainer player1, Trainer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }



    public boolean trainerHasLost(Trainer trainer) {
        for(Pokemon pokemon: trainer.team){
            if(pokemon.isAlive()){
                return false;
            }
        }
        return true;
    }

    public Pokemon choosePokemon(Trainer trainer) {
        Scanner sc = new Scanner(System.in);
        boolean condition;
        int index;
        do {
           // PokemonMenu.showAllPokemonsAlive(trainer.team);
            System.out.println(GREEN + trainer.getNameTrainer() + WHITE_BOLD + " Escoje un pokemon de tu equipo para comenzar a luchar: "+ RESET);
            index = Integer.parseInt(sc.nextLine())-1;
            condition = !(index >= 0 && index < trainer.team.length && trainer.team[index].isAlive());
            if(!trainer.team[index].isAlive()){
                System.out.println("escoje un pokemon que este vivo");
            }
        }while(condition);
        Pokemon pokemon = trainer.team[index];

        return pokemon;
    }

    public void combat() {

        while (!trainerHasLost(player1) && !trainerHasLost(player2)) {
            Pokemon pokemon1 = choosePokemon(player1);
            Pokemon pokemon2 = choosePokemon(player2);
            System.out.println(RED+"A LUCHAAAAAR!!"+RESET);


            BattlePokemon battlePokemon = new BattlePokemon(pokemon1, pokemon2, player1, player2);

            battlePokemon.combat();

        }

        if (trainerHasLost(player1)){
            System.out.printf(RED + "%s Perdio la batalla pokemon!\n"+RESET, player1.getNameTrainer());
        } else {
            System.out.printf(CYAN_BOLD + "%s Gano la batalla pokemonn!"+RESET, player1.getNameTrainer());
        }

        if (trainerHasLost(player2)){
            System.out.printf(RED + "%s Perdio la batalla pokemon!\n"+RESET, player2.getNameTrainer());
        } else {
            System.out.printf(CYAN_BOLD + "%s Gano la batalla pokemonn!"+RESET, player2.getNameTrainer());
        }
    }
}
