package uk.dangrew.bingowall.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uk.dangrew.bingowall.ui.UiBingoBoard;
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
      stage.setScene( new Scene( new UiBingoBoard() ) );
      stage.setMaximized( true );
      stage.show();
   }//End Method
   
   public static void main( String[] args ) {
      launch();
   }//End Method
   
}//End Class
