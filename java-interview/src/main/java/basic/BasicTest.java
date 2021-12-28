package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

	  /**
	   * return i ^ n for positive Integer, None otherwise
	   * alse return None in case of errors
	   */
	  public static Option<Integer> power(Integer i, Integer n) {
      try{
        // check that they are positive
        if (i >= 0 && n >= 0){
          // i^0 = 1
          if (n == 0){
            return Option.of(1);
            //0^n = 0
          } else if (i == 0 && n >0){
            return Option.of(0);
          } else {
            // Do a recursive calculation
            Option<Integer> result = power(i, n-1);
            if (result.isEmpty()) {
              return Option.none();
            } else {
              return Option.of(i * result.get());   
            } 
          }
        } else {
          return Option.none();
        }
      }
      catch(StackOverflowError e){
          return Option.none();
      }
    }
}