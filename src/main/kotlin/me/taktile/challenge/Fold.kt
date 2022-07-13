package me.taktile.challenge

fun <A, B> List<A>.tFold(initial: B, function: ((A, B) -> B)): B {
    var result = initial
    this.forEach {
        result = function(it, result)
    }
    return result
}