import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * An application for viewing posters for movies and TV/Internet shows.
 * 
 * @author Baba Kofi Weusijana
 * @author Sangeet Satpathy
 *
 */
public class PosterViewer extends Application
{
    private static final double APP_SPACING = 10;
    private static final double APP_WIDTH = 800;
    private static final double APP_HEIGHT = 400;
    private static final boolean DEBUG = true;

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    /**
     * TODO: Make sure you adhere to the following JavaDoc specification for this
     * helper method:<br/>
     * If the url parameter is null, invalid, or unsupported, the returned Image
     * object will be null and the posterLabel's text will be set to the localized
     * error message. Otherwise the posterLabel's text will be set to the url.
     * 
     * @param url         String object
     * @param posterLabel Label object for the posterImageView
     * @return Image object for the posterImageView
     */
    private Image getPosterImage(String url, Label posterLabel)
    {
        // TODO: You MUST complete the try-catch code below to handle if the
        // posterImage's URL is null, invalid, or unsupported.
        // This means you must at least catch:
        // NullPointerException - if URL is null
        // IllegalArgumentException - if URL is invalid or unsupported
        // Do NOT simply catch a general Exception or Throwable!
        // Each catch block must print the stack trace of the caught exception.
        // Done.
        Image posterImage = null;
        try
        {
            posterImage = new Image(url);
            posterLabel.setText(url);
            if (DEBUG)
            {
                System.out.println(posterImage.getUrl());
            }
        } catch (NullPointerException n)
        {
            posterLabel.setText(n.getLocalizedMessage());
            n.printStackTrace();
        } catch (IllegalArgumentException i)
        {
            posterLabel.setText(i.getLocalizedMessage());
            i.printStackTrace();
        }
// TODO: Call getLocalizedMessage and printStackTrace on each exception caught - Done.

        return posterImage;
    }

    /**
     * @param stage The Stage object for this Application
     */
    @Override
    public void start(Stage stage) throws Exception
    {
        final ComboBox<String> posterComboBox = new ComboBox<String>();
        final ImageView posterImageView = new ImageView();
        // TODO: You must find and use 10 posters (and also include the 11th "Bad Movie"
        // at the end so you can show what happens during an exceptional error event).
        // Wikipedia is a good place to find fair use and open licensed poster images.
        // posterNames is an array of poster names that will be shown in the
        // posterComboBox so users can select which poster to view.
        // Done.
        String[] posterNames =
        { "Marvel's Black Panther", "The Matrix", "Thor: Ragnarok", "Avengers: Endgame", "Avengers: Infinity War",
                "Doctor Strange", "Captain America: Civil War", "The Incredible Hulk",
                "Captain America: The Winter Soldier", "Iron Man", "Bad Movie", "Null Movie" };
        // posterURLs is an array of URLs to the poster images that each match the
        // poster name in the same index position inside the posterNames array.
        String[] posterURLs =
        { "https://upload.wikimedia.org/wikipedia/en/d/d6/Black_Panther_%28film%29_poster.jpg",
                "https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg",
                "https://upload.wikimedia.org/wikipedia/en/7/7d/Thor_Ragnarok_poster.jpg",
                "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg",
                "https://upload.wikimedia.org/wikipedia/en/4/4d/Avengers_Infinity_War_poster.jpg",
                "https://upload.wikimedia.org/wikipedia/en/a/a1/Doctor_Strange_%282016_film%29_poster.jpg",
                "https://upload.wikimedia.org/wikipedia/en/5/53/Captain_America_Civil_War_poster.jpg",
                "https://upload.wikimedia.org/wikipedia/en/f/f0/The_Incredible_Hulk_%28film%29_poster.jpg",
                "https://upload.wikimedia.org/wikipedia/en/9/9e/Captain_America_The_Winter_Soldier_poster.jpg",
                "https://upload.wikimedia.org/wikipedia/en/0/02/Iron_Man_%282008_film%29_poster.jpg", "badURL",
                ""};

        // Setup posterLabel and posterImageView
        Label posterLabel = new Label();
        posterLabel.setLabelFor(posterImageView);
        posterImageView.setPreserveRatio(true);
        posterImageView.setSmooth(true);
        posterImageView.setCache(true);

        // Setup posterComboBox
        posterComboBox.getItems().setAll(posterNames);
        posterComboBox.setPromptText("Posters");
        posterComboBox.setEditable(false);
        posterComboBox.getSelectionModel().select(0);
        posterComboBox.setOnAction((ActionEvent actionEvent) ->
        {
            if (DEBUG)
            {
                System.out.println(actionEvent.toString());
                System.out.println("Target:" + actionEvent.getTarget());
                System.out.println(posterComboBox.getSelectionModel().getSelectedItem());
            }
            int selectedIndex = posterComboBox.getSelectionModel().getSelectedIndex();
            // TODO: Load the nextPosterImage by calling getPosterImage with the correct URL
            // String from the posterURLs array and the posterLabel object.
            // Done.
            Image nextPosterImage = getPosterImage(posterURLs[selectedIndex], posterLabel);
            posterImageView.setImage(nextPosterImage);

        });
        // By firing an ActionEvent, the listener defined above will be called and
        // thus load the first poster Image.
        posterComboBox.fireEvent(new ActionEvent());

        // Arrange the graphic components into the scene and show the stage
        VBox posterVBox = new VBox();
        posterVBox.setAlignment(Pos.CENTER);
        posterVBox.getChildren().addAll(posterLabel, posterImageView);

        VBox controlsVBox = new VBox();
        controlsVBox.setSpacing(APP_SPACING);
        controlsVBox.getChildren().addAll(posterComboBox);

        HBox sceneHBox = new HBox();
        sceneHBox.setSpacing(APP_SPACING);
        sceneHBox.setAlignment(Pos.CENTER);
        sceneHBox.getChildren().addAll(controlsVBox, posterVBox);

        Scene scene = new Scene(sceneHBox, APP_WIDTH, APP_HEIGHT);
        stage.setTitle("Poster Viewer");
        stage.setWidth(APP_WIDTH);
        stage.setHeight(APP_HEIGHT);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }
}