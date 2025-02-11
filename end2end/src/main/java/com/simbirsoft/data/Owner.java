package com.simbirsoft.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Owner {

	int id;
	String firstName, lastName, address, city, telephone;
}
