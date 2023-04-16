package rest.order.Model;

public class Table {
    
    
    int tableNO;
    int seats;

    // How to setting the location
    // need to do 
    String locationString;

    public Table(int tableNO, int seats, String locationString) {
        this.tableNO = tableNO;
        this.seats = seats;
        this.locationString = locationString;
    }
    
}
