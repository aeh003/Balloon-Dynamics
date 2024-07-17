package hw1;
/**
 * Program models the change a hot air balloon has based on numerous conditions like temperature, fuel, and the length of the tether
 * @author aeh003
 */
public class Balloon {
	/**
	 * heat loss factor
	 */
	private static final double HEAT_LOSS_FACTOR = 0.1;
	/**
	 * initialized as a double to be able to not type cast later on
	 * volume of the air in the balloon in m^3
	 */
	private static final double AIR_VOLUME = 61234;
	/**
	 * Acceleration due to gravity in m/s^2
	 */
	private static final double GRAVITY_ACCELERATION = 9.81;
	/**
	 * The gas constant in J/(kgK)
	 */
	private static final double GAS_CONSTANT = 287.05;
	/**
	 * standard pressure in hPa
	 */
	private static final double STANDARD_PRESSURE = 1013.25;
	/**
	 * kelvins at 0 degrees Celsius 
	 */
	private static final double KELVINS = 273.15;
	/*
	 * time
	 */
	private double time;
	/**
	 * full minutes after the simulation started
	 */
	private double minutes;
	/**
	 * seconds remaining after minutes are taken into account since the simulation started
	 */
	private double seconds;
	/**
	 * altitude
	 */
	private double altitude;
	/**
	 * remaining fuel
	 */
	private double remainingFuel;
	/**
	 * fuel burn rate
	 */
	private double fuelBurnRate;
	/**
	 * balloon mass
	 */
	private double balloonMass;
	/**
	 * velocity
	 */
	private double velocity;
	/**
	 * length of the tether
	 */
	private double tetherLength;
	/**
	 * temperature of the air outside the balloon
	 */
	private double outsideTemperature;
	/**
	 * temperature of the air inside the balloon
	 */
	private double balloonTemperature;
	/**
	 * wind direction 0-359 inclusive
	 */
	private double wind;
	/**
	 * initial wind direction
	 */
	private double initialWind;
	/**
	 * initial outsideTemperature
	 */
	private double initialTemperature;
	/**
	 * constructs a new balloon
	 * balloon temperature is initialized to the same temperature as the outside air which both equal airTemp parameter
	 * time starts at zero
	 * balloon's altitude, remaining fuel, fuel burn rate, balloon mass, velocity, and tether length all initialized to zero
	 * @param airTemp 
	 * 	 temperature of the air in celsius outside and inside the balloon
	 * @param windDirection
	 * 	 direction of the wind in degrees [0,360)
	 */
	public Balloon(double airTemp, double windDirection) {
		altitude = 0;
		remainingFuel = 0;
		fuelBurnRate = 0;
		balloonMass = 0;
		velocity = 0;
		tetherLength = 0;
		initialTemperature = airTemp;
		initialWind = windDirection;
		outsideTemperature = airTemp;
		balloonTemperature = airTemp;
		wind = windDirection;
				
	}
	/**
	 * gets remaining fuel
	 * @return 
	 * 	 the remaining fuel that can heat the balloon
	 */
	public double getFuelRemaining() {
		return remainingFuel;
	}
	/**
	 * sets the remaining fuel that can heat the balloon
	 * @param fuel 
	 * 	 the amount of fuel
	 */
	public void setFuelRemaning(double fuel) {
		remainingFuel = fuel;
	}
	/**
	 * gets the mass of the balloon
	 * @return 
	 * 	 the mass of the balloon
	 */
	public double getBalloonMass() {
		return balloonMass;
	}
	/**
	 * sets mass of the balloon
	 * @param fuel 
	 * 	 the amount of fuel
	 */
	public void setBalloonMass(double fuel) {
		balloonMass = fuel;
	}
	/**
	 * gets the outside air temperature
	 * @return 
	 * 	 the outside air temperature
	 */
	public double getOutsideAirTemp() {
		return outsideTemperature;
	}
	/**
	 * sets the outside air temperature
	 * @param temp
	 * 	 the temp of the outside air
	 */
	public void setOutsideAirTemp(double temp) {
		outsideTemperature = temp;
	}
	/**
	 * gets the fuel burn rate
	 * @return 
	 * 	 the fuel burn rate
	 */
	public double getFuelBurnRate() {
		return fuelBurnRate;
	}
	/**
	 * set the fuel burn rate
	 * @param rate 
	 * 	 the rate at which the fuel burns
	 */
	public void setFuelBurnRate(double rate) {
		fuelBurnRate = rate;
		
	}
	/**
	 * gets the balloon temperature
	 * @return 
	 * 	 the balloon temperature
	 */
	public double getBalloonTemp() {
		return balloonTemperature;
	}
	/**
	 * sets the balloon temperature
	 * @param temp 
	 * 	 the temperature of the balloon
	 */
	public void setBalloonTemp(double temp) {
		balloonTemperature = temp;
	}
	/**
	 * gets the balloon velocity
	 * @return 
	 * 	 the velocity of the balloon
	 */
	public double getVelocity() {
		return velocity;
	}
	/**
	 * gets the balloon altitude
	 * @return 
	 * 	 the altitude of the balloon
	 */
	public double getAltitude() {
		return altitude;
	}
	/**
	 * gets the length of the tether
	 * @return 
	 * 	 the length of the tether
	 */
	public double getTetherLength() {
		return tetherLength; 
	}
	/**
	 * gets the length of the tether minus the current altitude of the balloon
	 * @return 
	 * 	 the remaining tether length
	 */
	public double getTetherRemaining() {
		return tetherLength - altitude;
	}
	/**
	 * sets the tether length
	 * @param length
	 * 	 The length of the tether
	 */
	public void setTetherLength(double length) {
		tetherLength = length;		
	}
	/**
	 * gets the direction of the wind in degrees from 0(inclusive) to 360(exclusive) degrees
	 * @return 
	 * 	 the direction of the wind in degrees
	 */
	public double getWindDirection() {
		return wind;
	}
	/**
	 * updates wind direction which is assumed to be between -360 and 360
	 * wind direction must be between 0 inclusive and 360 exclusive
	 * @param deg 
	 *  The degree of the wind
	 */
	public void changeWindDirection(double deg) {
		wind = (deg + 360 + wind) % 360; 
	}
	/**
	 * gets the number of full minutes that passed in the simulation
	 * @return 
	 * 	 number of full minutes 
	 */
	public long getMinutes() {
		minutes = time/60;
		return (long) minutes;
	}
	/**
	 * gets the left over seconds that do not create a full minute
	 * @return 
	 * 	 left over seconds that do not create a full minute
	 */
	public long getSeconds() {
		seconds = time % 60;
		return (long)seconds;
	}
	/**
	 * one seconds of time passes
	 * the fuel remaining is consumed at the set fuel burn rate; can not drop below zero
	 * if fuel burn rate is larger than remaining fuel use the available fuel but no more
	 * updates the fuel burn rate and remaining fuel
	 * temperature is updated
	 * updates the velocity and position of the balloon
	 */
	public void update() {
		//local variables
		double prevVelocity = velocity;
		double prevAltitude = altitude;
		double tempAltitude;
		double prevBalloonTemperature = balloonTemperature;
		double changeInTemp;
		double surroundingDensity;
		double balloonDensity;
		double liftForce;
		double gravityForce;
		double netForce;
		double upwardAcceleration;
		double tempFuelRemaining;
		time+= 1;
		//calculations for velocity and acceleration
		// calculations for fuel remaining
		
		setFuelBurnRate(Math.min(remainingFuel, fuelBurnRate)); 
		changeInTemp = getFuelBurnRate() + (outsideTemperature - balloonTemperature) * HEAT_LOSS_FACTOR;
		balloonTemperature = prevBalloonTemperature + changeInTemp;
		surroundingDensity = STANDARD_PRESSURE/(GAS_CONSTANT*(outsideTemperature + KELVINS));
		balloonDensity = STANDARD_PRESSURE/(GAS_CONSTANT*(balloonTemperature + KELVINS));
		liftForce = AIR_VOLUME *(surroundingDensity - balloonDensity) * GRAVITY_ACCELERATION;
		gravityForce = balloonMass * GRAVITY_ACCELERATION;
		netForce = liftForce - gravityForce;
		upwardAcceleration = netForce / balloonMass;
		velocity = prevVelocity + upwardAcceleration;
		tempAltitude = prevAltitude + velocity;
		altitude = Math.max(0,Math.min(tetherLength, tempAltitude)); 
		tempFuelRemaining = remainingFuel - fuelBurnRate; 
		remainingFuel = Math.max(0, tempFuelRemaining);	
		
				
	}
	/**
	 * sets the simulation back to its initial state
	 */
	public void reset() {
		time = 0;
		altitude = 0;
		remainingFuel = 0;
		fuelBurnRate = 0;
		balloonMass = 0;
		velocity = 0;
		tetherLength = 0;
		outsideTemperature = initialTemperature;
		balloonTemperature = initialTemperature;
		wind = initialWind;		
	}
}
