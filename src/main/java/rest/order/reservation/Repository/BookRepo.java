package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rest.order.reservation.Model.Book;


/*
 * JpaRepository == SQL을 적당하게 만들어주는 편한 라이브러리라고 생각하시면 좋습니다. 
 * 편한 라이브러리라고 막 쓰면 저세상 가기 딱 좋습니다만 
 * 일단 무엇인가를 하기 위해서 쓰는 것인 만큼 이게 유용할 겁니다. 
 */


 @Repository
public interface BookRepo extends JpaRepository<Book, Long>{
    private Book book;
}
