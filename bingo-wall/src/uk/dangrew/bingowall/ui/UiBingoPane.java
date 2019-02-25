package uk.dangrew.bingowall.ui;

import javafx.scene.layout.BorderPane;
import uk.dangrew.bingowall.logic.BingoNumberGenerator;
import uk.dangrew.bingowall.logic.BingoNumbers;
import uk.dangrew.bingowall.model.BingoSettings;

public class UiBingoPane extends BorderPane {

   public UiBingoPane( BingoSettings settings, BingoNumbers numbers, BingoNumberGenerator numberGenerator ) {
      this.setTop( new UiBingoControlRibbon( settings, numberGenerator ) );
      this.setCenter( new UiBingoBoard( numbers ) );
   }//End Constructor
   
}//End Class
