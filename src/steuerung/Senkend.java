package steuerung;

import fachkonzept.Richtung;

public class Senkend extends Zustand
{

	public Senkend(Steuerung pSteuerung)
	{
		super(pSteuerung);
		entry();
	}

	private void entry()
	{
		dieSteuerung.starteMotor(Richtung.ab);
	}

	private void exit()
	{
		dieSteuerung.stoppeMotor();
	}

	@Override
	public void empfangenSensorsignal(int pPositionSensor)
	{
		if (pPositionSensor == 0)
		{
			exit();
			dieSteuerung.setzeZustand(new Unten(dieSteuerung));
		}
	}

	@Override
	public void gedruecktAb()
	{
	}

	@Override
	public void gedruecktAuf()
	{
		exit();
		dieSteuerung.setzeZustand(new Hebend(dieSteuerung));
	}

	@Override
	public void gedruecktStopp()
	{
		exit();
		dieSteuerung.setzeZustand(new GestopptMitte(dieSteuerung));
	}

}
