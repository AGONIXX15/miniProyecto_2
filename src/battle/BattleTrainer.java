package battle;

import models.Trainer;
import models.pokemon.Pokemon;
//import view.PokemonMenu;

import java.util.Scanner;

public class BattleTrainer {

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
            System.out.println( trainer.getNameTrainer() + " Escoje un pokemon de tu equipo para comenzar a luchar: ");
            //PokemonMenu.showAllPokemonsAlive(trainer.team);
            System.out.println(trainer.getNameTrainer() + " Escoje un pokemon de tu equipo para comenzar a luchar: ");
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
            System.out.println("A LUCHAAAAAR!!");


            BattlePokemon battlePokemon = new BattlePokemon(pokemon1, pokemon2, player1, player2);

            battlePokemon.combat();

        }

        if (trainerHasLost(player1)){
            System.out.printf("%s Perdio la batalla pokemon!\n", player1.getNameTrainer());
        } else {
            System.out.printf("%s Gano la batalla pokemonn!", player1.getNameTrainer());
        }

        if (trainerHasLost(player2)){
            System.out.printf("%s Perdio la batalla pokemon!\n", player2.getNameTrainer());
        } else {
            System.out.printf("%s Gano la batalla pokemonn!", player2.getNameTrainer());
        }
    }
}
