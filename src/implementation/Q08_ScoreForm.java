import javax.swing.*;
import java.awt.*;

// [직접 구현 문제] 이름과 점수를 입력하고 Check 버튼을 누르면 결과를 보여주는 창을 완성하세요.
// 결과 글자는 2주차 Q06에서 만든 Student 클래스로 만듭니다. (Student는 아래에 완성되어 있습니다.)
//
// 완성 화면 (Kim, 85를 입력하고 Check를 누른 뒤):
//   +-----------------------------------+
//   | Name             [Kim           ] |
//   | Score            [85            ] |
//   | [     Check    ] Kim: 85 (PASS)   |
//   +-----------------------------------+
//
// 요구사항:
//   - Check를 누르면 입력칸의 이름과 점수로 Student 객체를 만들고, 그 객체의 info() 결과를 resultLabel에 표시한다.
//   - 이름 Lee, 점수 40을 넣고 Check를 누르면 "Lee: 40 (FAIL)"이 표시된다.
//   - (4단계) 점수 칸에 숫자가 아닌 값(예: abc)을 넣고 Check를 누르면 "Score must be a number"가 표시된다.
//
// 아래 순서대로 한 단계씩 만들고, 단계가 끝날 때마다 실행해서 확인하세요.
public class Q08_ScoreForm {

    public static void main(String[] args) {
        ScoreFrame frame = new ScoreFrame();
    }

    static class ScoreFrame extends JFrame {
        JTextField nameField = new JTextField(10);
        JTextField scoreField = new JTextField(10);
        JButton checkButton = new JButton("Check");
        JLabel resultLabel = new JLabel("");

        ScoreFrame() {
            setTitle("Q08");
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            // TODO 1단계: 배치 관리자를 3줄 2칸 GridLayout으로 바꾸고, 완성 화면처럼 컴포넌트 6개를 순서대로 넣는다.
            //            "Name", "Score" 글자는 JLabel로 만든다.

            // TODO 2단계: checkButton을 누르면 check()가 실행되도록 리스너를 등록한다.
            //            check() 안에 System.out.println("clicked"); 를 잠깐 넣고, 누를 때마다 출력되는지 확인한다.

            setSize(300, 130);
            setVisible(true);
        }

        void check() {
            // TODO 3단계: 입력칸의 이름과 점수를 읽어 Student 객체를 만들고, 그 객체의 info() 결과를 resultLabel에 표시한다.
            //            입력칸의 글자는 getText()로 읽는다. 점수는 문자열이므로 Integer.parseInt(...)로 int로 바꾼다.

            // TODO 4단계 (선택): 점수 칸에 숫자가 아닌 값이 있으면 resultLabel에 "Score must be a number"를 표시한다.
            //                   먼저 abc를 넣고 Check를 눌러 콘솔에 어떤 예외가 출력되는지 확인해보세요.
        }
    }

    // 2주차 Q06의 Student와 같습니다.
    // printInfo()는 콘솔에 출력하므로, 대신 결과 글자를 반환하는 info()를 넣었습니다.
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        boolean isPass() {
            return score >= 60;
        }

        String info() {
            String label = isPass() ? "PASS" : "FAIL";
            return name + ": " + score + " (" + label + ")";
        }
    }
}
