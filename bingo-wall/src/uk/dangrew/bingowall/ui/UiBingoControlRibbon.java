package uk.dangrew.bingowall.ui;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import uk.dangrew.bingowall.logic.BingoNumberGenerator;
import uk.dangrew.bingowall.model.BingoSettings;
import uk.dangrew.kode.javafx.style.JavaFxStyle;

public class UiBingoControlRibbon extends GridPane {

   public UiBingoControlRibbon( BingoSettings settings, BingoNumberGenerator numberGenerator ) {
      this.setPadding( new Insets( 10 ) );
      this.setHgap( 10 );
      new JavaFxStyle().configureConstraintsForRowPercentages( this, 20, 60, 20 );
      new JavaFxStyle().configureConstraintsForColumnPercentages( this, 35, 5, 5, 10, 5, 5, 35 );
      
      this.add( 
               new UiSpeedButton( "<", () -> settings.callTime().set( settings.callTime().get().decrease() ) ),
               1, 1
      );
      this.add( 
               new UiPauseButton( settings ),
               2, 1
      );
      
      UiCallDisplay callDisplay = new UiCallDisplay( settings, numberGenerator );
      GridPane.setRowSpan( callDisplay, 3 );
      this.add( 
               callDisplay,
               3, 0
      );
      this.add( 
               new UiSpeedButton( ">", () -> settings.callTime().set( settings.callTime().get().increase() ) ),
               4, 1
      );
   }//End Constructor
}//End Class
