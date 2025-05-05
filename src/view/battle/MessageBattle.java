package view.battle;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;


public class MessageBattle extends JPanel {
    private JTextArea textArea;
    private String fullMessage = null;
    private CardLayout card;
    private int charIndex = 0;
    final private int speed = 15;
    private Queue<String> messageQueue = new LinkedList<>();
    private boolean isShowingMessage = false;

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

    public void enqueueMessage(String newMessage) {
        messageQueue.add(newMessage);
        if (!isShowingMessage) {
            showNextMessage();
        }
    }

    private void showNextMessage() {
        if (messageQueue.isEmpty()) {
            isShowingMessage = false;
            return;
        }

        isShowingMessage = true;
        fullMessage = messageQueue.poll();
        textArea.setText("");
        charIndex = 0;

        Timer timer = new Timer(speed, e -> {
            if (charIndex < fullMessage.length()) {
                textArea.append(String.valueOf(fullMessage.charAt(charIndex)));
                charIndex++;
            } else {
                ((Timer) e.getSource()).stop();
                // Espera un poco antes de mostrar el siguiente mensaje
                new Timer(200, evt -> {
                    ((Timer) evt.getSource()).stop();
                    showNextMessage();
                }).start();
            }
        });
        timer.start();
    }

    public CardLayout getCard() {
        return card;
    }




//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Mensaje Pokémon");
//        frame.setLayout(new BorderLayout());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 200);
//        MessageBattle message = new MessageBattle();
//        frame.add(message, BorderLayout.CENTER);
//        PokemonStatusBar barra = new PokemonStatusBar("pikachu", 100, 100);
//        message.enqueueMessage("mensaje de prueba");
//        frame.add(barra, BorderLayout.SOUTH);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
 //   }

}
