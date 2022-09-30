package 입문;

import java.util.*;
public class 게시판 {
    public static void main(String[] args) {
        게시판 solution = new 게시판();
        solution.solution();
    }

    public void solution(){
        System.out.println(" ### 게시판 ### \n");
        Scanner scanner = new Scanner(System.in);

        String[] board = new String[4];
        board = init(board);
        int emptycount = 4;
        int lastIndex = -1; //인덱스 0은 이미 존재하는 상황이므로

        while(true){
            System.out.println("[메뉴] 0.종료 1.글쓰기 2. 글목록 3. 글삭제");
            String menu = scanner.next();

            switch(menu){
                case "0" :
                    System.out.println("종료합니다.");
                    return;
                case "1" :
                    System.out.println("글쓰기");
                    if(emptycount <= 0){
                        System.out.println(" === 게시판 용량(4개)이 가득 찼습니다. === ");
                    }
                    else{
                        lastIndex++;
                        board = write(board, emptycount, scanner);
                        emptycount--;
                    }
                    break;
                case "2" :
                    System.out.println("글목록");
                    board = list(board);
                    break;
                case "3" : 
                if(emptycount == 3){
                    System.out.println(" === 삭제할 글이 없습니다. === ");
                }
                else{
                    board = delete(board, lastIndex, scanner);
                    emptycount++;
                    lastIndex--;
                }
                    break;
                default:
                    System.out.println("없는 메뉴입니다. 다시 선택해주세요");
            }
        }
    }

    /**
     * 배열 초기화
     */
    public String[] init(String[] board){
        for(int i = 0; i < board.length; i++){
            board[i] = "";
        }

        return board;
    }

    /**
     * 글쓰기
     */
    public String[] write(String[] board, int lastIndex, Scanner scanner){
        
        System.out.println(" === 글을 작성해 주세요 === ");
        scanner.nextLine(); //스캐너 버그 때문에
        String message = scanner.nextLine();
        board[lastIndex] = message;
        
        return board;
    }

    /**
     * 글목록
     */
    public String[] list(String[] board){
        for(int i = 0; i < board.length; i++){
            System.out.println(String.format("[%d]번 게시글 : %s", i + 1, board[i]));
        }
        return board;
    }

    /**
     * 글삭제
     */
    public String[] delete(String[] board, int lastIndex, Scanner scanner){
        System.out.println("몇번 글을 삭제하시겠습니까? : ");
        int deleteNumber = scanner.nextInt();
        System.out.println("마지막 인덱스 : " + lastIndex);
        
        board[deleteNumber - 1] = board[lastIndex];
        board[lastIndex] = "";

        return board;
    }    
}
