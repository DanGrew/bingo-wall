package uk.dangrew.bingowall.ui;

import org.junit.Ignore;
import org.junit.Test;

import uk.dangrew.bingowall.logic.BingoNumbers;
import uk.dangrew.kode.launch.TestApplication;

public class BingoBoardTest {

   @Ignore
   @Test public void run() throws InterruptedException {
      TestApplication.launch( () -> new UiBingoBoard( new BingoNumbers( 90 ) ) );
      
      Thread.sleep( 99999999 );
   }

}
