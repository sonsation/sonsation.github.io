---
title: "코틀린의 컴파일 과정"
date: 2019-08-23 00:34:28 -0400
categories: kotilin
---

# 코틀린의 컴파일 과정

컴파일 과정을 알기 이해하기 위해서는 코틀린은 정적 타입(Statically typed) 지정 언어라는 것을 알아야한다. 정적 타입 지정이라는 말은 프로그램의 모든 구성 요소의 타입이 컴파일 되는 시점에 알 수 있고, 컴파일러가 타입을 검증해준다는 뜻이다.

### 정적 타입 지정의 장점
1. 실행 시점에 어떤 메소드를 호출할지 알아내는 과정이 없어서 메소드 호출이 빠르다.
2. 컴파일러가 정확성을 검증하기 때문에 오류가 생길 화률이 줄어든다.
3. 코드에서 다루는 객체가 어떤 타입인자 알 수 있어서 코드를 볼 때 편하다.

코틀린의 경우도 자바와 같이

코드를 컴퓨터가 읽을 수 있도록 컴파일러가 class 파일 형식의 바이트 코드로 바꿔준다.
코틀린은 정적 타입지정 언어이기 때문에 컴파일러가 추론할 수 있는 변수들을 추론하여 스마트 캐스트해주고 추론 할 수 없는 타입들에 대해서 오류를 발생하여 개발자에게 보고한다. 또한 tailrec, inline 키워드같은 키워드를 쓰는 함수들에 대해 코드를 복사하거나 변환하여 컴파일한다.
