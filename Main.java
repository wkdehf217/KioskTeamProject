import java.util.*;

public class Main {

    //전역변수로 사용하기 위해 menuAndID, catecoryID를 위로 뺐습니다.
    public static Map<String, Items> menuAndID = new HashMap<>();
    public static Map<String, String> categoryID = new HashMap<>();

    public static void main(String[] args) {




        // 버거 메뉴   ->  전체메뉴 menuAndID<ID,Items> , 카테고리묶는 맵<ID,카테고리>
        // 음료 메뉴   ->
        // 디저트 메뉴 ->

        {
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
        }


        //이거로 출력 메서드 만들기 --> categoryID의 밸류가 burger이면 burger메뉴화면에 출력
        //추가 할 때도 여기에 추가하는 메서드를 만들면
        categoryID.put("burger_1", "burger");
        categoryID.put("burger_2", "burger");
        categoryID.put("burger_3", "burger");
        categoryID.put("burger_4", "burger");
        categoryID.put("burger_5", "burger");
        categoryID.put("burger_6", "burger");
        categoryID.put("drink_1", "drink");
        categoryID.put("drink_2", "drink");
        categoryID.put("drink_3", "drink");
        categoryID.put("drink_4", "drink");
        categoryID.put("drink_5", "drink");
        categoryID.put("drink_6", "drink");
        categoryID.put("dessert_1", "dessert");
        categoryID.put("dessert_2", "dessert");
        categoryID.put("dessert_3", "dessert");
        categoryID.put("dessert_4", "dessert");
        categoryID.put("dessert_5", "dessert");
        categoryID.put("dessert_6", "dessert");
        categoryID.put("dessert_7", "dessert");


//        //키,밸류 가져오는 코드
//        String result = "";
//        Iterator<String> keys = menuAndID.keySet().iterator();
//        while (keys.hasNext()) {
//            String key1 = keys.next();
//            String value = menuAndID.get(key1).name;
//            result += "key : " + key1 + ", value : " + value + "\n";
//        }
//        System.out.println(result);

//        //밸류가 버거에 해당하면 작동되는 코드
//        for (Map.Entry<String, String> entry1 : categoryID.entrySet()) {  //categoryID 맵에서
//            if (entry1.getValue().equals("burger")) {   //밸류가 버거라면 --> 입력을 "burger" 혹은 "drink" 등으로 바꿔주면 됨
//                //categoryID 맵의 키 == menu 맵의 밸루 찾아서 해당 menu맵의 키를 가져와서 출력
//                for (Map.Entry<String, Items> entry2 : menuAndID.entrySet()) {
//                    if (entry1.getKey().equals(entry2.getKey())) {
//                        System.out.println(entry2.getValue().name); //이걸 리턴으로 바꾸면 다른데 사용 가능
//                    }
//                }
//            }
//        }


        /*
        // 버거 메뉴 0~99
        List<Items> menu = new ArrayList<>();
        menu.add(0, new Items("ShackBurger",
                "토마토, 양상추, 쉑소스가 토핑된 치즈버거!!!",
                6900));
        menu.add(1, new Items("SmokeShack",
                "애플 우드 칩으로 훈연한 베이컨, 매콤한 체리 페퍼에 쉐소스가 토핑된 치즈 버거",
                8900));
        menu.add(2,new Items("ShroomBurger",
                "몬스터 치즈와 체다 치즈로 속을 채우고 바삭하게 뒤겨낸 포토벨로 버섯 패티에 양상추, 토마토, 쇅소스를 올린 베지테리안 버거",
                9400));
        menu.add(3,new Items("Shack Stack",
                "슈룸 버거와 쉑버거의 맛을 한번에 즐길 수 있는 메뉴",
                12400));
        menu.add(4,new Items("Cheeseburger",
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                6900));
        menu.add(5,new Items("Hamburger",
                "포테이토 번과 비프패티를 기본으로 신선한 양상추, 토마토 피클, 양파 토핑을 취향에 따라 선택할 수 있는 버거",
                5400));

        // 빈 메뉴 공간
        for(int i = 6; i < 101; i++) {
            menu.add(i, null);
        }
        // 음료 메뉴 100 ~ 199
        menu.add(100, new Items("Shake", "바닐라, 초콜렛, 솔티드 카라멜, 블랙& 화이트, 스트로베리, 피넛버터, 커피", 5900));
        menu.add(101, new Items("Shake of the Week", "특별한 커스터드 플레이버", 6500));
        menu.add(102, new Items("Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6500));
        menu.add(103, new Items("Floats", "루트 비어, 퍼플 카우, 크림시클", 5900));
        menu.add(104, new Items("Cups&Cones", "바닐라, 초콜렛, Flavor of the Week", 4900));
        menu.add(105, new Items("Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5900));

        // 빈 메뉴 공간
        for(int i = 107; i < 201; i++) {
            menu.add(i, null);
        }
        // 디저트 메뉴 200~299
        menu.add(200, new Items("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 3900));
        menu.add(201, new Items("Fresh Brewed Ice Tea", "직접 유기농 홍차를 우려낸 아이스티", 3400));
        menu.add(202, new Items("Fifty/Fifty", "레몬에이트와 아이스티의 만남", 3500));
        menu.add(203, new Items("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2700));
        menu.add(204, new Items("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 단산음료", 4400));
        menu.add(205, new Items("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1000));
        menu.add(206, new Items("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9800));

        // 주문 목록 리스트 생성
        List<Items> orderList = new ArrayList<>();
        //주문 시작 지점
        Page start = new Page();
        start.mainPageMethod(menu, orderList);*/

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
        long price = scanner.nextLong();
        scanner.nextLine();
        System.out.print("음식 ID(String): ");
        String id = scanner.nextLine();

        // 입력을 모두 받은 후에 addMenuCheck() 호출돼야하는데 왜 ""입력되면서 실행????????????????????????????????????????????????????????
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
            //첫 화면 실행 메서드 복붙!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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

        //이녀석이 제일 먼저 실행되도록 join() 메서드 사용
            Thread yourThread = new Thread(() -> {
                // 스레드가 수행할 작업
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
                        } else if (yesOrNo.equals("2")) {
                            System.out.println("취소되었습니다.");
                        } else {
                            System.out.println("다시 입력하세요.");
                            delMenuCheck(id);
                        }
                        //첫화면 실행 메서드!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    }
                }
            });

            //스레드 시작
            yourThread.start();
            try {
                // yourThread 스레드가 완료될 때까지 현재 스레드를 일시 중단
                yourThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        System.out.println("ID가 일치하지 않습니다.\n");
        delMenu();

    }
}

