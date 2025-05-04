package view.battle;

import javax.swing.*;
import java.awt.*;


public class MessageBattle extends JPanel {
    private JTextArea textArea;
    private String fullMessage = null;
    private CardLayout card;
    private int charIndex = 0;
    final private int speed = 60;

    /**
     * este es el constructor de la clase de mensajes para nuestro juego
     */
    public MessageBattle() {
        card = new CardLayout();
        setLayout(card);
        setPreferredSize(new Dimension(300, 300));
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(new JScrollPane(textArea), "textArea");
        add(new JPanel(), "vacio");
    }

    public CardLayout getCard() {
        return card;
    }

    /**
     * escribe un mensaje en el area de texto lentamente con un efecto que lo hace
     * parecer de un juego viejo
     * @param newMessage el nuevo mensaje que se va a enviar al area de texto
     */
    public void setMessage(String newMessage) {
        this.fullMessage = newMessage;
        textArea.setText("");
        this.charIndex = 0;
        Timer timer = new Timer(speed,  e -> {
            if (charIndex < fullMessage.length()) {
                textArea.append(String.valueOf(fullMessage.charAt(charIndex)));
                charIndex++;
            } else {
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mensaje Pokémon");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        MessageBattle message = new MessageBattle();
        frame.add(message, BorderLayout.CENTER);
        PokemonStatusBar barra = new PokemonStatusBar("pikachu", 100, 100);
        message.setMessage("simon sos una zunga sapa hp");
        frame.add(barra, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
