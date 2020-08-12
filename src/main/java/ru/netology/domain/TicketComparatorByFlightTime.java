package ru.netology.domain;

import java.util.Comparator;

public class TicketComparatorByFlightTime implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getFlightTimeInMinutes() - o2.getFlightTimeInMinutes();
    }
}
