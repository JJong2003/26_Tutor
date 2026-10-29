// [직접 구현 문제] BankAccount 클래스의 입금/출금 메서드를 완성하세요.
// 요구사항:
//   deposit(amount)  : 잔액에 amount를 더한다. amount가 0 이하이면 아무것도 하지 않는다.
//   withdraw(amount) : 출금에 성공하면 잔액에서 amount를 빼고 true를 반환한다.
//                      amount가 0 이하이거나 잔액보다 크면 잔액을 바꾸지 않고 false를 반환한다.
//
// 예상 출력:
//   1500
//   false
//   true
//   1200
//   1200
//
// 코드를 쓰기 전에, 필요한 단계를 한국어로 먼저 적어보세요.
//   1.
//   2.
//   3.
public class Q09_BankAccount {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Kim", 1000);

        account.deposit(500);
        System.out.println(account.balance);

        System.out.println(account.withdraw(2000));
        System.out.println(account.withdraw(300));
        System.out.println(account.balance);

        account.deposit(-100);
        System.out.println(account.balance);
    }

    static class BankAccount {
        String owner;
        int balance;

        BankAccount(String owner, int balance) {
            this.owner = owner;
            this.balance = balance;
        }

        void deposit(int amount) {
            // TODO: amount가 0보다 클 때만 잔액에 더하세요.
        }

        boolean withdraw(int amount) {
            // TODO: 출금이 가능하면 잔액에서 빼고 true, 불가능하면 false를 반환하세요.
            return false;
        }
    }
}
