package io.github.sd3v.mpf.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import org.junit.jupiter.api.Test;

class BudgetTest {

  @Test
  public void calculateTotalIncome() {
    var budget =
        new Budget(
            YearMonth.now(),
            1,
            List.of(
                new Income("bank", BigDecimal.valueOf(3000)),
                new Income("hand", BigDecimal.valueOf(500))),
            List.of());

    var result = budget.totalIncome();

    assertEquals(BigDecimal.valueOf(3500), result);
  }

  @Test
  public void calculateTotalOutcome() {
    var budget =
        new Budget(
            YearMonth.now(),
            1,
            List.of(),
            List.of(
                new Outcome("self", BigDecimal.valueOf(500)),
                new Outcome("german classes", BigDecimal.valueOf(300))));

    var result = budget.totalOutcome();

    assertEquals(BigDecimal.valueOf(800), result);
  }
}
