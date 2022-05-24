package com.talent.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "talent_item")
@Table(name = "talent_item")
@Data
public class TalentItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long talentUserMapId;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	LocalDateTime dateTime;
	Integer price;
	String status;

}
