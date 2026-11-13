import javax.swing.*;
import java.awt.*;

// [직접 구현 문제] 2주차 Q09의 BankAccount를 버튼으로 사용하는 창을 완성하세요.
// 화면 배치와 BankAccount 클래스는 완성되어 있습니다. 버튼을 눌렀을 때 동작하는 부분만 작성합니다.
//
// 완성 화면 (시작 직후):
//   +---------------------------------------------+
//   | Balance: 1000                               |
//   |   Amount [        ] [Deposit] [Withdraw]    |
//   |                                             |   ← 메시지 표시 줄
//   +---------------------------------------------+
//
// 요구사항:
//   - Deposit: 입력한 금액을 입금하고, 잔액 표시를 바꾸고, 메시지를 비운다.
//   - Withdraw: 입력한 금액을 출금한다.
//       성공하면 잔액 표시를 바꾸고, 메시지를 비운다.
//       실패하면 잔액 표시는 그대로 두고, 메시지에 "Withdraw failed"를 표시한다.
//   - 잔액 계산은 BankAccount의 deposit(), withdraw()로만 한다. 이 창의 코드에서 balance를 직접 바꾸지 않는다.
//
// 예상 결과 (위에서부터 차례로 했을 때):
//   500 입력  → Deposit   →  Balance: 1500
//   2000 입력 → Withdraw  →  Balance: 1500, 메시지 "Withdraw failed"
//   300 입력  → Withdraw  →  Balance: 1200, 메시지 없음
//
// 코드를 쓰기 전에, Withdraw 버튼을 눌렀을 때 일어나야 할 일을 단계로 먼저 적어보세요.
//   1.
//   2.
//   3.
public class Q09_BankAccountGUI {

    public static void main(String[] args) {
        BankFrame frame = new BankFrame();
    }

    static class BankFrame extends JFrame {
        BankAccount account = new BankAccount("Kim", 1000);

        JLabel balanceLabel = new JLabel("Balance: " + account.balance);
        JTextField amountField = new JTextField(8);
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JLabel messageLabel = new JLabel("");

        BankFrame() {
            setTitle("Q09");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new GridLayout(3, 1));

            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("Amount"));
            inputPanel.add(amountField);
            inputPanel.add(depositButton);
            inputPanel.add(withdrawButton);

            add(balanceLabel);
            add(inputPanel);
            add(messageLabel);

            // TODO: depositButton을 누르면 depositClicked()가, withdrawButton을 누르면 withdrawClicked()가 실행되도록 리스너를 등록한다.

            setSize(380, 150);
            setVisible(true);
        }

        void depositClicked() {
            // TODO: 요구사항의 Deposit 동작을 작성한다.
            //       입력칸의 금액은 Integer.parseInt(amountField.getText())로 읽는다.
        }

        void withdrawClicked() {
            // TODO: 요구사항의 Withdraw 동작을 작성한다.
        }
    }

    // 2주차 Q09의 BankAccount와 같습니다.
    static class BankAccount {
        String owner;
        int balance;

        BankAccount(String owner, int balance) {
            this.owner = owner;
            this.balance = balance;
        }

        void deposit(int amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        boolean withdraw(int amount) {
            if (amount <= 0 || amount > balance) {
                return false;
            }
            balance -= amount;
            return true;
        }
    }
}
