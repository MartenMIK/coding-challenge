package me.taktile.challenge

/**
 * tFold implements fold, a higher order function that given an initial value x of type B and a function f:(A,B) -> B
 * consecutively applies x = f(a,x) for all a: A in this List, then returns x. It is applied from the first to the last element.
 */
fun <A, B> List<A>.tFold(initial: B, function: ((A, B) -> B)): B {
    var result = initial
    this.forEach {
        result = function(it, result)
    }
    return result
}
