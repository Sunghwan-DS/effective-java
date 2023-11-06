package jsh.effectivejava.chapter6.item39.marker;

import java.lang.reflect.Method;

public class RunTestsForNewExceptionTest {

    public static void main(String[] args) throws Exception {   // Program arguments : jsh.effectivejava.chapter6.item39.marker.Sample2, ExceptionTest.class
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음\n", m);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
                    for (Class<? extends Throwable> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("테스트 %s 실패: %s\n", m, exc);
                    }
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d\n", passed, tests - passed);
    }
}
