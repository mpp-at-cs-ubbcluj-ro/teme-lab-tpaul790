package ro.mpp2025.domain;

import java.time.LocalDateTime;

public class Flight extends Entity<Integer> {
    private String from;
    private String to;
    private String airport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int seatsAvailable;

    public Flight(String from, String to, String airport, LocalDateTime departureTime, LocalDateTime arrivalTime, int seatsAvailable) {
        this.from = from;
        this.to = to;
        this.airport = airport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatsAvailable = seatsAvailable;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}
