package uk.dangrew.bingowall.ui;

import java.util.HashMap;
import java.util.Map;

import com.sun.javafx.application.PlatformImpl;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import uk.dangrew.bingowall.logic.BingoNumberGenerator;
import uk.dangrew.bingowall.logic.BingoNumbers;
import uk.dangrew.kode.javafx.style.JavaFxStyle;

public class UiBingoBoard extends GridPane {

   private final Map< Integer, Label > labels;
   
   public UiBingoBoard() {
      this.labels = new HashMap<>();
      
      new JavaFxStyle().configureConstraintsForColumnPercentages( this, 90, 10 );
      new JavaFxStyle().configureConstraintsForEvenRows( this, 2 );
      
      GridPane grid = new GridPane();
      new JavaFxStyle().configureConstraintsForEvenColumns( grid, 10 );
      new JavaFxStyle().configureConstraintsForEvenRows( grid, 9 );
      
      this.add( grid, 0, 0 );
      
      BingoNumbers numbers = new BingoNumbers( 90 );
      BingoNumberGenerator generator = new BingoNumberGenerator( numbers );
      for ( int row = 0; row < 9; row++ ){
         for ( int column = 1; column < 11; column++ ){
            int number = row * 10 + column;
            Label label = new Label( Integer.toString( number ) );
            label.setAlignment( Pos.CENTER );
            label.setBackground( new JavaFxStyle().backgroundFor( Color.WHITE ) );
            label.setBorder( new JavaFxStyle().borderFor( Color.BLACK ) );
            label.setMaxSize( Double.MAX_VALUE, Double.MAX_VALUE );
            label.setFont( label.getFont().font( 30 ) );
            
            this.labels.put( number, label );
            numbers.numberStateFor( number ).addListener( ( s, o, n ) -> {
               if ( n ) {
                  label.setBackground( new JavaFxStyle().backgroundFor( Color.AQUA ) );
               }
            } );
            grid.add( label, column - 1, row );
         }
      }

      Label nextCall = new Label( "??" );
      nextCall.setAlignment( Pos.CENTER );
      nextCall.setBackground( new JavaFxStyle().backgroundFor( Color.YELLOW ) );
      nextCall.setBorder( new JavaFxStyle().borderFor( Color.BLACK ) );
      nextCall.setMaxSize( Double.MAX_VALUE, Double.MAX_VALUE );
      nextCall.setFont( nextCall.getFont().font( 80 ) );
      generator.nextCall().addListener( ( s, o, n ) -> {
         PlatformImpl.runAndWait( () -> nextCall.setText( Integer.toString( n ) ) );  
      } );
      this.add( nextCall, 1, 0 );
      
      GridPane.setRowSpan( grid, 2 );
      Button pause = new Button( "||" );
      pause.setFont( nextCall.getFont().font( 80 ) );
      pause.setMaxSize( Double.MAX_VALUE, Double.MAX_VALUE );
      pause.setOnAction( e -> generator.togglePause() );
      generator.paused().addListener( ( s, o, n ) -> {
         if ( n ) {
            pause.setBackground( new JavaFxStyle().backgroundFor( Color.ORANGE ) );
         } else {
            pause.setBackground( new JavaFxStyle().backgroundFor( Color.WHITE ) );
         }
      } );
      this.add( pause, 1, 1 );
      
      generator.start();
   }//End Constructor
   
}//End Class
