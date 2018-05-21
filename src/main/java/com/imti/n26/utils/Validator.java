package com.imti.n26.utils;

import java.time.Instant;
import lombok.experimental.UtilityClass;

/**
 * Created by imteyaz on 21/05/18
 **/

@UtilityClass
public class Validator {

  public static boolean isValidTimestamp(long timestamp, long duration) {
    return Instant.now().toEpochMilli() - timestamp <= duration * 1000;
  }
}
