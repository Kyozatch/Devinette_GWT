package fr.ifsic.gwt.devinette.client;

import java.util.Random;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Devinette implements EntryPoint {
	
	private int nbr = 0;
	private int tryNumber = 0;
	
	  private VerticalPanel mainPanel = new VerticalPanel();
	   
	  private HorizontalPanel visuPanel = new HorizontalPanel();
	  private HorizontalPanel buttonPanel = new HorizontalPanel();
	  
	  private TextBox visuNbrTextBox = new TextBox();
	  private Button okButton = new Button("Deviner");
	  
	  private Label label = new Label("Devinez le nombre");
	  
	  private Label labelPLUS = new Label("C'est plus !");
	  private Label labelMOINS = new Label("C'est moins !");
	  private Label labelTROUVE = new Label("BRAVO !!");
	  
	  // button Incrs
	  private HorizontalPanel buttonIncrPanel = new HorizontalPanel();
	 

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		Random rand = new Random();
		nbr = rand.nextInt(100);
		
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		visuPanel.add(label);
		visuPanel.add(visuNbrTextBox);
		
		buttonPanel.setSpacing(20);
		buttonPanel.add(okButton);
		
		mainPanel.add(buttonIncrPanel);
		mainPanel.add(visuPanel);
		mainPanel.add(buttonPanel);
		
		RootPanel.get("mainDevinette").add(mainPanel);
		
		visuNbrTextBox.addKeyPressHandler(new KeyPressHandler() {
		      public void onKeyPress(KeyPressEvent event) {
		        if (event.getCharCode() == KeyCodes.KEY_ENTER) {
		          String newVal = visuNbrTextBox.getText();
		          tryNumber = Integer.parseInt(newVal);
		        }
		      }
		    });
		
	    // Listen for mouse events on the Add button.
	   okButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	    	int diff = nbr - tryNumber;
	    		
	    	if(diff < 0){
	    		mainPanel.remove(labelPLUS);
	    		mainPanel.add(labelMOINS);
	    		mainPanel.remove(labelTROUVE);
	    		}
	    	
	    	else if(diff > 0){
	    		mainPanel.add(labelPLUS);
	    		mainPanel.remove(labelMOINS);
	    		mainPanel.remove(labelTROUVE);
	    	}
	    	
	    	else{
	    		mainPanel.remove(labelPLUS);
	    		mainPanel.remove(labelMOINS);
	    		mainPanel.add(labelTROUVE);
	    	}
	    	
	        refresh();
	      }
	    });

	    refresh();
	}
		private void refresh() {
			// nothing
			//visuNbrTextBox.setText(""+nbr);
		}
		
}
