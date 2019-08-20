---
title: "코틀린의 smart cast"
date: 2019-08-21 00:34:28 -0400
categories: kotilin
---

자바에서 instanceOf 연산자를 사용하여 객체의 자료형을 확인하더라도 이를 변환하기 위해서는 확인했던 자료형으로 다운 캐스팅을 해줘야한다.
코틀린에서 이러한 불편함을 해소하고 간결함을 얻기 위해 is로 추론이 가능한 경우 캐스팅 없이 해당하는 자료형으로 객체가 변환되도록 스마트 캐스팅을 지원한다.

```markdown
# 자바의 스마트 캐스팅 미지원
Object string = "is String!";

if (string instanceOf String) {
  String text = (String)string; // 별도의 다운 캐스팅을 해줘야함.
  System.out.println(text);
}

#코틀린의 스마트 캐스팅 지원
val string = "is String!"

if (string is String)
  println(string) // 별도의 캐스팅 없이 타입 체크만으로 캐스팅 되었기 때문에 따로 캐스팅이 필요없다.
```

이뿐만 아니라 코틀린의 스마트 캐스팅은 람다식에서도 적용된다.

```markdown
# 스마트 캐스팅 미적용
val sum: (Int, Int)->Int = {x: Int, y:Int -> x + y}

# 스마트 캐스팅 적용
val sum = {x: Int, y:Int -> x + y}
```

