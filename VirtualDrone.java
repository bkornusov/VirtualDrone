
public class VirtualDrone {
	private boolean bCanFly = false;
	private int iBatteryCapacity;
	private int currentCharge = 100;
	public int[] currentCoord = {0,0,0};
	
	public VirtualDrone(int cost) {
		this.iBatteryCapacity = cost*30;
		if (cost>400) this.bCanFly = true;
		//The drone's max charge in mAmps/h is 30*its cost
		//For example, a drone that costs 100$ will have a 3000 mA/h battery.
		//If the drone costs more than 400$, it can fly.
	} 

	public VirtualDrone() {
		this(100);
	}
	
	public void main(String[] args) {
		toString();
		bMoveBy(1,2,3);
		System.out.println(iGetBatteryCharge());
		System.out.println(ipGetGPS().toString());
	}

	
	//Methods: 
	
	public void bMoveBy(int x, int y, int z) {
		this.currentCoord[0] += x;
		this.currentCoord[1] += y;
		if (this.bCanFly == false) z = 0;
		else this.currentCoord[2] += z;
		int distance = (int)Math.sqrt(x^2+y^2+z^2);
		this.currentCharge -= 100*distance*10/iBatteryCapacity;
		//reduces the charge by 10*distance mA/h
	}
	
	public String toString() {return "VDrone by Batyr Kornusov"; }
	
	public int iGetBatteryCharge() {return this.currentCharge; }
	
	public int[] ipGetGPS() {return this.currentCoord; }

}
