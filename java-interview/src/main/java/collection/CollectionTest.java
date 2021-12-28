package collection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {

  /*
   * Simple method which calculates the power 5 with 3 multiplications
   */
  private static Integer powerFive(Integer a) {
    Integer tmp= a*a;
    return tmp*tmp*a;
  }

  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    List<Double> output = input.stream().map(x ->Double.valueOf(powerFive((x * 2) + 3))).collect(Collectors.toList());
    return output;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    return null;
  }

}
