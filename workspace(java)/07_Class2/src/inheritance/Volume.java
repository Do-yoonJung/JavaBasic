package inheritance;

public class Volume {
	
	private int vol = 1;

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}
	
	//볼륨을 올리는 메서드
	void volumeUp() {
		vol++;
		if(vol > 15) {
			vol = 15;
		}
	}
	
	//볼륨을 올리는 메서드
	void volumeDown() {
		vol--;
		if(vol < 1) {
			vol = 1;
		}
	}
}