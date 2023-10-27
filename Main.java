import java.util.*;

public class Main {

    //전역변수로 사용하기 위해 menuAndID, catecoryID를 위로 뺐습니다.
    public static Map<String, Items> menuAndID = new HashMap<>();
    public static Map<String, String> categoryID = new HashMap<>();

    public static void main(String[] args) {
        // 버거 메뉴   ->  전체메뉴 menuAndID<ID,Items> , 카테고리묶는 맵<ID,카테고리>
        // 음료 메뉴   ->
        // 디저트 메뉴 ->





        //이거로 출력 메서드 만들기 --> categoryID의 밸류가 burger이면 burger메뉴화면에 출력
        //추가 할 때도 여기에 추가하는 메서드를 만들면

//주문 시작 지점
        List<Items> orderList =  new ArrayList<>();
        Page start = new Page();
        start.mainPageMethod(menuAndID,categoryID,orderList);
    }

    public void addMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("메뉴 추가 페이지\n");
        System.out.println("음식 카테고리(String), 음식 이름(String), 음식 설명(String), 가격(long), 음식 ID(String)을 입력합니다.");

        System.out.print("음식 카테고리(String): ");
        String category = scanner.nextLine();
        System.out.print("음식 이름(String): ");
        String name = scanner.nextLine();
        System.out.print("음식 설명(String): ");
        String description = scanner.nextLine();
        System.out.print("가격(long): ");
        long price = scanner.nextLong();   //////////////////이거 long타입 아니어도 오류 안뜨게 도움 받아서 바꿔볼 것
        scanner.nextLine();
        System.out.print("음식 ID(String): ");
        String id = scanner.nextLine();

        addMenuCheck(category, name, description, price, id);
    }

    public void addMenuCheck(String category, String name, String description, long price, String id) {

        System.out.println("이 내용으로 추가 하시겠습니까?");
        System.out.println("카테고리: " + category + ", 이름: " + name + ", 설명: " + description + ", 가격: " + price + ", ID: " + id + "\n");
        System.out.println("1. 추가  2. 다시입력  3. 취소");

        Scanner scanner = new Scanner(System.in);
        String yesOrNo = scanner.nextLine();
        if (yesOrNo.equals("1")) {
            menuAndID.put(id, new Items(name, description, price));
            categoryID.put(id, category);
            System.out.println("메뉴가 추가되었습니다.\n");
        } else if (yesOrNo.equals("2")) {
            addMenu();
        } else if (yesOrNo.equals("3")) {
            System.out.println("취소 되었습니다.");
            //첫 화면 실행 메서드 복붙!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        } else {
            System.out.println("다시 입력하세요.");
            addMenuCheck(category,name,description,price,id);
        }
    }

    public void delMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("메뉴 삭제 페이지");
        System.out.println("삭제 할 음식의 ID를 입력하세요.\n");

        for (Map.Entry<String, Items> entry : menuAndID.entrySet()) {
            System.out.println(entry.getValue().name + " | ID:" + entry.getKey());
        }

        String inputID = scanner.nextLine();
        delMenuCheck(inputID);
    }

    public void delMenuCheck(String id) {

                for(Map.Entry<String, Items> entry : menuAndID.entrySet()) {
                    if (entry.getKey().equals(id)) {
                        System.out.println("정말 삭제 하시겠습니까?");
                        System.out.println("1. 삭제  2. 취소");

                        Scanner scanner = new Scanner(System.in);
                        String yesOrNo = scanner.nextLine();
                        if (yesOrNo.equals("1")) {
                            menuAndID.remove(id);
                            categoryID.remove(id);
                            System.out.println("메뉴가 삭제되었습니다\n");
                            delMenu();///////////////////////////////////////////첫화면으로 가는 메서드로 바꾸기
                        } else if (yesOrNo.equals("2")) {
                            System.out.println("취소되었습니다.\n");
                            delMenu();////////////////////////////////////////첫화면으로 가는 메서드로 바꾸기
                        } else {
                            System.out.println("다시 입력하세요.");
                            delMenuCheck(id);
                        }
                    }
                }


        System.out.println("ID가 일치하지 않습니다.\n");
        delMenu();
    }
}

