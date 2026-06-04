### Exercise 2: Dependency Inversion Principle (DIP)

#### 📖 Background
The Dependency Inversion Principle (DIP) states that high-level modules should not depend on low-level modules. Both should depend on abstractions (interfaces). By decoupling classes, we can easily switch out dependencies without rewriting the high-level class.

In our current system, the high-level `Windows98Machine` class is tightly coupled to the low-level `StandardKeyboard` and `StandardMonitor` classes. The `Windows98Machine` instantiates these specific classes directly inside its constructor using the `new` keyword. This makes it impossible to change the keyboard or monitor without modifying the machine's code.

#### 🎯 Objective
Refactor the provided skeleton code to comply with the Dependency Inversion Principle by using Dependency Injection.

#### 📝 Instructions
1. In the current folder, create two new interface files: `Keyboard.java` and `Monitor.java`.
   - Add a `type()` method signature to the `Keyboard` interface.
   - Add a `display()` method signature to the `Monitor` interface.
2. Modify `StandardKeyboard.java` and `StandardMonitor.java` so that they `implement` their respective interfaces.
3. Modify `Windows98Machine.java`:
   - Change the field types from specific classes to the new interfaces (`Keyboard` and `Monitor`).
   - Remove the `new` keyword instantiations from the constructor.
   - Update the constructor to accept `Keyboard` and `Monitor` as parameters (Dependency Injection).
4. **DO NOT modify `Main.java`**. Run it to verify your refactoring. It will automatically detect your interfaces and the new constructor.

#### ✅ Grading Criteria
* Are `Keyboard` and `Monitor` created as interfaces?
* Does `Windows98Machine` depend ONLY on interfaces, not concrete implementations?
* Is dependency injection used in the constructor of `Windows98Machine`?

---


#### 📖 배경 상황
의존성 역전 원칙(DIP)은 고수준 모듈이 저수준 모듈에 의존해서는 안 되며, 둘 다 추상화(인터페이스)에 의존해야 한다는 원칙입니다. 클래스 간의 결합도를 낮추면, 고수준 클래스의 코드를 수정하지 않고도 부품(저수준 모듈)을 쉽게 교체할 수 있습니다.

현재 시스템에서 고수준 모듈인 `Windows98Machine` 클래스는 저수준 모듈인 `StandardKeyboard`와 `StandardMonitor` 클래스에 강하게 결합(Tightly coupled)되어 있습니다. 생성자 내부에서 `new` 키워드를 사용해 구체적인 클래스를 직접 생성하고 있기 때문에, 기계의 코드를 뜯어고치지 않는 이상 다른 키보드나 모니터로 교체할 수 없는 상태입니다.

#### 🎯 실습 목표
제공된 뼈대 코드에 의존성 주입(Dependency Injection) 패턴을 적용하여, 의존성 역전 원칙을 준수하도록 리팩토링하세요.

#### 📝 수행 지침
1. 현재 폴더에 `Keyboard.java`와 `Monitor.java`라는 두 개의 새로운 인터페이스 파일을 생성합니다.
   - `Keyboard` 인터페이스에는 `type()` 메서드를 선언합니다.
   - `Monitor` 인터페이스에는 `display()` 메서드를 선언합니다.
2. `StandardKeyboard.java`와 `StandardMonitor.java`가 각각 새롭게 만든 인터페이스를 `implements`(구현) 하도록 코드를 수정합니다.
3. `Windows98Machine.java`를 다음 조건에 맞게 수정합니다:
   - 멤버 변수의 타입을 구체적인 클래스 대신 인터페이스(`Keyboard`, `Monitor`)로 변경합니다.
   - 생성자 내부에 있는 `new` 키워드 생성을 모두 지웁니다.
   - 생성자가 외부로부터 `Keyboard`와 `Monitor` 인터페이스를 매개변수로 전달받도록(주입받도록) 수정합니다.
4. **`Main.java` 파일은 절대 수정하지 마세요.** 실행하면 리플렉션을 통해 여러분이 만든 인터페이스와 새로운 생성자를 자동 감지하고 채점합니다.

#### ✅ 평가 기준
* `Keyboard`와 `Monitor`가 인터페이스로 올바르게 분리되었는가?
* `Windows98Machine`이 구체적인 구현체가 아닌 추상화(인터페이스)에만 의존하는가?
* `Windows98Machine`의 생성자를 통해 의존성 주입(Dependency Injection)이 이루어지는가?