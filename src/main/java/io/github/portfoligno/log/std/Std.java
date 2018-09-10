package io.github.portfoligno.log.std;

import io.github.portfoligno.log.std.function.Message;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.PrintStream;

public class Std {
  private static void println(@NotNull PrintStream stream, @Nullable Object message) {
    stream.println(message == null ? "null" : message);
  }

  private static void println(@NotNull PrintStream stream, @Nullable Message message) {
    ThreadLocal<Message> messages = MessageWrapper.messages;
    messages.set(message);

    try {
      stream.println(MessageWrapper.INSTANCE);
    }
    catch (StackOverflowError t) {
      err("Error during message construction.");
      err(t);
    }
    // Avoid catching fatal errors
    catch (VirtualMachineError t) { throw t; }
    catch (ThreadDeath t) { throw t; }
    catch (Throwable t) {
      err("Error during message construction.");
      err(t);
    }
    finally {
      messages.remove();
    }
  }

  private static void printStackTrace(@NotNull PrintStream stream, @Nullable Throwable throwable) {
    if (throwable == null) {
      stream.println("(null throwable)");
    }
    else {
      throwable.printStackTrace(stream);
    }
  }

  public static void out(@Nullable Object message) {
    println(System.out, message);
  }

  public static void out(@Nullable Message message) {
    println(System.out, message);
  }

  public static void out(@Nullable Throwable throwable) {
    printStackTrace(System.out, throwable);
  }

  public static void err(@Nullable Object message) {
    println(System.err, message);
  }

  public static void err(@Nullable Message message) {
    println(System.err, message);
  }

  public static void err(@Nullable Throwable throwable) {
    printStackTrace(System.err, throwable);
  }
}
