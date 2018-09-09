package io.github.portfoligno.log.std.function;

import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

/**
 * Distinguish from {@code Supplier<?>} in which {@code Object#toString} will be called instead
 */
public interface Message {
  @Nullable Object get();
}
