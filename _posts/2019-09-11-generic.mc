---
title: "코틀린 제네릭"
date: 2019-08-21 00:34:28 -0400
categories: kotilin
---

코틀린도 자바와 같이 Genric을 지원한다.
일반적으로 자바와 다르지 않으나, 코틀린은 좀더 많은 기능을 지원한다.
자바는 제네릭 개념이 들어가면ㅁ서 하위 호환성을 위해 타입을 정의하지 않고도 사용할 수 있으나, 코틀린은 반드시 타입을 정의하고 써야한다.

## Extension Property

```markdown
fun main() {
  val letters = ('a'..'z').toList()
  println(letters.slice<Char>(0..2))
  println(letters.slice(10..13))
}
```

extension property만 제네릭 하게 만들 수 있다. 일반 property에 제네릭을 사용하면 컴파일 오류가 난다.


## 제네릭 클래스

```markdown
# JAVA
public class Car<T> {
  private T data;
  
  public void set(T data) {
    this.data = data
  }
  
  public T get() {
    return data;
  }
}

#Kotlin
class Car<T> {
  private var data:T? = null
    get() = { return data }
    set(value) = { field = value }
```

자바와 같은 방법으로 <>형태로 선언하면 된다.

## Type parameter limitation
자바에는 extends나 super를 사용하여 사용한 타입을 제한할 수 있다.
코틀린에서는 :를 사용하여 상한 typ (upper bound)를 설정 할 수 있다.

```markdown
# JAVA
<T extends Number> T sum(List<T> list)

# Kotilin
fun <T: Number> List<T>.sum(): T
```

코틀린에서 타입 상한을 설정하면 상한 타입으로 취급할 수 있다.
```markdown
fun <T: Comparable<T>> max(first: T, second: T): T {
  return if (first > second) first else second
}

fun main() {
  println(max("kotlin", "java"))
}
```

위 예제에서는 T는 Comparable<T> 상한을 갖는다. 즉 max()를 사용할때의 인자는 Comparable을 구현하고 있어야 한다는 의미가 된다.



 
