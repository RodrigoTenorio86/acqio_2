package br.com.acqio.document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.acqio.util.CardApplication;
import br.com.acqio.util.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "transaction")
public class Transaction {
	@Id
	@JsonIgnore
	private String id;
	

	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime time;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate date;
	private BigDecimal value;
	private CardApplication cardApplication;
	private PaymentStatus status;
	

}
