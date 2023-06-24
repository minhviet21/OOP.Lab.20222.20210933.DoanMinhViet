package hust.soict.dsai.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private int i = 1;
	
	@FXML
    private Pane drawingAreaPane;
    
    @FXML
    private ToggleGroup tools;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (i == 1) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
    	    drawingAreaPane.getChildren().add(newCircle);
    	}
    	else {
        	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void PenPressed(ActionEvent event) {
    	i = 1;
    }

    @FXML
    void EraserPressed(ActionEvent event) {
    	i = 0;
    }
    
}

