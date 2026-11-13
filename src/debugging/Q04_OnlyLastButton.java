import javax.swing.*;
import java.awt.*;

// [디버깅 문제] 이 코드는 오류 없이 실행되지만 화면이 요구사항과 다릅니다.
// 요구사항: Red, Green, Blue 버튼 3개가 창 안에 가로로 나란히 보인다.
//
// 기대 화면:
//   +-----------------------------+
//   |    [Red] [Green] [Blue]     |
//   +-----------------------------+
//
// 실행해서 화면과 콘솔 출력을 확인하세요.
// 버튼 3개를 모두 add 했는데 왜 이렇게 보이는지 원인을 찾아 수정하세요.
// 수정 후, 원인을 아래 주석에 한 줄로 적어주세요.
//
// 원인:
public class Q04_OnlyLastButton {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Q04");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton red = new JButton("Red");
        JButton green = new JButton("Green");
        JButton blue = new JButton("Blue");

        frame.add(red);
        frame.add(green);
        frame.add(blue);

        System.out.println("components in frame: " + frame.getContentPane().getComponentCount());

        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
