package ro.mpp2025.domain;

import java.util.List;

public class Ticket extends Entity<Integer> {
    private Flight flight;
    private int nrOfSeats;
    private List<Tourist> tourists;

    public Ticket(Flight flight, int nrOfSeats, List<Tourist> tourists) {
        this.flight = flight;
        this.nrOfSeats = nrOfSeats;
        this.tourists = tourists;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public List<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(List<Tourist> tourists) {
        this.tourists = tourists;
    }
}
