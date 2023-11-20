package jsh.effectivejava.chapter7.item47;

import java.util.stream.Stream;

public class ProcessHandleExample {

    public static void main(String[] args) {

//        for (ProcessHandle ph : ProcessHandle.allProcesses()::iterator) {
//            // 프로세스를 처리한다.
//        }

        ProcessHandle currentProcess = ProcessHandle.current();
        long pid = currentProcess.pid();
        ProcessHandle.Info processInfo = currentProcess.info();

        System.out.println("현재 프로세스의 PID: " + pid);
        System.out.println("프로세스 명령: " + processInfo.command().orElse("알 수 없음"));
        System.out.println("프로세스 시작 시간: " + processInfo.startInstant().orElse(null));

        currentProcess.children().forEach(child -> System.out.println("자식 프로세스 ID: " + child.pid()));
        currentProcess.parent().ifPresent(parent -> System.out.println("부모 프로세스 ID: " + parent.pid()));



        for (ProcessHandle ph : (Iterable<ProcessHandle>) ProcessHandle.allProcesses()::iterator) {
            // 프로세스를 처리한다.
            System.out.println("Case1 프로세스 PID: " + ph.pid());
            break;
        }

        for (ProcessHandle ph : iterableOf(ProcessHandle.allProcesses())) {
            // 프로세스를 처리한다.
            System.out.println("Case2 프로세스 PID: " + ph.pid());
            break;
        }

        // 람다 표현식
        Iterable<ProcessHandle> iterableProcesses_1 = ProcessHandle.allProcesses()::iterator;
        // iterator() 메서드 호출
        Iterable<ProcessHandle> iterableProcesses_2 = () -> ProcessHandle.allProcesses().iterator();

        for (ProcessHandle ph : iterableProcesses_1) {
            // 프로세스를 처리한다.
            System.out.println("Case3 프로세스 PID: " + ph.pid());
            break;
        }

        for (ProcessHandle ph : iterableProcesses_2) {
            // 프로세스를 처리한다.
            System.out.println("Case3 프로세스 PID: " + ph.pid());
            break;
        }

        for (ProcessHandle ph : ProcessHandle.allProcesses().toList()) {
            System.out.println("Case4 프로세스 PID: " + ph.pid());
            break;
        }
    }

    // Stream 을 Iterable 로 변환하는 어댑터를 정의
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }
}
