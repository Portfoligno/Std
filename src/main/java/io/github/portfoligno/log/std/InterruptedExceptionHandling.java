package io.github.portfoligno.log.std;

import org.jetbrains.annotations.NotNull;

class InterruptedExceptionHandling {
  static final boolean ENABLED = Boolean.parseBoolean(
      System.getProperty("io.github.portfoligno.handleInterruptedExceptionInLogging", "true"));

  @SuppressWarnings("unchecked")
  static @NotNull <T extends Throwable> RuntimeException sneakyThrow(@NotNull Throwable t) throws T {
    throw (T) t;
  }
}
