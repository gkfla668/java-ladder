# java-ladder 🚀
사다리 게임 저장소

## 🎈 구현 기능 목록 
* 입력
    * 참여자 이름 
    * 실행 결과 
    * 최대 사다리 높이
    * 결과 보고싶은 사람 이름 (개인 or all)
* 출력
    * 사다리 결과
    * 실행 결과 (개인 or all)

## 🚀 기능 요구 사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - **|-----|-----|** 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 🚀 구현해야 할 기능

- 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
dowon, halim, geinee, dowon2

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

사다리 결과

dowon  halim  geinee dowon2
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
    꽝    5000  꽝    3000

결과를 보고 싶은 사람은?
dowon

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
dowon : 꽝
halim : 3000
geinee : 꽝
dowon2 : 5000
```

## 🚀 프로그래밍 요구사항
- README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 Java Style Guide을 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
  - else 예약어를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  - 힌트: if문에서 값을 반환하는 방식으로 구현하면 else 예약어를 사용하지 않아도 된다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 컬렉션을 사용한다.
- 모든 원시 값과 문자열을 포장한다
- 줄여 쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.
- 모든 엔티티를 작게 유지한다.
- 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.


## 🚀 힌트
- 2차원 배열을 ArrayList, Generic을 적용해 구현하면 ArrayList<ArrayList<Boolean>>와 같이 이해하기 어려운 코드가 추가된다.
- 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.
```java
public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    [...]
}
```
- 위와 같이 Line 객체를 추가하면 ArrayList<ArrayList<Boolean>> 코드를 ArrayList<Line>과 같이 구현하는 것이 가능해 진다.