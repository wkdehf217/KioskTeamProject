import java.util.*;

public class Main {

    //전역변수로 사용하기 위해 menuAndID, catecoryID를 위로 뺐습니다.
    public static Map<String, Items> menuAndID = new HashMap<>();
    public static Map<String, String> categoryID = new HashMap<>();

    public static void main(String[] args) {
        // 버거 메뉴   ->  전체메뉴 menuAndID<ID,Items> , 카테고리묶는 맵<ID,카테고리>
        // 음료 메뉴   ->
        // 디저트 메뉴 ->

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



        //이거로 출력 메서드 만들기 --> categoryID의 밸류가 burger이면 burger메뉴화면에 출력
        //추가 할 때도 여기에 추가하는 메서드를 만들면
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
//주문 시작 지점
        List<Items> orderList =  new ArrayList<>();
        Page start = new Page();
        start.mainPageMethod(menuAndID,categoryID,orderList);
    }

}

