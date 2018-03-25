import java.util.Arrays;

public class VirtualDroneController {
	
	private VirtualDrone vd;
	
	VirtualDroneController() {
		this.vd = new VirtualDrone();
	}
	
	public String toString() {
		return "Batyr Kornusov's Virtual Drone Controller.";
	}
	
	private int[] moveDrone() {
		if (this.vd.iGetBatteryCharge() < 25) return this.vd.currentCoord;
		this.vd.bMoveBy(1, 2, 3);
		return this.vd.currentCoord;
	}

	public static void main(String[] args) {
		VirtualDroneController vdc = new VirtualDroneController();
		System.out.println(vdc);
		vdc.moveDrone();
		int[] iGPS = vdc.vd.ipGetGPS();
		try {
			java.lang.Runtime.getRuntime().exec(
					"/Applications/Google Chrome.app"
					+ "https:/www.google.com/maps/search/google+maps/@" + Arrays.toString(iGPS) + "z");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	

}
