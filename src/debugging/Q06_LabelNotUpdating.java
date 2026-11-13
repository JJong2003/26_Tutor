import javax.swing.*;
import java.awt.*;

// [디버깅 문제] 이 코드는 오류 없이 실행되지만 화면이 요구사항과 다릅니다.
// 요구사항: +1 버튼을 누를 때마다 화면의 숫자가 1씩 늘어난다.
//
// 기대 화면 (+1을 세 번 누른 뒤):
//   +-------------------+
//   |     [+1]  3       |
//   +-------------------+
//
// +1 버튼을 여러 번 눌러보고 콘솔 출력과 화면을 비교하세요.
// 2주차처럼 변수와 객체를 그림(상자와 화살표)으로 그려보면 원인을 찾기 쉽습니다.
// 수정 후, 원인을 아래 주석에 한 줄로 적어주세요.
//
// 원인:
public class Q06_LabelNotUpdating {

    public static void main(String[] args) {
        CounterFrame frame = new CounterFrame();
    }

    static class CounterFrame extends JFrame {
        int count = 0;
        JLabel label = new JLabel("0");

        CounterFrame() {
            setTitle("Q06");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

            JButton plus = new JButton("+1");
            plus.addActionListener(e -> increase());

            JLabel label = new JLabel("0");

            add(plus);
            add(label);

            setSize(250, 100);
            setVisible(true);
        }

        void increase() {
            count++;
            label.setText(String.valueOf(count));
            System.out.println("count = " + count);
        }
    }
}
