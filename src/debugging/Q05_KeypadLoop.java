import javax.swing.*;
import java.awt.*;

// [디버깅 문제] 이 코드는 오류 없이 실행되지만 화면이 요구사항과 다릅니다.
// 요구사항: 1부터 9까지 버튼 9개가 3줄 3칸으로 보인다.
//
// 기대 화면:
//   +-------------------+
//   |  [1]  [2]  [3]    |
//   |  [4]  [5]  [6]    |
//   |  [7]  [8]  [9]    |
//   +-------------------+
//
// 실행해서 화면과 콘솔 출력을 확인하세요.
// add를 9번 했는데 왜 이렇게 보이는지 원인을 찾아 수정하세요.
// 2주차처럼 변수와 객체를 그림(상자와 화살표)으로 그려보면 원인을 찾기 쉽습니다.
// 수정 후, 원인을 아래 주석에 한 줄로 적어주세요.
//
// 원인:
public class Q05_KeypadLoop {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Q05");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel keypad = new JPanel(new GridLayout(3, 3));
        JButton button = new JButton();

        for (int i = 1; i <= 9; i++) {
            button.setText(String.valueOf(i));
            keypad.add(button);
        }

        System.out.println("buttons in keypad: " + keypad.getComponentCount());

        frame.add(keypad, BorderLayout.CENTER);
        frame.setSize(240, 240);
        frame.setVisible(true);
    }
}
