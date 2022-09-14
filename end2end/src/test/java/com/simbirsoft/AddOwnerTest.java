package com.simbirsoft;

import com.simbirsoft.data.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOwnerTest {

	private OwnersManager om = new OwnersManager();

	@Test
	void checkAddOwner() {
		open("http://localhost:8080/owners/find");
		$("a.btn").click();

		$("#firstName").setValue("John");
		$("#lastName").setValue("Smiths");
		$("#address").setValue("Red Square");
		$("#city").setValue("Moscow");
		$("#telephone").setValue("111222333");

		$("button[type=submit]").click();

		Owner actualOwner = om.findByLastName("Smiths").get(0);

		assertEquals("Moscow", actualOwner.getCity());
	}
}
