package paint;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimplePaint extends Application {
    private ToggleButton drawBtn, rubberBtn ;
    private Button save, open;
    private Slider slider;
    private Label lineColor, lineWidth;
    private GraphicsContext gc;
    private ColorPicker cpLine;
    private Canvas canvas;
    private VBox vb;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        createButtons();
        createSlider();
        createLabels();
        createCanvas();
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1);
        drawAndClearListeners();
        pickColorListener();
        changeThicknessListener();
        openImg(primaryStage);
        saveImg(primaryStage);
        placeElements();
        setUpStage(primaryStage);
    }

    private void placeElements() {
        vb = new VBox(10);
        vb.getChildren().addAll(drawBtn, rubberBtn, lineColor, cpLine, lineWidth, slider, open, save);
        vb.setPadding(new Insets(5));
        vb.setStyle("-fx-background-color: #999999");
        vb.setPrefWidth(100);
        BorderPane pane = new BorderPane();
        pane.setLeft(vb);
        pane.setCenter(canvas);
    }

    private void createCanvas() {
        canvas = new Canvas(1080, 790);
    }

    private void drawAndClearListeners() {
        canvas.setOnMousePressed(e->{
            if(drawBtn.isSelected()) {
                gc.setStroke(cpLine.getValue());
                gc.beginPath();
                gc.lineTo(e.getX(), e.getY());
            } else if(rubberBtn.isSelected()) {
                double lineWidth = gc.getLineWidth();
                gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            }
        });

        canvas.setOnMouseDragged(e->{
            if(drawBtn.isSelected()) {
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
            }
            else if(rubberBtn.isSelected()){
                double lineWidth = gc.getLineWidth();
                gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            }
        });

        canvas.setOnMouseReleased(e->{
            if(drawBtn.isSelected()) {
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
                gc.closePath();
            } else if(rubberBtn.isSelected()) {
                double lineWidth = gc.getLineWidth();
                gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            }
        });
    }

    private void pickColorListener() {
        cpLine = new ColorPicker(Color.BLACK);
        cpLine.setOnAction(e-> gc.setStroke(cpLine.getValue()));
    }

    private void changeThicknessListener() {
        slider.valueProperty().addListener(e->{
            double width = slider.getValue();
            lineWidth.setText(String.format("%.1f", width));
            gc.setLineWidth(width);
        });
    }

    private void createButtons() {
        drawBtn = new ToggleButton("Draw");
        rubberBtn = new ToggleButton("Rubber");
        ToggleButton[] toggleButtons = new ToggleButton[]{drawBtn, rubberBtn};
        ToggleGroup toggleGroup = new ToggleGroup();
        for (ToggleButton btn : toggleButtons) {
            btn.setMinWidth(90);
            btn.setToggleGroup(toggleGroup);
            btn.setCursor(Cursor.HAND);
        }
        save = new Button("Save");
        open = new Button("Open");
        Button[] basicArr = new Button[]{save, open};
        for(Button btn : basicArr) {
            btn.setMinWidth(90);
            btn.setCursor(Cursor.HAND);
            btn.setTextFill(Color.WHITE);
            btn.setStyle("-fx-background-color: #666;");
        }
    }

    private void createSlider() {
        slider = new Slider(1, 10, 1);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
    }

    private void createLabels() {
        lineColor = new Label("Line Color");
        lineWidth = new Label("1.0");
    }

    private void setUpStage(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setLeft(vb);
        pane.setCenter(canvas);
        Scene scene = new Scene(pane, 1200, 800);
        primaryStage.setTitle("Paint");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openImg(Stage primaryStage) {
        open.setOnAction((e)->{
            FileChooser openFile = new FileChooser();
            openFile.setTitle("Open File");
            File file = openFile.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    InputStream io = new FileInputStream(file);
                    Image img = new Image(io);
                    gc.drawImage(img, 0, 0);
                } catch (IOException ex) {
                    System.out.println("Error!");
                }
            }
        });
    }

    private void saveImg(Stage primaryStage) {
        save.setOnAction((e)->{
            FileChooser savefile = new FileChooser();
            savefile.setTitle("Save File");

            File file = savefile.showSaveDialog(primaryStage);
            if (file != null) {
                try {
                    WritableImage writableImage = new WritableImage(1080, 790);
                    canvas.snapshot(null, writableImage);
                    RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                    ImageIO.write(renderedImage, "png", file);
                } catch (IOException ex) {
                    System.out.println("Error!");
                }
            }
        });
    }
}
