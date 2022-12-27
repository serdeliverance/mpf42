package io.github.sd3v.mpf.domain;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public record Budget(YearMonth period, Integer userId, List<Income> ins, List<Outcome> outs) {

  public BigDecimal totalIncome() {
    return ins.stream().map(Income::amount).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal totalOutcome() {
    return outs.stream().map(Outcome::amount).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal balance() {
    return totalIncome().subtract(totalOutcome());
  }
}
