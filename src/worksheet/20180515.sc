val valAdd = (x: Int, y: Int) => x + y
val valAddCurried = (x: Int) => ((y: Int) => x + y)

def defAdd(x: Int, y: Int): Int = x + y
def defAddCurried(x: Int)(y: Int): Int = x + y

valAdd(1, 2)
valAddCurried(1)(2)

defAdd(1, 2)
defAddCurried(1)(2)

defAdd _

val a = (_: Int) + (_: Int)
def b = (_: Int) + (_: Int)

a eq a
b eq b

a(1,2)
b(1,2)

