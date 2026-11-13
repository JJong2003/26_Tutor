import javax.swing.*;
import java.awt.*;

// [코드 읽기 문제] 이 프로그램이 만드는 창의 모양을 실행하기 전에 예상해보세요.
// 코드는 수정하지 마세요. 아래 질문의 "예상 답"만 적으면 됩니다.
//
// 1. 실행하기 전에 두 가지 그림을 그립니다. README의 "그림 그리는 방법"을 참고하세요.
//    - 창 그림: 버튼과 레이블이 창의 어디에 어떤 크기로 보이는지
//    - 포함 관계 그림: 어느 컨테이너 안에 어떤 컴포넌트가 들어 있는지
// 2. 아래 질문에 예상 답을 적습니다.
// 3. 실행해서 내 그림과 비교합니다. 창의 크기를 바꿔보면서 질문 3도 확인합니다.
// 4. 예상과 다른 점이 있으면 "예상과 다른 점"에 적습니다. 없으면 "없음"이라고 적습니다.
//
// 질문 1. B1~B5는 몇 줄 몇 칸으로 놓이나요? 빈 칸이 있다면 어디인가요?
// 예상 답:
//
// 질문 2. frame 안에 직접 들어 있는 컴포넌트는 몇 개인가요? (패널 안에 들어 있는 것은 세지 않습니다.)
// 예상 답:
//
// 질문 3. 창의 가로 폭을 늘리면 New, Open, Save 버튼과 B1~B5 버튼의 크기는 각각 어떻게 되나요?
// 예상 답:
//
// 예상과 다른 점:
public class Q02_NestedPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Q02");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel top = new JPanel();
        top.add(new JButton("New"));
        top.add(new JButton("Open"));
        top.add(new JButton("Save"));

        JPanel center = new JPanel(new GridLayout(2, 3));
        for (int i = 1; i <= 5; i++) {
            center.add(new JButton("B" + i));
        }

        JLabel status = new JLabel("Ready");

        frame.add(top, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(status, BorderLayout.SOUTH);

        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}
