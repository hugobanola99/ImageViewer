package MVC.app.swing;

import MVC.control.Command;
import MVC.control.NextImageCommand;
import MVC.control.PrevImageCommand;
import MVC.model.Image;
import MVC.view.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Main extends JFrame{
    
    private List<Image> images;
    private ImageDisplay imageDisplay;
    private Map<String,Command> commands = new HashMap<>();
    
    public static void main(String[] args) {
        new Main().execute();
    }
    
    public Main(){
        this.setTitle("Image Viewer");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(imagePanel());
        this.add(toolbar(),BorderLayout.SOUTH);
    }

    private void execute() {
        this.images = new FileImageLoader(new File("fotos")).load();
        this.imageDisplay.display(images.get(0));
        this.commands.put("<", new PrevImageCommand(images, imageDisplay));
        this.commands.put(">", new NextImageCommand(images, imageDisplay));
        this.setVisible(true);
    }

    private JPanel imagePanel() {
        BlockPanel blockPanel = new BlockPanel();
        this.imageDisplay = blockPanel;
        return blockPanel;
    }
    

    private JMenuBar toolbar() {
        JMenuBar toolbar = new JMenuBar();
        toolbar.add(button("<"));
        toolbar.add(button(">"));
        return toolbar;
    }

    private JButton button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                commands.get(name).execute();
            }
        });
        return button;
    }
    
}
