import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10];
        int i=0;
        int AccountCount=i;
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
        	System.out.println("1번 계좌 생성,2번 입금,3번 출금,4번 잔고 조회,5번 종료입니다.");
        	System.out.print("번호를 입력해주세요: ");
        	int choice=scanner.nextInt();
            // Handle user choice
            switch (choice) {
                case 1:
                    // Create new account
                	if(AccountCount>=10) {
                		System.out.print("계좌 생성 한도가 넘어갔습니다.");
                		System.out.print("다시 시도 해주세요.");
                		break;
                	}
                	System.out.print("생성할 계좌 번호를 입력해주세요: ");
                	int newaccountnumber=scanner.nextInt();
                	//계좌 중복 검사 필요
                	if(i>0) {
                		Account duplication=findAccount(accounts,newaccountnumber);
                    	if(duplication!=null) {
                    		System.out.println("중복된 계좌 번호입니다. 다시 시도해주세요!");
                    		break;
                    	}
                	}
                	scanner.nextLine();
                	System.out.print("예금주 이름을 입력해주세요: ");
                	String depositorname=scanner.nextLine();
                    // 계좌번호 (integer)와 예금주 이름 (String)을 입력 받는다.
                	accounts[i]=new Account(newaccountnumber,depositorname,0.0);
                    // 처음 잔고는 0.0 (double)로 한다. 
                    // 계좌의 개수가 10이 넘어가면 에러 메시지를 출력한다. 
                	i++;
                	System.out.println("성공적으로 계좌가 생성되었습니다!");
                	break;
                case 2:
                    // Deposit money
                	System.out.print("입금할 계좌 번호를 입력해주세요: ");
                	int addaccountnumber=scanner.nextInt();
                	if(addaccountnumber<=0) {
                		System.out.println("잘못된 입력입니다. 다시 시도해주세요!");
                		break;
                	}
                	Account addfindnumber=findAccount(accounts,addaccountnumber);
                	scanner.nextLine();
                	System.out.print("입금할 금액을 입력해주세요: ");
                	int depositamount=scanner.nextInt();
                	if(depositamount<0) {
                		System.out.println("잘못된 입력입니다. 다시 시도해주세요!");
                		break;
                	}
                	addfindnumber.deposit(depositamount);
                	System.out.println("성공적으로 입금이 완료되었습니다.");
                	break;
                    // 계좌번호와 금액을 입력 받는다. 
                    // 계좌번호가 없거나 금액이 음수이면 에러 메시지를 출력한다.
                case 3:
                    // Withdraw money
                    // 계좌번호와 금액을 입력 받는다.
                    // 계좌번호가 없거나 금액이 음수이거나 잔고보다 크면 에러 메시지를 출력한다. 
                	System.out.print("출금할 계좌 번호를 입력해주세요: ");
                	int removeaccountnumber=scanner.nextInt();
                	if(removeaccountnumber<=0) {
                		System.out.println("잘못된 입력입니다. 다시 시도해주세요!");
                		break;
                	}
                	Account removefindnumber=findAccount(accounts,removeaccountnumber);
                	scanner.nextLine();
                	System.out.print("출금할 금액을 입력해주세요: ");
                	int withdrawamount=scanner.nextInt();
                	if(withdrawamount<0||withdrawamount>removefindnumber.getBalance() ) {
                		System.out.println("잘못된 입력또는 잔액 부족입니다. 다시 시도해주세요!");
                		break;
                	}
                	removefindnumber.withdraw(withdrawamount);
                	System.out.println("성공적으로 출금되었습니다.");
                	break;
                case 4:
                    // Check balance
                    // 계좌번호를 입력받는다.
                    // 계좌가 존재하면 예금주와 잔고를 출력한다. 
                    // 그렇지 않은 경우 에러메시지를 출력한다. 
                	System.out.print("잔고 조회할 계좌 번호를 입력해주세요: ");
                	int searchnumber=scanner.nextInt();
                	scanner.nextLine();
                	Account find=findAccount(accounts,searchnumber);
                	if(find!=null) {
                		System.out.print("잔고에 남은 금액은: ");
                		double deposit=find.getBalance();
                		System.out.print(deposit);
                	}
                	else {
                		System.out.print("계좌가 존재하지 않습니다. 다시 시도해주세요!");
                		break;
                	}
                	break;
                
                case 5:
                    // Exit
                    // 시스템을 종료한다는 메시지를 출력한다.
                    // Scanner를 close한다. 
                	System.out.println("시스템을 종료합니다.");
                	scanner.close();
                	break;
                default:
                    // Invalid choice
                    // 에러 메시지를 출력한다.
                	System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                	break;
            }
          // choice가 5였으면 while을 빠져나온다. 
        }
    }

    // Method to find an account by account number
    public static Account findAccount(Account[] accounts, int accountNumber) {
      // for를 사용해서 accounts index가 accounts.length보다 적은 경우
      // accounts[i]가 null이 아니고 accounts[i]의 account number가 accountNumber와 같은 경우
      // accounts[i]를 return한다. 
    	for(int i=0;i<accounts.length;i++) {
    		if(accounts[i].getAccountNumber()==accountNumber) {
    			return accounts[i];
    		}
    	}
    	
      return null;
      // 그렇지 않은 경우 null을 return한다. 
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
    	this.balance+=amount;
    }

    // Withdraw method
    public void withdraw(double amount) {
        // balance 업데이트
    	this.balance-=amount;
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
