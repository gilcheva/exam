package com.endava.supermarket.model;

import com.endava.supermarket.model.enums.PaymentType;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name="purchases")
public class Purchase {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name="purchase_id")
  private String purchaseId;

  @NotBlank
  @ManyToOne
  @JoinColumn(name = "supermarket_id")
  private Supermarket supermarket;

//  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//  private List<Item> item = new ArrayList<>();

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "payment_type")
  private PaymentType paymentType;

  @Column(name="cash_amount")
  private Double cashAmount;

  @Column(name="total_price")
  private Double totalPrice;

  @Column(name="returned_change")
  private Double returnedChange;

  @Column (name = "time_of_the_executed_payment")
  private LocalDateTime timeOfPayment;
}
