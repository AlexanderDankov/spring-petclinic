package com.simbirsoft;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.simbirsoft.data.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FindOwnersTest {

	private OwnersManager om = new OwnersManager();
	private int createdOwnerId;

	@BeforeEach
	void createOwner() {
		createdOwnerId = om.createOwner(Owner.builder()
			.firstName("Alexander")
			.lastName("Dankov")
			.address("Groove Street")
			.city("Moscow")
			.telephone("12345678")
			.build());
	}

	@AfterEach
	void releaseOwner() {
		om.deleteOwner(createdOwnerId);
	}

	@RepeatedTest(2)
	@Test
	void findOwnersTest() {
		open("http://localhost:8080/owners/find");
		$("#lastName").setValue("Dankov");
		$("button[type=submit]").click();

		$("table.table").shouldBe(Condition.visible);
		$$("tr").find(Condition.text("Name")).shouldHave(Condition.text("Alexander Dankov"));
	}
}
