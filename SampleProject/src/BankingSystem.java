import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10]; // 최대 10개의 계좌를 저장할 배열
        int accountCount = 0; // 현재 생성된 계좌 수를 추적

        while (true) {
            try {
                // 메뉴 출력
                System.out.println("1. 계좌 생성");
                System.out.println("2. 현금 입금");
                System.out.println("3. 현금 출금");
                System.out.println("4. 잔고 조회");
                System.out.println("5. 나가기");
                System.out.print("번호를 선택하세요: ");

                int choice = scanner.nextInt(); // 사용자 메뉴 선택 입력
                scanner.nextLine(); // 개행 문자 제거

                switch (choice) {
                    case 1:
                        if(accountCount>=10) {
                    	   System.out.println("더이상 계좌를 생성할 수 없습니다. 최대 10개의 계좌만 생성 가능합니다!");
                    	   break;
                        }
                        System.out.print("계좌 번호를 입력하세요: ");
                        int accountNumber = scanner.nextInt();
                        scanner.nextLine(); // 개행 문자 제거

                        System.out.print("예금주 이름을 입력하세요: ");
                        String name = scanner.nextLine();

                        accounts[accountCount] = new Account(accountNumber, name, 0.0); // 초기 잔고는 0으로 설정
                        accountCount++;
                        System.out.println("새 계좌가 성공적으로 생성되었습니다.");
                        break;
                    case 2:
                        System.out.print("입금할 계좌 번호를 입력하세요: ");
                        int depositAccountNumber = scanner.nextInt();
                        scanner.nextLine(); // 개행 문자 제거
                        Account depositAccount = findAccount(accounts, depositAccountNumber);
                        if (depositAccount != null) {
                            System.out.print("입금할 금액을 입력하세요: ");
                            double amount = scanner.nextDouble();
                            depositAccount.deposit(amount);
                        } 
                        else {
                            System.out.println("계좌를 찾을 수 없습니다.");
                        }
                        break;

                    case 3:
                        System.out.print("출금할 계좌 번호를 입력하세요: ");
                        int withdrawAccountNumber = scanner.nextInt();
                        scanner.nextLine(); // 개행 문자 제거

                        Account withdrawAccount = findAccount(accounts, withdrawAccountNumber);
                        if (withdrawAccount != null) {
                            System.out.print("출금할 금액을 입력하세요: ");
                            double amount = scanner.nextDouble();
                            withdrawAccount.withdraw(amount);
                        } 
                        else {
                            System.out.println("계좌를 찾을 수 없습니다.");
                        }
                        break;

                    case 4:
                        System.out.print("잔고를 확인할 계좌 번호를 입력하세요: ");
                        int balanceAccountNumber = scanner.nextInt();
                        scanner.nextLine(); // 개행 문자 제거

                        Account balanceAccount = findAccount(accounts, balanceAccountNumber);
                        if (balanceAccount != null) {
                            System.out.println("예금주: " + balanceAccount.getAccountHolderName());
                            System.out.println("현재 잔액: " + balanceAccount.getBalance() + "원");
                        } 
                        else {
                            System.out.println("계좌를 찾을 수 없습니다.");
                        }
                        break;

                    case 5:
                        System.out.println("시스템을 종료합니다.");
                        scanner.close();
                        return; // 프로그램 종료

                    default:
                        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                }
            } catch (InputMismatchException e) {
                // 잘못된 입력 형식에 대한 예외 처리
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                scanner.nextLine(); // 잘못된 입력을 버리고 다음 입력을 받기 위해 개행 제거
            } catch (Exception e) {
                // 기타 예외 처리
                System.out.println("오류가 발생했습니다: " + e.getMessage());
            }
        }
    }

    // 계좌를 검색하여 반환하는 메서드
    public static Account findAccount(Account[] accounts, int accountNumber) {
        for (Account account : accounts) { 
            if (account != null && account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null; // 계좌를 찾을 수 없을 때 null 반환
    }
}


// Account class
class Account {
    private int accountNumber;//계좌번호
    private String accountHolderName;//예금주 이름
    private double balance;//잔액

    // Constructor
    public Account(int accNum, String name, double bal) {
        // 필드 값 초기화
    	this.accountNumber=accNum;
    	this.accountHolderName=name;
    	this.balance=bal;
    }

    // Deposit method
    public void deposit(double amount) {
        // balance 업데이트
    	if(amount>0) {
    		this.balance+=amount;
    		System.out.println(amount+"원이 정상적으로 입금되었습니다.");
    	}
    	else {
    		System.out.println("입금 금액은 0보다 커야 합니다.");
    	}
    }

    // Withdraw method
    public void withdraw(double amount) {
        // balance 업데이트
    	if(amount>0&&amount<=balance) {
    		this.balance-=amount;
    		System.out.println(amount+"원이 출금되었습니다.");
    	}
    	else {
    		System.out.println("출금 금액이 잘못되었거나 잔액이 부족합니다.");
    	}
    }

    // Getters
    public int getAccountNumber() {
        // 계좌 번호 반환
    	return accountNumber;
    }

    public String getAccountHolderName() {
        // 예금주 이름 반환
    	return accountHolderName;
    }

    public double getBalance() {
        // 잔고 반환
    	return balance;
    }
}
