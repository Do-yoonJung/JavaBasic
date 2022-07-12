package Doit_197p_Quiz;

public class CardTest {
	public static void main(String[] args) {
		CardCompany CC = CardCompany.getInstance();
		Card card1 = CC.createCard();
		Card card2 = CC.createCard();
		System.out.println(card1.getCardNum());
		System.out.println(card2.getCardNum());
	}
}
