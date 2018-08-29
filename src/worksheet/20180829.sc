def plainOldSum(x: Int, y: Int) = x + y
plainOldSum(1, 2)

def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2)

def first(x: Int) = (y: Int) => x + y
val second = first(1)
second(2)

val onPlus = curriedSum(1)_
onPlus(2)
val twoPlus = curriedSum(2)_
twoPlus(2)
