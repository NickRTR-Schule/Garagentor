package steuerung;

import java.util.ArrayList;

import benutzerschnittstelle.Benutzerschnittstelle;
import fachkonzept.Motor;
import fachkonzept.Richtung;
import fachkonzept.Sensor;

public class Steuerung
{
	private Benutzerschnittstelle dieBenutzerschnittstelle;
	private Motor derMotor;
	private ArrayList<Sensor> derSensor;
	private int positionOben;
	private int positionUnten;
	private Zustand derZustand;

	public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle)
	{
		dieBenutzerschnittstelle = pBenutzerschnittstelle;

		positionOben = 100;
		positionUnten = 0;
		derZustand = new Unten(this);
		int initialePositionTor = 0;
		derMotor = new Motor(initialePositionTor);

		derSensor = new ArrayList<Sensor>();
		for (int positionSensor = positionUnten; positionSensor <= positionOben; positionSensor++)
		{
			derSensor.add(new Sensor(this, derMotor, positionSensor));
		}
	}

	public void empfangenSensorsignal(int pPositionSensor)
	{
		derZustand.empfangenSensorsignal(pPositionSensor);
		dieBenutzerschnittstelle.zeigePositionTor(pPositionSensor);
	}

	public void gedruecktAb()
	{
		derZustand.gedruecktAb();
	}

	public void gedruecktAuf()
	{
		derZustand.gedruecktAuf();
	}

	public void gedruecktStopp()
	{
		derZustand.gedruecktStopp();
	}

	public int liesPositionOben()
	{
		return positionOben;
	}

	public int liesPositionUnten()
	{
		return positionUnten;
	}

	public void setzeZustand(Zustand pZustand)
	{
		derZustand = pZustand;
	}

	public void starteMotor(Richtung pRichtung)
	{
		derMotor.starte(pRichtung);
	}

	public void stoppeMotor()
	{
		derMotor.stoppe();
	}
}
