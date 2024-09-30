import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10];

      // While 구문을 이용해서 
      // Scanner로부터 입력을 받아들이고 사용자의 선택에 따라
      // Banking System의 역할을 수행한다. 
      // 사용자가 선택할 수 있는 선택은 다섯가지이다. 
      // 1. 새로운 어카운트 생성, 2. 현금 입금, 3. 현금 출금
      // 4. 잔고 조회
      // 5. 나가기
      // 사용자가 "5. 나가기"를 선택하기 전까지 While 반복을 수행한다 (무한투프).
      
        while (true) {
            // Display menu
            // 1. 계좌 생성
            // 2. 현금 입금
            // 3. 현금 출금
            // 4. 잔고 조회
            // 5. 나가기

            // Handle user choice
            switch (choice) {
                case 1:
                    // Create new account
                    // 계좌번호 (integer)와 예금주 이름 (String)을 입력 받는다. 
                    // 처음 잔고는 0.0 (double)로 한다. 
                    // 계좌의 개수가 10이 넘어가면 에러 메시지를 출력한다. 
                case 2:
                    // Deposit money
                    // 계좌번호와 금액을 입력 받는다. 
                    // 계좌번호가 없거나 금액이 음수이면 에러 메시지를 출력한다.
                    System.out.print("Enter Account Number: ");
                case 3:
                    // Withdraw money
                    // 계좌번호와 금액을 입력 받는다.
                    // 계좌번호가 없거나 금액이 음수이거나 잔고보다 크면 에러 메시지를 출력한다. 
                case 4:
                    // Check balance
                    // 계좌번호를 입력받는다.
                    // 계좌가 존재하면 예금주와 잔고를 출력한다. 
                    // 그렇지 않은 경우 에러메시지를 출력한다. 
                case 5:
                    // Exit
                    // 시스템을 종료한다는 메시지를 출력한다.
                    // Scanner를 close한다. 
                default:
                    // Invalid choice
                    // 에러 메시지를 출력한다.
            }
          // choice가 5였으면 while을 빠져나온다. 
        }
    }

    // Method to find an account by account number
    public static Account findAccount(Account[] accounts, int accountNumber) {
      // for를 사용해서 accounts index가 accounts.length보다 적은 경우
      // accounts[i]가 null이 아니고 accounts[i]의 account number가 accountNumber와 같은 경우
      // accounts[i]를 return한다. 
      
      // 그렇지 않은 경우 null을 return한다. 
    }
}

// Account class
class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public Account(int accNum, String name, double bal) {
        // 필드 값 초기화
    }

    // Deposit method
    public void deposit(double amount) {
        // balance 업데이트
    }

    // Withdraw method
    public void withdraw(double amount) {
        // balance 업데이트
    }

    // Getters
    public int getAccountNumber() {
        // 계좌 번호 반환
    }

    public String getAccountHolderName() {
        // 예금주 이름 반환
    }

    public double getBalance() {
        // 잔고 반환
    }
}
