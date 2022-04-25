

public class MontyHall{
		
	public static boolean game(boolean switchDoorAfterReveal) {
		boolean door1 = false;
		boolean door2 = false;
		boolean door3 = false;

		//set a random door to true, meaning it has the car behind it
		int doorNum = (int)(Math.random() * 3);
		if(doorNum == 1)
			door1 = true;
		else if(doorNum == 2)
			door2 = true;
		else
			door3 = true;

		boolean[] doors = {door1, door2, door3};
		//At this point, we have 3 elements in an array with one chosen at random to have the car behind it
		
		//Contestant chooses one of the 3 doors at random
		int pick = (int)(Math.random() * 3);
		
		//if the contestant decides to switch doors, this will execute
		if(switchDoorAfterReveal == true) {
			//if the door isn't the original pick and doesn't have the car, mark the door as revealed
			int revealed = -1;
			for(int i = 0; i <= 3; i++) {
				if(i != pick && doors[i] == false) {
					revealed = i;
					break;
				}
			}
		
			//return the element that isn't the original pick or the element revealed, because in this scenario the contestant decides to switch her door
			for(int i = 0; i <= 3; i++) {
				if(i != pick && i != revealed) {
					return doors[i];
				}
			}
		}
		
		//if switchDoor is false, this will execute which means that the contestant stuck with their original choice
		return doors[pick];
	}
	
	
	
	public static void main(String args[]) {
		int trueCount = 0;
		int falseCount = 0;
		for(int plays = 0; plays < 10000; plays++) {
			boolean result = game(true); //if the input boolean is true, the contestant will switch doors
			if(result == true)
				trueCount++;
			else
				falseCount++;
		}
		
		System.out.println("After switching doors, the contestant got the car %" + trueCount/100.0 + " of the time.");
		System.out.println("got car: " + trueCount);
		System.out.println("didnt get car: " + falseCount);
	}
}
