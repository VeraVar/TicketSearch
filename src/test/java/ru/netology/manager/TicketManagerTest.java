package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketComparatorByFlightTime;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket ticket1 = new Ticket(1, 100, "airport1", "airport2", 90);
    private Ticket ticket2 = new Ticket(2, 200, "airport1", "airport2", 90);
    private Ticket ticket3 = new Ticket(3, 300, "airport3", "airport4", 120);
    private Ticket ticket4 = new Ticket(4, 400, "airport4", "airport5", 180);


    @BeforeEach
    void setUp(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    public void shouldFindTicketsIfExists(){
        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = manager.findAll("airport1", "airport2", new TicketComparatorByFlightTime());

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTicketsIfNotExists(){
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("airport5", "airport6", new TicketComparatorByFlightTime());

        assertArrayEquals(expected, actual);
    }
}
