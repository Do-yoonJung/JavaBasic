package Doit_197p_Quiz;

public class Card {
	private static int serialNum = 100;
	private int cardNum;
	
	public Card() {
		serialNum++;
		cardNum = serialNum;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	
}
