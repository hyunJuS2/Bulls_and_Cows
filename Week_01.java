import java.util.Scanner;

// 0~9 까지 중복 없는 숫자 3개 -> 배열 int[] a = new int[3];
// Math.random -> 0 ~ 1 전 까지의 난수 -> double
// Math.random *10 ->0~9.fsdfsd - >int 형변환
// 숫자의 값과 위치가 모두 일치하면 S
// 숫자의 값은 일치하지만 위치가 틀렸으면 B
// 기회는 무제한, 몇번의 시도 후에 맞췄는지 기록 -> while(true) if()
    public class Week_01 {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int[] computer = new int[3];
            int[] input = new int[3];

            int count = 0;
            int S = 0;
            int B = 0;

            // 컴퓨터의 중복 없는 숫자 3개 가져오기
            for (int i = 0; i < computer.length; i++) {
                computer[i] = (int)(Math.random() * 10); //중복 computer[0] = 1 computer[1] = 2 computer [3] = 4
                for (int j = 0; j < i; j++) { //
                    if(computer[j] == computer[i]){
                        i--;
                    } else {
                        break;
                    }
                }
            }
            System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

            for(int num : computer){
                System.out.println(num);
            }

            while(true){

                count ++;

                System.out.print(count + "번째 시도: ");
                String[] inputNum = scanner.next().split("");

                for (int i = 0; i < inputNum.length; i++) {
                    input[i] = Integer.parseInt(inputNum[i]);
                }

                for (int i = 0; i < computer.length; i++) {
                    for (int j = 0; j < inputNum.length ; j++) {
                        if(computer[i] == input[j] && i == j) {
                            S++;
                        } else if (computer[i] == input[j] && i != j ){
                            B++;
                        }
                    }
                }


                if(S == 0){
                    System.out.println(B+"B");
                }
                if(B == 0){
                    System.out.println(S +"S");
                }
                else{
                    System.out.println(S +"S"+B+"B");
                }


                if(S == 3){
                    break;
                }
                S = 0;
                B = 0;
            }
            System.out.println(count +"번만에 맞히셨습니다.");
            System.out.println("게임을 종료합니다.");
        }
    }
/*
컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!
1번째 시도 : 134
0B0S
2번째 시도 : 238
1B1S
3번째 시도 : 820
2B1S
4번째 시도 : 028
3B
5번째 시도 : 280
3S
4번만에 맞히셨습니다.
게임을 종료합니다.
 */

