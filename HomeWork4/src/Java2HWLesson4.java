import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 1. Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна,
 * использовать для этого JTextArea. Однострочное текстовое поле для ввода сообщений и кнопка для отсылки
 * сообщений на нижней панели. Сообщение должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter.
 * При «отсылке» сообщение перекидывается из нижнего поля в центральное.
 *
 * @author Slava Bugakov
 * @version 0.0.2 dated 08 Sep 2017
 */

public class Java2HWLesson4{
    public static void main(String[] args){
        new ChatWindow();
    }
}
interface WindowOptions{
    int WINDOW_WIDTH = 300;
    int WINDOW_HIGHT = 250;
    int WINDOW_POS = 150;
    String TITLE = "Chat Window";
    String BTN_ENTER = "Enter";
    boolean IS_VISIBLE = true;
}

class ChatWindow extends JFrame implements ActionListener, WindowOptions{
    JTextArea dialogBox;
    JScrollPane scrollbar;
    JPanel controlsPanel;
    JTextField txtInput;
    JButton btnEnter;

    ChatWindow(){
        setTitle(TITLE);
        setBounds(WINDOW_POS, WINDOW_POS, WINDOW_WIDTH, WINDOW_HIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        dialogBox = new JTextArea();
        dialogBox.setEditable(false);
        dialogBox.setLineWrap(true);
        scrollbar = new JScrollPane(dialogBox);

        controlsPanel = new JPanel();
        controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.X_AXIS));

        txtInput = new JTextField();
        txtInput.addActionListener(this);
        txtInput.setFocusable(true);
        txtInput.setVisible(isFocusable());


        btnEnter = new JButton(BTN_ENTER);
        btnEnter.setMnemonic(BTN_ENTER.charAt(0));
        btnEnter.addActionListener(this);

        controlsPanel.add(txtInput);
        controlsPanel.add(btnEnter);
        add(BorderLayout.CENTER, scrollbar);
        add(BorderLayout.SOUTH, controlsPanel);
        setVisible(IS_VISIBLE);
        txtInput.requestFocusInWindow();

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(txtInput.getText().trim().length() > 0){
            dialogBox.append(txtInput.getText() + "\n");
        }
        txtInput.setText("");
        txtInput.requestFocusInWindow();

    }
}

