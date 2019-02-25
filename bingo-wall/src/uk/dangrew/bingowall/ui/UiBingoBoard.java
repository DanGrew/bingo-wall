package uk.dangrew.bingowall.ui;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import uk.dangrew.bingowall.logic.BingoNumbers;
import uk.dangrew.kode.javafx.style.JavaFxStyle;

public class UiBingoBoard extends BorderPane {

   private final Map< Integer, Label > labels;
   
   public UiBingoBoard( BingoNumbers numbers ) {
      this.labels = new HashMap<>();
      
      GridPane grid = new GridPane();
      new JavaFxStyle().configureConstraintsForEvenColumns( grid, 10 );
      new JavaFxStyle().configureConstraintsForEvenRows( grid, 9 );
      
      this.setCenter( grid );
      
      for ( int row = 0; row < 9; row++ ){
         for ( int column = 1; column < 11; column++ ){
            int number = row * 10 + column;
            Label label = new Label( Integer.toString( number ) );
            label.setAlignment( Pos.CENTER );
            label.setBackground( new JavaFxStyle().backgroundFor( Color.WHITE ) );
            label.setBorder( new JavaFxStyle().borderFor( Color.BLACK ) );
            label.setMaxSize( Double.MAX_VALUE, Double.MAX_VALUE );
            label.setFont( Font.font( 30 ) );
            
            this.labels.put( number, label );
            numbers.numberStateFor( number ).addListener( ( s, o, n ) -> {
               if ( n ) {
                  label.setBackground( new JavaFxStyle().backgroundFor( Color.AQUA ) );
               }
            } );
            grid.add( label, column - 1, row );
         }
      }
      
   }//End Constructor
   
}//End Class
