import javax.swing.*;
import java.awt.*;

// [코드 읽기 문제] 이 프로그램이 만드는 창의 모양을 실행하기 전에 예상해보세요.
// 코드는 수정하지 마세요. 아래 질문의 "예상 답"만 적으면 됩니다.
//
// 1. 실행하기 전에 창 모양을 종이에 그립니다. 버튼마다 위치와 대략적인 크기가 보이게 그립니다.
// 2. 아래 질문에 예상 답을 적습니다.
// 3. 실행해서 내 그림과 비교합니다. 창의 모서리를 마우스로 끌어 크기를 바꿔보면서 질문 3, 4도 확인합니다.
// 4. 예상과 다른 점이 있으면 "예상과 다른 점"에 적습니다. 없으면 "없음"이라고 적습니다.
//
// 질문 1. 가장 큰 버튼은?
// 예상 답:
//
// 질문 2. 아무것도 넣지 않은 EAST 자리는 어떻게 보이나요?
// 예상 답:
//
// 질문 3. 창의 가로 폭만 늘리면 폭이 함께 늘어나는 버튼은? (모두 적기)
// 예상 답:
//
// 질문 4. 창의 세로 높이만 늘리면 높이가 함께 늘어나는 버튼은? (모두 적기)
// 예상 답:
//
// 예상과 다른 점:
public class Q01_BorderLayout {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Q01");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JButton("A"), BorderLayout.SOUTH);
        frame.add(new JButton("B"), BorderLayout.CENTER);
        frame.add(new JButton("C"), BorderLayout.WEST);
        frame.add(new JButton("D"), BorderLayout.NORTH);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
