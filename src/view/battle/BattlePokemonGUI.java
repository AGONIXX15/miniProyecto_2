package view.battle;
import battle.BattlePokemon;
import battle.BattleTrainer;
import models.Trainer;
import models.pokemon.Pokemon;
import models.pokemon.utils.Attack;
import models.pokemon.utils.TypePokemon;
import utils.AttackFactory;

import javax.swing.*;
import java.awt.*;

public class BattlePokemonGUI extends JFrame {
    public Trainer trainer1, trainer2;
    public Pokemon pokemon1, pokemon2;
    private CardLayout cards;
    private JPanel p1;
    private JLayeredPane mainPanel;
    private PokemonStatusBar bar1, bar2;
    private PokemonAttacksButtons attacksButtons;
    private MessageBattle messageBattle;


    private static BattlePokemonGUI instance;
    private boolean trainer1Active;
    private int turno;


    public static BattlePokemonGUI getInstance() {
        return instance;
    }

    // tratar de acomodar las posiciones para windows
    public BattlePokemonGUI(Trainer trainer1, Trainer trainer2) {
        turno = 0;
        instance = this;
        trainer1Active = true;
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;

        messageBattle = new MessageBattle();
        messageBattle.getCard().show(messageBattle, "vacio");
        // acomodar esto
        messageBattle.setBounds(1000,800,200,200);

        mainPanel = new JLayeredPane();
        mainPanel.setSize(1000, 1000);

        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(500, 500));
        cards = new CardLayout();
        p1.setLayout(cards);
        p1.add(new ShowPokemons(trainer1), "trainer1");
        p1.add(new ShowPokemons(trainer2), "trainer2");
        p1.add(new JPanel(), "vacio");
        cards.show(p1, "trainer1");
        p1.setBounds(100, 100, 500, 500);
        p1.setVisible(true);

        mainPanel.add(p1, Integer.valueOf(1));
        mainPanel.add(messageBattle, Integer.valueOf(1));
        setVisible(true);
        setLayout(null);
        setTitle("Battle Pokemon");
        setContentPane(mainPanel);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void chooseAgain(){
        System.out.println("por si acaso");
        removeThings();
        mainPanel.remove(attacksButtons);
        pokemon1 = null;
        pokemon2 = null;
        cards.show(p1, "trainer1");
    }


    public void chooseTrainerPokemon() {
        if (!trainer1Active){
            pokemon2 = trainer2.getTeamArray()[((ShowPokemons) p1.getComponent(1)).getChoose()];
            System.out.println(pokemon2);
            trainer1Active = true;
            cards.show(p1, "vacio");
            turno = (pokemon1.getHealthMax() > pokemon2.getHealthMax()) ? 1 : 0;
            setThings();
            return;
        }
        pokemon1 = trainer1.getTeamArray()[((ShowPokemons)p1.getComponent(0)).getChoose()];
        System.out.println(pokemon1);
        cards.show(p1, "trainer2");
        trainer1Active = false;
    }

    public void pokemonBars(){
        if (pokemon1 == null || pokemon2 == null) {
            System.out.println("algo raro paso error");
            return;
        }
        if (turno % 2 == 0) {
            bar1 = new PokemonStatusBar(pokemon1.getName(), pokemon1.getHealth(), pokemon1.getHealthMax());
            bar1.setBounds(600, 400,600,300);
            bar2 = new PokemonStatusBar(pokemon2.getName(), pokemon2.getHealth(), pokemon2.getHealthMax());
            bar2.setBounds(150, 200,600,300);
        } else {
            bar1 = new PokemonStatusBar(pokemon1.getName(), pokemon1.getHealth(), pokemon1.getHealthMax());
            bar1.setBounds(1000, 200,600,300);
            bar2 = new PokemonStatusBar(pokemon2.getName(), pokemon2.getHealth(), pokemon2.getHealthMax());
            bar2.setBounds(50, 400,600,300);
        }


        mainPanel.add(bar1, Integer.valueOf(2));
        mainPanel.add(bar2, Integer.valueOf(2));
    }

    public void putMessage(String message){
        messageBattle.getCard().show(messageBattle, "textArea");
        messageBattle.setMessage(message);
        messageBattle.revalidate();
        messageBattle.repaint();
    }

    public void updateTurn(){
        System.out.println("turno: " + turno);
        System.out.println(pokemon1);
        System.out.println(pokemon2);
        if(pokemon1.isAlive() && pokemon2.isAlive()){
            turno++;
            System.out.println("turno movido: " + turno);
            removeThings();
            setThings();
        }

    }

    public void setHealth(boolean flag, int health){
        if(flag){
            bar1.setHp(health);
        } else {
            bar2.setHp(health);
        }
    }

    public void makeDamage(int index){
        if(turno % 2  == 0){
            pokemon1.makeDamage(pokemon2, pokemon1.getAttacks()[index]);
            bar2.setHp(pokemon2.getHealth());
        } else {
            pokemon2.makeDamage(pokemon1, pokemon2.getAttacks()[index]);
            bar1.setHp(pokemon1.getHealth());
        }
        if(BattlePokemon.findOut(pokemon1, pokemon2)){
            chooseAgain();
        }

    }

    public void imagePokemons(){
    }

    public void setAttacksButtons(){
        if (attacksButtons != null){
            mainPanel.remove(attacksButtons);
        }
        if (turno  % 2 == 0){
            attacksButtons = new PokemonAttacksButtons(pokemon1.getAttacks());
        } else {
            attacksButtons = new PokemonAttacksButtons(pokemon2.getAttacks());
        }
        attacksButtons.setBounds(700, 800, 200, 200);
        mainPanel.add(attacksButtons, Integer.valueOf(2));
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void setThings(){
        pokemonBars();
        setAttacksButtons();
    }

    /**
     * funcion para borrar barras de vida, imagenes de pokemon etc y volver a escoger
     */
    public void removeThings(){
        mainPanel.remove(bar1);
        mainPanel.remove(bar2);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void combat(){
    }

    public static void main(String[] args) {
        Pokemon []pokemon1 = new Pokemon[]{
                new Pokemon("Bulbasaur", 100, TypePokemon.PLANTA, new Attack[]{
                        AttackFactory.VINE_WHIP, AttackFactory.SOLAR_BEAM, AttackFactory.RAZOR_LEAF, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"),

                new Pokemon("Pikachu", 90, TypePokemon.ELECTRICO, new Attack[]{
                        AttackFactory.THUNDERBOLT, AttackFactory.THUNDER, AttackFactory.SHOCK_WAVE, AttackFactory.QUICK_ATTACK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"),

                new Pokemon("Arcanine", 110, TypePokemon.FUEGO, new Attack[]{
                        AttackFactory.FIRE_BLAST, AttackFactory.FLAMETHROWER, AttackFactory.QUICK_ATTACK, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/59.png")
        };

        Pokemon []pokemon2 = new Pokemon[]{
                new Pokemon("Scyther", 100, TypePokemon.PLANTA, new Attack[]{
                        AttackFactory.LEAF_BLADE, AttackFactory.SLASH, AttackFactory.DOUBLE_KICK, AttackFactory.TACKLE
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/123.png"),

                new Pokemon("Electabuzz", 95, TypePokemon.ELECTRICO, new Attack[]{
                        AttackFactory.THUNDERBOLT, AttackFactory.THUNDER, AttackFactory.SHOCK_WAVE, AttackFactory.QUICK_ATTACK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/125.png"),

                new Pokemon("Vulpix", 90, TypePokemon.FUEGO, new Attack[]{
                        AttackFactory.FLAMETHROWER, AttackFactory.FIRE_BLAST, AttackFactory.TACKLE, AttackFactory.QUICK_ATTACK
                }, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/37.png"),
        };
        Trainer trainer1 = new Trainer("sebas", pokemon1);
        Trainer trainer2 = new Trainer("simon", pokemon2);
        new BattlePokemonGUI(trainer1, trainer2);

    }
}