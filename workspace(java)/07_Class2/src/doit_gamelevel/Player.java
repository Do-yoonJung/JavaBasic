package doit_gamelevel;

public class Player {
	// Player가 가지는 level 변수 선언
	// 포함관계. Player는 한 개의 level 변수를 가지고, 이는 PlayerLevel 형임.
	private PlayerLevel level;
	
	// 디폴트 생성자
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	
	public PlayerLevel getLevel() {
		return level;
	}
	
	// 레벨 변경 메서드
	// 현재 자신의 level을 매개변수로 받은 level로 변경하고 레벨 메시지 출력
	// 매개변수 자료형은 모든 레벨로 변환 가능한 PlayerLevel
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
	}
	
	// PlayerLevel의 템플릿 메서드 go() 호출
	public void play(int count) {
		level.go(count);
	}
}
