package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.Model.DTO.TableDTO;
import rest.order.reservation.Model.TableList;
import rest.order.reservation.Repository.TableRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    TableRepo tableRepository;

    public TableService(TableRepo tableRepository) {
        this.tableRepository = tableRepository;
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


}
