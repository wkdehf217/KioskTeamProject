public class Order extends Items {

    int orderNumber;

    public Order(String name, String description, long price) {

        super(name, description, price);

    }

//    public void display(){
//        System.out.println("요구사항:" +this.confMessage);
//
//    }

}

//    public void TotalOrder(){//주문내역을 매개변수로 받
//
//        System.out.println("주문 내역 확인" );
//
//
//    }
  //  public void OrderDisplay() {

//        System.out.println("\t요구사항 : " + this.message);
//        System.out.println("\t주문시각 : " + this.orderDate);
//        System.out.println("\t주문상품 목록 : ");
//        for (Item item: cart) {
//            System.out.println("\t\t" + item.name + "   | " + item.price + " | " + item.description);
//        }
//        System.out.println("\t총 가격 : " + this.totalPrice);



