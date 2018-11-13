package io.github.portfoligno.log.std.test

import io.github.portfoligno.log.std.Std
import io.kotlintest.shouldThrow
import io.kotlintest.specs.WordSpec

class StdSpec : WordSpec({
  "out(Object)" should {
    "just work on strings" {
      Std.out("string")
    }
    "suppress common exceptions" {
      Std.out(object : Any() {
        override
        fun toString(): String =
          throw RuntimeException()
      })
    }
    "suppress StackOverflowError" {
      Std.out(object : Any() {
        override
        fun toString(): String =
            toString()
      })
    }
    "suppress InterruptedException and set the interrupted status" {
      Std.out(object : Any() {
        override
        fun toString(): String =
            throw InterruptedException()
      })
      shouldThrow<InterruptedException> {
        Thread.sleep(1)
      }
    }
    "propagate VirtualMachineError" {
      shouldThrow<VirtualMachineError> {
        Std.out(object : Any() {
          override
          fun toString(): String =
              throw OutOfMemoryError()
        })
      }
    }
    "propagate ThreadDeath" {
      shouldThrow<ThreadDeath> {
        Std.out(object : Any() {
          override
          fun toString(): String {
            throw ThreadDeath()
          }
        })
      }
    }
  }
})
