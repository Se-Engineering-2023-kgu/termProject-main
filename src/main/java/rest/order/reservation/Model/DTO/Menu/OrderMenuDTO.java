package rest.order.reservation.Model.DTO.Menu;

public record OrderMenuDTO (
    // 메뉴와 관련된 부분 받게 하고
    int count
){
    // getter를 통해 페이지에 넘길 애들만 모아두기? 아마? 
    
    public static void from(OrderMenuDTO orderMenuDTO) {
        
    }

}
