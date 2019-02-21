package uk.dangrew.bingowall.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class UiSpeedButton extends Button {

   public UiSpeedButton( String speedIndicator, Runnable action ) {
      super( speedIndicator );
      
      this.setAlignment( Pos.CENTER );
      this.setMaxSize( Double.MAX_VALUE, Double.MAX_VALUE );
      this.setFont( Font.font( 30 ) );
      this.setOnAction( e -> action.run() );
      this.setPadding( new Insets( 10 ) );
   }//End Constructor
}//End Class
