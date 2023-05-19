package steuerung;

public class Oben extends Zustand
{
	public Oben(Steuerung pSteuerung)
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
		dieSteuerung.setzeZustand(new Senkend(dieSteuerung));
	}

	@Override
	public void gedruecktAuf()
	{
	}

	@Override
	public void gedruecktStopp()
	{
	}

}
