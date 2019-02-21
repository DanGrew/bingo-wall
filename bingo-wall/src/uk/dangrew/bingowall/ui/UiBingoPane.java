package uk.dangrew.bingowall.ui;

import javafx.scene.layout.BorderPane;
import uk.dangrew.bingowall.model.BingoSettings;

public class UiBingoPane extends BorderPane {

   public UiBingoPane( BingoSettings settings ) {
      this.setTop( new UiBingoControlRibbon( settings ) );
      this.setCenter( new UiBingoBoard( settings ) );
   }//End Constructor
   
}//End Class
