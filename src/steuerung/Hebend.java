package steuerung;

import fachkonzept.Richtung;

public class Hebend extends Zustand
{

	public Hebend(Steuerung pSteuerung)
	{
		super(pSteuerung);
		entry();
	}

	private void entry()
	{
		dieSteuerung.starteMotor(Richtung.auf);
	}

	private void exit()
	{
		dieSteuerung.stoppeMotor();
	}

	@Override
	public void empfangenSensorsignal(int pPositionSensor)
	{
		if (pPositionSensor == 100)
		{
			exit();
			dieSteuerung.setzeZustand(new Oben(dieSteuerung));
		}
	}

	@Override
	public void gedruecktAb()
	{
		exit();
		dieSteuerung.setzeZustand(new Senkend(dieSteuerung));
	}

	@Override
	public void gedruecktAuf()
	{
	}

	@Override
	public void gedruecktStopp()
	{
		exit();
		dieSteuerung.setzeZustand(new GestopptMitte(dieSteuerung));
	}

}
