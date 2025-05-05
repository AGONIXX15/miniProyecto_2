package view.battle;
import models.pokemon.Pokemon;
import models.pokemon.utils.Attack;
import utils.AttackFactory;

import javax.swing.*;
import java.awt.*;

public class PokemonAttacksButtons extends JPanel {

    private int attack;

    public PokemonAttacksButtons(Attack[]attacks) {
        attack = -1;
        setPreferredSize(new Dimension(400, 400));
        GridLayout grid = new GridLayout(2,2);
        grid.setVgap(10);
        grid.setHgap(10);
        setLayout(new GridLayout(2,2));
        for(int i = 0; i < attacks.length; i++) {
            JButton button = new JButton(String.format("%s, poder: %d\ntipo:%s", attacks[i].getName(), attacks[i].getPower(), attacks[i].getTypeDamage()));
            int index = i;
            button.setPreferredSize(new Dimension(150, 150));
            button.addActionListener(e -> {
                System.out.println("ataque escogido " + attacks[index] + " " + index);
                attack = index;
                BattlePokemonGUI.getInstance().updateTurn();
                BattlePokemonGUI.getInstance().makeDamage(index);
            });

            add(button);
        }
    }

    public int getAttack(){
        return attack;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pokemon Attacks");
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Attack []attacks = new Attack[]{
                AttackFactory.VINE_WHIP, AttackFactory.SOLAR_BEAM, AttackFactory.RAZOR_LEAF, AttackFactory.TACKLE
        };
        PokemonAttacksButtons panel = new PokemonAttacksButtons(attacks);
        panel.setBounds(100,100,300,300);
        JLabel label = new JLabel("algo");
        label.setBounds(200,500,100,100);
        frame.add(panel);
        frame.add(label);
        frame.setVisible(true);
    }


}
