package steuerung;

public class GestopptMitte extends Zustand
{

	public GestopptMitte(Steuerung pSteuerung)
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
		dieSteuerung.setzeZustand(new Hebend(dieSteuerung));
	}

	@Override
	public void gedruecktStopp()
	{
	}

}
