package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Demo {
	
	TextField  text;
	JTextField t1; 
	
	public static void initAndShowGUI() {
		Demo demo=new Demo();
		JFrame f = new JFrame("TextField Example");
		
		JButton b1;
		b1=new JButton("Swing Button");
		demo.t1 = new JTextField("Swing Text Box");
		demo.t1.setBounds(50, 100, 200, 30);
		final JFXPanel t2 = new JFXPanel();
		final JFXPanel b2= new JFXPanel();
		t2.setBounds(50, 350, 400, 30);
		b1.setBounds(50, 400, 200, 30);
		b2.setBounds(50, 450, 200, 30);
		f.add(demo.t1);
		f.add(t2);
		f.add(b1);
		f.add(b2);
		f.setSize(600, 600);
		f.setLayout(null);
		f.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 demo.t1.setText("Swing Button Pressed");
			 demo.text.setText("Swing Button Pressed");
			}
		
		
	});

		
		
		 Platform.runLater(new Runnable() {
	            @Override
	            public void run() {
	                demo.initFX(t2);
	                
	            }
	       });
		
		
}
	
	
	
	private  void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }
	
	private  Scene createScene() {
        Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root, Color.ALICEBLUE);
        text  =  new  TextField();
        Button b2=new Button("JAVAFX BUTTON");
        b2.setLayoutX(260);
        
        b2.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
			
			@Override
			public void handle(javafx.event.ActionEvent event) {
				t1.setText("JFX Button Clicked");
				text.setText("JFX BUtton Clicked");
			}

        });
        
        
        text.setFont(new Font(25));
        text.setText("JAVAFX TextBox");
        text.setMaxSize(200, 30);

        root.getChildren().add(text);
        root.getChildren().add(b2);

        return (scene);
    }
	
	
	
	
	
	public static void main(String[] args) {
		 initAndShowGUI();
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               
            }
        });
    }
	
}