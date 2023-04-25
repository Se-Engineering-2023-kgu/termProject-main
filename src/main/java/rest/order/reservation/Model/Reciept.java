package rest.order.reservation.Model;

public class Reciept {
    // 아무래도 추가 기능들을 위해선 이 기능은 결제와 약간의 관련이 있어 보입니다. 
    // 그렇게 해서 생성한 영수증 클래스

    Menu menu;
    int count;
    int total;

    public Reciept(Menu menu, int count, int total) {
        this.menu = menu;
        this.count = count;
        this.total = total;
    }


}
