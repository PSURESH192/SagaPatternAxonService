package com.project.paymentmanagement.paymentservice.aggregates;

import com.project.commands.CreateInvoiceCommand;
import com.project.events.InvoiceCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class PaymentAggregate {

    @AggregateIdentifier
    private String paymentId;

    private String hotelId;
    private InvoiceStatus invoiceStatus;

    @CommandHandler
    public PaymentAggregate(CreateInvoiceCommand createInvoiceCommand){
        AggregateLifecycle.apply(new InvoiceCreatedEvent(createInvoiceCommand.paymentId, createInvoiceCommand.hotelId));
    }

    @EventSourcingHandler
    protected void on(InvoiceCreatedEvent invoiceCreatedEvent){
        this.paymentId = invoiceCreatedEvent.paymentId;
        this.hotelId = invoiceCreatedEvent.hotelId;
        this.invoiceStatus = InvoiceStatus.PAYMENT_SUCCESSFUL;
    }
}
