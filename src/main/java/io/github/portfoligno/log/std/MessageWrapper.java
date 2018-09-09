package io.github.portfoligno.log.std;

import io.github.portfoligno.log.std.function.Message;
import org.jetbrains.annotations.NotNull;

class MessageWrapper {
  static final @NotNull ThreadLocal</*@Nullable*/ Message> messages = new ThreadLocal<Message>();
  static final @NotNull MessageWrapper INSTANCE = new MessageWrapper();

  private MessageWrapper() {
  }

  @Override
  public @NotNull String toString() {
    Message m = messages.get();
    return m == null ? "(null message)" : String.valueOf(m.get());
  }
}
