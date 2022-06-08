package com.talent.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.talent.domain.data.TalentItemDto;
import com.talent.domain.enums.TALENT_ITEM_STATUS;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "talent_item")
@Table(name = "talent_item")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalentItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long talentId;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime dateTime;
	private Integer price;

	@Enumerated(EnumType.STRING)
	private TALENT_ITEM_STATUS status;

	public static TalentItem parseFrom(TalentItemDto src) {
		return TalentItem.builder()
				.id(src.getId())
				.talentId(src.getTalentId())
				.dateTime(src.getDateTime())
				.price(src.getPrice())
				.status(src.getStatus())
				.build();
	}

	public static List<TalentItemDto> toDtoList(List<TalentItem> list) {
		return list.stream().map(TalentItem::toDto).collect(Collectors.toList());
	}

	public TalentItemDto toDto() {
		return TalentItemDto.builder()
				.id(id)
				.talentId(talentId)
				.dateTime(dateTime)
				.price(price)
				.status(status)
				.build();
	}
}
