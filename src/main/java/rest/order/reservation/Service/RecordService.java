package rest.order.reservation.Service;

import rest.order.reservation.Repository.BookRepo;

// 이 서비스는 예약과 관련없는 통계를 내기 위한 메소드들을 몰아넣기 위해서 만든 서비스 입니다. 
// 구분해서 사용할 것 

public class RecordService {
   private BookRepo recordsRepo;

   public RecordService(BookRepo recordsRepo) {
       this.recordsRepo = recordsRepo;
   }

}
