package terminal

fun main(args: Array<String>) {
  // Breakpoint!
  sequenceOf(1, 2, 3, 2, 3).minWith(compareByDescending { it })
}