package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.DTO.TableDTO;
import rest.order.reservation.Model.Reservation;
import rest.order.reservation.Model.TableList;
import rest.order.reservation.Repository.Reservation.ReservationRepo;
import rest.order.reservation.Repository.TableRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TableService {

    TableRepo tableRepository;
    ReservationRepo reservationRepository;

    public TableService(TableRepo tableRepository, ReservationRepo reservationRepository) {
        this.tableRepository = tableRepository;
        this.reservationRepository = reservationRepository;
    }

    public Long addTable(TableDTO tableDto) {
        TableList tableListClass = new TableList(tableDto.getNumber(), tableDto.getSeats(), tableDto.getExist());
        tableRepository.save(tableListClass);
        return tableListClass.getTid();
    }

    public List<TableList> findAllTable() {
        return (List<TableList>) tableRepository.findAll();
    }

    public void deleteTable(Long id) {
        Optional<TableList> tableClass = tableRepository.findById(id);
        if (tableClass.isPresent()) {
            tableRepository.delete(tableClass.get());
        } else {
            throw new RuntimeException("request Menu id is not found " + id);
        }
    }

    public TableList findTable(Long id) {
        return tableRepository.findById(id).get();
    }

    @Transactional
    public void updateTable(Long id, TableDTO tableDTO) {
        TableList tableListClass = tableRepository.findById(id).get();
        tableListClass.chageTableInfo(tableDTO.getNumber(), tableDTO.getSeats(), tableDTO.getExist());
    }


    public List<Long> getAvailableTables(String date, String time) {
        LocalDate findDate = LocalDate.parse(date);
        System.out.println("findDate = " + findDate);
        System.out.println("TimeSlot.valueOf(time) = " + TimeSlot.valueOf(time));
        List<Reservation> reservationList = reservationRepository.findByDateSlotAndTimeSlot(findDate, TimeSlot.valueOf(time));

        List<Long> tableLists = new ArrayList<>();
        if (reservationList != null) {
            tableLists = reservationList.stream()
                    .map(reservation -> reservation.getTables().getTid())
                    .collect(Collectors.toList());
        }
        return tableLists;
    }
}
