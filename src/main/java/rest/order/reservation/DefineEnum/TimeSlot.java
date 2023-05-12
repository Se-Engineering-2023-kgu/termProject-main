package rest.order.reservation.DefineEnum;

public enum TimeSlot {
    EIGHT("8:00"), NINE("9:00"), TEN("10:00"), ELEVEN("11:00"),
    TWELVE("12:00"), THIRTEEN("13:00"), FOURTEEN("14:00"),
    FIFTHTTEN("15:00"), SIXTEEN("16:00"), SEVENTEEN("17:00"), EIGHTTEEN("18:00"),
    NINETEEN("19:00"), TWENTY("20:00"), TWENTYONE("21:00");
    private String detail;

    TimeSlot(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}


