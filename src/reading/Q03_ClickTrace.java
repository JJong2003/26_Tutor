import javax.swing.*;
import java.awt.*;

// [코드 읽기 문제] main의 실행 결과를 예상하여 myAnswer에 적어보세요.
// 다른 코드는 수정하지 마세요. myAnswer 값만 수정하면 됩니다.
//
// main은 버튼을 A → B → A 순서로 누릅니다. doClick()은 사람이 클릭한 것처럼 코드로 버튼을 누르는 메서드입니다.
// 세 번 누른 뒤 label에 보이는 글자를 예상하세요.
//
// 풀기 전에 아래 표를 채우면서 count와 label의 글자가 어떻게 바뀌는지 따라가 보세요.
//
//   시점                    count    label의 글자
//   TraceFrame을 만든 직후
//   A를 누른 뒤
//   B를 누른 뒤
//   A를 누른 뒤
//
// 실행하면 창이 열립니다. 정답을 확인한 뒤 버튼을 직접 더 눌러보면서 예상대로 바뀌는지 확인해도 좋습니다.
public class Q03_ClickTrace {

    public static void main(String[] args) {
        TraceFrame frame = new TraceFrame();

        frame.buttonA.doClick();
        frame.buttonB.doClick();
        frame.buttonA.doClick();

        String result = frame.label.getText();
        String myAnswer = /* TODO */ "";

        System.out.println(result.equals(myAnswer));
    }

    static class TraceFrame extends JFrame {
        int count = 0;
        JLabel label = new JLabel("");
        JButton buttonA = new JButton("A");
        JButton buttonB = new JButton("B");

        TraceFrame() {
            setTitle("Q03");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

            buttonA.addActionListener(e -> {
                count = count + 1;
                label.setText("A" + count);
            });

            buttonB.addActionListener(e -> {
                count = count * 10;
                label.setText(label.getText() + "B" + count);
            });

            count = 5;
            label.setText("start");

            add(buttonA);
            add(buttonB);
            add(label);

            setSize(300, 100);
            setVisible(true);
        }
    }
}
