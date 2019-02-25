package uk.dangrew.bingowall.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import uk.dangrew.bingowall.model.BingoSettings;
import uk.dangrew.kode.javafx.style.JavaFxStyle;

public class UiPauseButton extends BorderPane {

   private final BingoSettings settings;
   private final Button button;
   
   public UiPauseButton( BingoSettings settings ) {
      this.settings = settings;
      this.button = new Button( "||" );
      this.setCenter( button );
      
      this.button.setFont( Font.font( 30 ) );
      this.button.setAlignment( Pos.CENTER );
      this.button.setMaxSize( Double.MAX_VALUE, Double.MAX_VALUE );
      this.button.setBorder( new JavaFxStyle().borderFor( Color.BLACK ) );
      this.button.setOnAction( e -> settings.paused().set( !settings.paused().get() ) );
      
      this.settings.paused().addListener( ( s, o, n ) -> updateBackground() );
      this.updateBackground();
   }//End Constructor
   
   private void updateBackground(){
      if ( settings.paused().get() ) {
         this.button.setBackground( new JavaFxStyle().backgroundFor( Color.ORANGE ) );
      } else {
         this.button.setBackground( new JavaFxStyle().backgroundFor( Color.WHITE ) );
      }
   }//End Method
}//End Class
