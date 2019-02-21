package uk.dangrew.bingowall.ui;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import uk.dangrew.bingowall.model.BingoSettings;
import uk.dangrew.kode.javafx.style.JavaFxStyle;

public class UiBingoControlRibbon extends GridPane {

   public UiBingoControlRibbon( BingoSettings settings ) {
      this.setPadding( new Insets( 10 ) );
      new JavaFxStyle().configureConstraintsForColumnPercentages( this, 40, 5, 10, 5, 40 );
      
      this.add( 
               new UiSpeedButton( "<", () -> settings.callTime().set( settings.callTime().get().decrease() ) ),
               1, 0
      );
      this.add( 
               new UiPauseButton( settings ),
               2, 0
      );
      this.add( 
               new UiSpeedButton( ">", () -> settings.callTime().set( settings.callTime().get().increase() ) ),
               3, 0
      );
   }//End Constructor
}//End Class
