package com.imti.n26.dtos;

import java.util.DoubleSummaryStatistics;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by imteyaz on 20/05/18
 **/

@Getter
@Setter
@ToString
public class Statistics {

  private double sum;
  private double avg;
  private double max;
  private double min;
  private long count;

 public static Statistics from(DoubleSummaryStatistics summaryStatistics){
   Statistics statistics = new Statistics();
   statistics.setAvg(summaryStatistics.getAverage());
   statistics.setCount(summaryStatistics.getCount());
   statistics.setMax(summaryStatistics.getMax());
   statistics.setMin(summaryStatistics.getMin());
   statistics.setSum(summaryStatistics.getSum());
   return statistics;
 }

}
