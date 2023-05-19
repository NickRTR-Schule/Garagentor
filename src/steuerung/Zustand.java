package steuerung;

public abstract class Zustand
{
	protected Steuerung dieSteuerung;

	public Zustand(Steuerung pSteuerung)
	{
		dieSteuerung = pSteuerung;
	}

	public abstract void empfangenSensorsignal(int pPositionSensor);

	public abstract void gedruecktAb();

	public abstract void gedruecktAuf();

	public abstract void gedruecktStopp();
}
