import java.util.*;
import java.util.Map.Entry;
public class Page {
    // hanjoon : 스캐너 값을 int로 치환하기 위한 코드
    Scanner scanner = new Scanner(System.in);
    private String inputString;
    private int input;
    private HashMap<String, Items> menuAndID;
    private HashMap<String, String> categoryID;
    List<Items> orderList;


    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    String mainPage = """
            ====================================================
             
             "SHAKESHACK BURGER 에 오신걸 환영합니다."
             아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.
                            
            [ SHAKESHACK MENU ]
            1. Burgers         | 앵거스 비프 통살을 다져만든 버거
            2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림
            3. Drinks          | 매장에서 직접 만드는 음료
                            
            [ ORDER MENU ]
            4. Order       | 장바구니를 확인 후 주문합니다.
            5. Cancel      | 진행중인 주문을 취소합니다.
            6. 프로그램 종료
            
            ====================================================
            """;
    String burgerPage = """
            ==============================================================================
             
             "SHAKESHACK BURGER 에 오신걸 환영합니다."
             아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.
                                
            [ Burgers MENU ]
            1. ShackBurger           | W 6.9  | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
            2. SmokeShack            | W 8.9  | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
            3. Shroom Burger         | W 9.4  | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거
            4. Shack Stack           | W 12.4 | 슈룸 버거와 쉑버거의 맛을 한번에 즐길 수 있는 메뉴
            5. Cheeseburger          | W 6.9  | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
            6. Hamburger             | W 5.4  | 비프패티를 기반으로 야채가 들어간 기본버거
                                
            [ ORDER MENU ]
            7. Order       | 장바구니를 확인 후 주문합니다.
            8. Cancel      | 진행중인 주문을 취소합니다.
                                
            9. 뒤로 가기
            
            ==============================================================================
            """;
    String frozenCustardPage = """
            ===============================================================================================
             
             "SHAKESHACK BURGER 에 오신걸 환영합니다."
             아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.
                                
            [ Forzen Custard MENU ]
            1. Shake                 | W 5.9  | 바닐라, 초콜렛, 솔티드 카라멜, 블랙& 화이트, 스트로베리, 피넛버터, 커피
            2. Shake of the Week     | W 6.5  | 특별한 커스터드 플레이버
            3. Red Bean Shake        | W 6.5  | 신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크
            4. Floats                | W 5.9  | 루트 비어, 퍼플 카우, 크림시클
            5. Cups&Cones            | W 4.9  | 바닐라, 초콜렛, Flavor of the Week
            6. Concretes             | W 5.9  | 쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합
                                
            [ ORDER MENU ]
            7. Order       | 장바구니를 확인 후 주문합니다.
            8. Cancel      | 진행중인 주문을 취소합니다.
                                
            9. 뒤로 가기
            
            ===============================================================================================
            """;
    String drinkPage = """
            ===============================================================================================
             
             "SHAKESHACK BURGER 에 오신걸 환영합니다."
             아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.
                                
            [ Drinks MENU ]
            1. Shack-made Lemonade   | W 3.9  | 매장에서 직접 만드는 상큼한 레몬에이드
            2. Fresh Brewed Ice Tea  | W 3.4  | 직접 유기농 홍차를 우려낸 아이스티
            3. Fifty/Fifty           | W 3.5  | 레몬에이트와 아이스티의 만남
            4. Fountain Soda         | W 2.7  | 코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프
            5. Abita Root Beer       | W 4.4  | 청량감 있는 독특한 미국식 무알콜 단산음료
            6. Bottled Water         | W 1.0  | 지리산 암반대수층으로 만든 프리미엄 생수
            7. ShackMeister Ale      | W 9.8  | 쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주
                                
            [ ORDER MENU ]
            8. Order       | 장바구니를 확인 후 주문합니다.
            9. Cancel      | 진행중인 주문을 취소합니다.
                                
            10. 뒤로 가기
            
            ===============================================================================================
            """;
    // hanjoon : 사용자가 입력한 값을 int로 바꿔주는 함수
    public static int kioskScanner(String scantest) {
        int num = 0;
        if(scantest.equals("kiosk")){
            return -2;
        } else if (scantest != null && scantest.matches("[-+]?\\d*\\.?\\d+")) {
            num = Integer.parseInt(scantest);
        } else {
            return -1;
        }
        return num;
    }

    // hanjoon : 메소드 하나로 뭉치기
    public void printAllMethod(Map<String,Items> menuAndID, Map<String, String> categoryID ,List<Items> orderList,int input) {
        // 고른 메뉴에 있는 item들 목록을 보여줌
        String inputToString = Integer.toString(input);
        int i = 0;
        for (Entry<String, String> elem : categoryID.entrySet()) {
            if (elem.getValue().equals(inputToString)) {
                System.out.println(i+1+". "+String.format("%-15s",menuAndID.get(elem.getKey()).name)+ "  |   "+String.format("%-15s",menuAndID.get(elem.getKey()).description)+ "  |   "+String.format("%-15s",menuAndID.get(elem.getKey()).price));
                i++;
            }
        }

        // 중복된 value값을 다 출력하고 order가 나오게?
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(i+1+". Order    |     장바구니를 확인 후 주문합니다.");
        System.out.println(i+2+". Cancle   |     진행중인 주문을 취소합니다.");
        System.out.println();
        System.out.println(i+3+". 뒤로 가기");
        System.out.print(">");
        inputString = scanner.next();
        input = kioskScanner(inputString);


        //menuAndID.remove("burger_1");
        //categoryID.remove("burger_1");
        //categoryID.put("burger_1","1");
        //menuAndID.put("burger_1",new Items("hh","ss",500));



        //orderlist에다가 추가만 해주면 끝!


    }




    public void initPage() {
        menuAndID = new HashMap<>();
        categoryID = new HashMap<>();
        orderList = new ArrayList<>();

        menuAndID.put("burger_1", new Items("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거!!!", 6900));
        menuAndID.put("burger_2", new Items("SmokeShack", "애플 우드 칩으로 훈연한 베이컨, 매콤한 체리 페퍼에 쉐소스가 토핑된 치즈 버거", 8900));
        menuAndID.put("burger_3", new Items("ShroomBurger", "몬스터 치즈와 체다 치즈로 속을 채우고 바삭하게 뒤겨낸 포토벨로 버섯 패티에 양상추, 토마토, 쇅소스를 올린 베지테리안 버거", 9400));
        menuAndID.put("burger_4", new Items("Shack Stack",
                "슈룸 버거와 쉑버거의 맛을 한번에 즐길 수 있는 메뉴",
                12400));
        menuAndID.put("burger_5", new Items("Cheeseburger",
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                6900));
        menuAndID.put("burger_6", new Items("Hamburger",
                "포테이토 번과 비프패티를 기본으로 신선한 양상추, 토마토 피클, 양파 토핑을 취향에 따라 선택할 수 있는 버거",
                5400));

        menuAndID.put("drink_1", new Items("Shake", "바닐라, 초콜렛, 솔티드 카라멜, 블랙& 화이트, 스트로베리, 피넛버터, 커피", 5900));
        menuAndID.put("drink_2", new Items("Shake of the Week", "특별한 커스터드 플레이버", 6500));
        menuAndID.put("drink_3", new Items("Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6500));
        menuAndID.put("drink_4", new Items("Floats", "루트 비어, 퍼플 카우, 크림시클", 5900));
        menuAndID.put("drink_5", new Items("Cups&Cones", "바닐라, 초콜렛, Flavor of the Week", 4900));
        menuAndID.put("drink_6", new Items("Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5900));

        menuAndID.put("dessert_1", new Items("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 3900));
        menuAndID.put("dessert_2", new Items("Fresh Brewed Ice Tea", "직접 유기농 홍차를 우려낸 아이스티", 3400));
        menuAndID.put("dessert_3", new Items("Fifty/Fifty", "레몬에이트와 아이스티의 만남", 3500));
        menuAndID.put("dessert_4", new Items("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2700));
        menuAndID.put("dessert_5", new Items("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 단산음료", 4400));
        menuAndID.put("dessert_6", new Items("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1000));
        menuAndID.put("dessert_7", new Items("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9800));


        categoryID.put("burger_1", "1");
        categoryID.put("burger_2", "1");
        categoryID.put("burger_3", "1");
        categoryID.put("burger_4", "1");
        categoryID.put("burger_5", "1");
        categoryID.put("burger_6", "1");
        categoryID.put("drink_1", "2");
        categoryID.put("drink_2", "2");
        categoryID.put("drink_3", "2");
        categoryID.put("drink_4", "2");
        categoryID.put("drink_5", "2");
        categoryID.put("drink_6", "2");
        categoryID.put("dessert_1", "3");
        categoryID.put("dessert_2", "3");
        categoryID.put("dessert_3", "3");
        categoryID.put("dessert_4", "3");
        categoryID.put("dessert_5", "3");
        categoryID.put("dessert_6", "3");
        categoryID.put("dessert_7", "3");

        mainPageMethod(menuAndID,categoryID, orderList);
    }




    public void mainPageMethod(Map<String,Items> menuAndID,Map<String, String> categoryID, List<Items> orderList) {
        System.out.println(mainPage);
        System.out.print(">");
        // hanjoon : 스캐너 값을 int로 치환하기 위한 코드
        inputString = scanner.next();
        input = kioskScanner(inputString);


        // hanjoon
        printAllMethod(menuAndID,categoryID,orderList,input);
         /*
            case 5:
                //orderClear(itemsList, orderList);
                break;
            case 6:
                System.out.println("[ 프로그램을 종료합니다... ]");
                break;
            // hanjoon : 잘못 입력 시 오류처리 / "kiosk" 입력 시 관리자 페이지 / default 값 설정
            case -1:
                System.out.println("[ 잘못된 문자 입력... ]");
                mainPageMethod(menuAndID,categoryID,orderList);
                break;
            case -2:
                System.out.println("관리자 페이지 출력 부분");
                mainPageMethod(menuAndID,categoryID,orderList);
                break;
            default:
                System.out.println("[ 잘못된 문자 입력... ]");
                mainPageMethod(menuAndID,categoryID,orderList);
                break;
            // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        }*/
    }
    public void burgerPageMethod(List<Items> itemsList, List<Items> orderList) {
        //Scanner scanner = new Scanner(System.in);
        System.out.println(burgerPage);
        System.out.print(">");
        // hanjoon : 스캐너 값을 int로 치환하기 위한 코드
        inputString = scanner.next();
        input = kioskScanner(inputString);
        // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        switch (input) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                addBurger(input, itemsList,  orderList);
                break;
            case 7:
                cartPage(itemsList, orderList);
                break;
            case 8:
                orderClear(itemsList, orderList);
                break;
            case 9:
                //mainPageMethod(itemsList, orderList);
                break;
            case -1:
                System.out.println("[ 잘못된 문자 입력... ]");
                burgerPageMethod(itemsList,orderList);
                break;
            case -2:
                System.out.println("관리자 페이지 출력 부분");
                //mainPageMethod(itemsList,orderList);
                break;
            default:
                System.out.println("[ 잘못된 문자 입력... ]");
                burgerPageMethod(itemsList,orderList);
                break;
        }
    }
    public void frozenCustardPageMethod(List<Items> itemsList, List<Items> orderList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(frozenCustardPage);
        System.out.print(">");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                addFrozenCustard(input, itemsList, orderList);
                break;
            case 7:
                cartPage(itemsList, orderList);
                break;
            case 8:
                orderClear(itemsList, orderList);
                break;
            case 9:
                //mainPageMethod(itemsList, orderList);
                break;
        }
    }
    public void drinkPageMethod(List<Items> itemsList, List<Items> orderList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(drinkPage);
        System.out.print(">");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                addDrink(input, itemsList, orderList);
                break;
            case 8:
                cartPage(itemsList, orderList);
                break;
            case 9:
                orderClear(itemsList, orderList);
                break;
            case 10:
                //mainPageMethod(itemsList, orderList);
                break;
        }
    }

    // 장바구니 페이지
    public void cartPage(List<Items> itemsList, List<Items> orderList) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0; // 주문금액 값 초기화

        System.out.println("[ 장바구니 ]");
        if (!orderList.isEmpty()) {
            for (Items items : orderList) {
                sum += items.price;
                System.out.printf("%s : %d%n", items.name, items.price);
            }
            System.out.printf("\n주문금액 : %d\n", sum);
            System.out.println("[ 1.주문하기 | 2.메뉴추가 ]");

            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("카드를 아래와 같이 넣어주세요");
                    System.out.print(">");
                    long payment = scanner.nextLong();
                    if (sum > payment) {
                        System.out.println("금액이 부족합니다");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (sum <= payment) {
                        System.out.println("주문해 주셔서 감사합니다");
                        System.out.println();
                        orderList.clear();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        //mainPageMethod(itemsList, orderList);
                        break;
                    }
                case 2:
                    //mainPageMethod(itemsList, orderList);
                    break;
            }

        } else {
            System.out.println("장바구니가 비어있습니다");
            System.out.println();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //mainPageMethod(itemsList, orderList);
        }
    }

    // 장바구니 초기화
    public void orderClear(List<Items> itemsList, List<Items> orderList) {
        orderList.clear();
        System.out.println("장바구니를 비웠습니다");
        System.out.println();System.out.println();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //mainPageMethod(itemsList, orderList);
    }

    public void addBurger(int input,List<Items> itemsList, List<Items> orderList) {
        orderList.add(0, itemsList.get(input-1));
        System.out.println("장바구니에 담겼습니다");
        System.out.println();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        burgerPageMethod(itemsList, orderList);
    }
    public void addFrozenCustard(int input,List<Items> itemsList, List<Items> orderList) {
        orderList.add(0, itemsList.get(99+input));
        System.out.println("장바구니에 담겼습니다");
        System.out.println();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        frozenCustardPageMethod(itemsList, orderList);
    }
    public void addDrink(int input,List<Items> itemsList, List<Items> orderList) {
        orderList.add(0, itemsList.get(199+input));
        System.out.println("장바구니에 담겼습니다");
        System.out.println();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        drinkPageMethod(itemsList, orderList);
    }

//재현
    public void addMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("메뉴 추가 페이지\n");
        System.out.println("음식 카테고리(String), 음식 이름(String), 음식 설명(String), 가격(int), 음식 ID(String)을 입력합니다.");

        System.out.print("음식 카테고리(String): ");
        String category = scanner.nextLine();
        System.out.print("음식 이름(String): ");
        String name = scanner.nextLine();
        System.out.print("음식 설명(String): ");
        String description = scanner.nextLine();
        System.out.print("가격(int): ");
        //타입이 int가 아닐 경우 프로그램이 종료되는 문제를 해결하기 위해 한준님의 함수를 응용 -> int로 입력되지 않으면 다시 입력 반복
        String priceString = scanner.nextLine();
        int price = kioskScanner(priceString);
        while (price==-1) {
            System.out.println("잘못된 입력입니다.");
            System.out.print("다시 입력해주세요.");
            System.out.print("가격(int): ");
            priceString = scanner.nextLine();
            price = kioskScanner(priceString);
        }
        System.out.print("음식 ID(String): ");
        String id = scanner.nextLine();

        addMenuCheck(category, name, description, price, id);
    }
//재현
    public void addMenuCheck(String category, String name, String description, int price, String id) {

        System.out.println("이 내용으로 추가 하시겠습니까?");
        System.out.println("카테고리: " + category + ", 이름: " + name + ", 설명: " + description + ", 가격: " + price + ", ID: " + id + "\n");
        System.out.println("1. 추가  2. 다시입력  3. 취소");

        Scanner scanner = new Scanner(System.in);
        String yesOrNo = scanner.nextLine();
        if (yesOrNo.equals("1")) {
            Main.menuAndID.put(id, new Items(name, description, price));
            Main.categoryID.put(id, category);
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
//재현
    public void delMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("메뉴 삭제 페이지");
        System.out.println("삭제 할 음식의 ID를 입력하세요.\n");

        for (Map.Entry<String, Items> entry : Main.menuAndID.entrySet()) {
            System.out.println(entry.getValue().name + " | ID:" + entry.getKey());
        }

        String inputID = scanner.nextLine();
        delMenuCheck(inputID);
    }
//재현
    public void delMenuCheck(String id) {

        for(Map.Entry<String, Items> entry : Main.menuAndID.entrySet()) {
            if (entry.getKey().equals(id)) {
                System.out.println("정말 삭제 하시겠습니까?");
                System.out.println("1. 삭제  2. 취소");

                Scanner scanner = new Scanner(System.in);
                String yesOrNo = scanner.nextLine();
                if (yesOrNo.equals("1")) {
                    Main.menuAndID.remove(id);
                    Main.categoryID.remove(id);
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
