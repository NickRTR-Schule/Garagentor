package steuerung;

public class Unten extends Zustand
{

	public Unten(Steuerung pSteuerung)
	{
		super(pSteuerung);

	}

	@Override
	public void empfangenSensorsignal(int pPositionSensor)
	{
	}

	@Override
	public void gedruecktAb()
	{
	}

	@Override
	public void gedruecktAuf()
	{
		dieSteuerung.setzeZustand(new Hebend(dieSteuerung));
	}

	@Override
	public void gedruecktStopp()
	{
	}
}
