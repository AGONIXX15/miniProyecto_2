package models.pokemon;

import models.pokemon.utils.Attack;
import models.pokemon.utils.TypePokemon;
import java.util.Arrays;

public class Pokemon {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[91m";
    public static final String WHITE_BOLD = "\u001B[1;97m";
    public static final String GREEN = "\u001B[32m";

    private String name;
    private TypePokemon type;
    private Attack[] attacks;
    private int healthMax;
    private int health;
    public String imagenUrl;




    /**
     * constructor de la clase abstracta pokemon
     *
     * @param name    nombre del pokemon
     * @param healthMax  salud maxima del pokemon
     * @param type    tipo del pokemon
     * @param attacks ataques del pokemon
     */
    public Pokemon(String name, int healthMax, TypePokemon type, Attack[] attacks, String imagenUrl) {
        this.name = name;
        this.healthMax = healthMax;
        this.health = healthMax;
        this.type = type;
        this.attacks = attacks;
        this.imagenUrl = imagenUrl;
    }


    public String getImagenUrl() {
        return imagenUrl;
    }

    public String getName() {
        return name;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(int healthMax) {
        this.healthMax = healthMax;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypePokemon getType() {
        return type;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Attack[] getAttacks() {
        return attacks;
    }


    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }

    public void setType(TypePokemon type) {
        this.type = type;
    }
    public String showInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre = ").append(name)
                .append(", Tipo = ").append(type)
                .append(", Salud = ").append(health);


        /*for (Attack attack : attacks) {
            if (attack != null) {
                sb.append(RED + "\n  • "+WHITE_BOLD).append(attack.getName())
                        .append(" (").append(attack.getPower())
                        .append(" de poder, tipo: ").append(attack.getTypeDamage()).append(")");
            }
         */


        return sb.toString();


    }
    public void cure(int health){
        this.health = Math.min(this.health + health, this.healthMax);
        System.out.printf(GREEN+"%s"+WHITE_BOLD + " Ha sido curado hasta %d\n"+RESET, this.name, this.health);
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health-damage);
        System.out.printf(GREEN+"%s"+WHITE_BOLD + " Recibio %d de daño \n"+RESET, name, damage);
        System.out.printf(GREEN+"%s"+WHITE_BOLD + " Tiene una vida de %d/%d \n"+RESET, name, health, healthMax);
        if (health == 0){
            System.out.printf(GREEN + "%s"+WHITE_BOLD + " Ha sido derrotado...\n"+RESET, name);
        }
    }

    public boolean hasAdvantage(Pokemon enemy){
        for(String type: this.type.strong){
            if(type.equals(enemy.type.toString())){
                return true;
            }
        }
        return false;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void makeDamage(Pokemon enemy, Attack attack){
        float advantage = (hasAdvantage(enemy)) ? 1.3f : 1;
        if(advantage > 1){
            System.out.println(WHITE_BOLD + "El ataque ha sido efectivo!!"+RESET);
        }
        int damage = (int) (advantage * attack.getPower());
        System.out.printf(WHITE_BOLD + "%s realizo %s hacia %s con un daño de %d\n",name, attack.getName(), enemy.getName(),damage);
        enemy.takeDamage(damage);
    }

    @Override
    public String toString() {
        return
                "Nombre = " + name +
                        ", Tipo = " + type +
                        ", Salud = " + health ;
    }

    public Pokemon clonar(){
        return new Pokemon(name, healthMax, type, attacks,imagenUrl);
    }
}






