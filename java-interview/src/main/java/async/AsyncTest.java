package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    CompletableFuture<Option<Ceo>> completableFuture = new CompletableFuture<Option<Ceo>>();
    for (Ceo ceo : ceos) {
      if (ceo.id.equals(ceo_id)) {
        completableFuture.complete(Option.of(ceo));
        return completableFuture;
      }
    }
    completableFuture.complete(Option.none());
    return completableFuture;
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    CompletableFuture<Option<Enterprise>> completableFuture = new CompletableFuture<Option<Enterprise>>();
    for (Enterprise enterprise : enterprises) {
        if (enterprise.ceo_id.equals(ceo_id)) {
          completableFuture.complete(Option.of(enterprise));
          return completableFuture;
        }  
    }
      completableFuture.complete(Option.none());
      return completableFuture;
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> completableFuture = new CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>>();
    try {
      Option<Ceo> ceo = getCeoById(ceo_id).get();
      Option<Enterprise> entreprise = getEnterpriseByCeoId(ceo_id).get();
      Tuple2<Option<Ceo>, Option<Enterprise>> ceoAndEntreprise = Tuple.of(ceo, entreprise);
      completableFuture.complete(ceoAndEntreprise);
      return completableFuture;
    } catch (Exception e) {
        completableFuture.complete(Tuple.of(Option.none(), Option.none()));
        return completableFuture;
    }
  }

}
