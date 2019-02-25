package uk.dangrew.bingowall.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uk.dangrew.bingowall.logic.BingoNumberGenerator;
import uk.dangrew.bingowall.logic.BingoNumbers;
import uk.dangrew.bingowall.model.BingoSettings;
import uk.dangrew.bingowall.ui.UiBingoPane;
import uk.dangrew.jupa.javafx.platform.PlatformLifecycle;

/**
 * Entry point to the system for launching.
 */
public class BingoWall extends Application {
   
   static final String TITLE = "Bingo!";
   
   public BingoWall() {}//End Constructor
   
   @Override public void start(Stage stage) throws Exception {
      stage.setTitle( TITLE );
      stage.setOnCloseRequest( event -> PlatformLifecycle.shutdown() );
      
      BingoSettings settings = new BingoSettings();
      BingoNumbers numbers = new BingoNumbers( 90 );
      BingoNumberGenerator numberGenerator = new BingoNumberGenerator( settings, numbers );
      stage.setScene( new Scene( new UiBingoPane( settings, numbers, numberGenerator ) ) );
      stage.setMaximized( true );
      stage.show();
      
      numberGenerator.start();
   }//End Method
   
   public static void main( String[] args ) {
      launch();
   }//End Method
   
}//End Class
