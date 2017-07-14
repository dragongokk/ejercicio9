package es.cic.taller.ejercicio09;

import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

import es.cic.taller.ejercicio09.mus.Baraja;
import es.cic.taller.ejercicio09.mus.Carta;
import es.cic.taller.ejercicio09.mus.Tapete;

public class PantallaLayout extends GridLayout {

	private TapeteForm tapete1;
	private TapeteForm tapete2;
	private TapeteForm tapete3;
	private TapeteForm tapete4;
	
	private MyUI myUI;
	
	private Baraja baraja;
	
	public PantallaLayout(MyUI myUI, Baraja baraja) {
		this.myUI = myUI;
		this.baraja = baraja;
		Tapete manoTapete1 = baraja.getTapete();
		
		tapete1 = new TapeteForm(myUI);
		tapete1.setTapete(manoTapete1);

		
		Tapete manoTapeteDorso = new Tapete();
		manoTapeteDorso.setCarta1(Carta.getDorso());
		manoTapeteDorso.setCarta2(Carta.getDorso());
		manoTapeteDorso.setCarta3(Carta.getDorso());
		manoTapeteDorso.setCarta4(Carta.getDorso());
		
		tapete2 = new TapeteForm(myUI);
		tapete2.setTapete(manoTapeteDorso);
		
		tapete3 = new TapeteForm(myUI);
		tapete3.setTapete(manoTapeteDorso);
		
		tapete4 = new TapeteForm(myUI);
		tapete4.setTapete(manoTapeteDorso);

		setRows(3);
		setColumns(3);
        Button apuesto = new Button("Apuesto");
        apuesto.addClickListener(event -> Notification.show("De momento no hago nada", Type.TRAY_NOTIFICATION));
        Button paso = new Button("Paso");
        apuesto.addClickListener(event -> Notification.show("De momento no hago nada", Type.TRAY_NOTIFICATION));
        Button envido = new Button("Envido");
        apuesto.addClickListener(event -> Notification.show("De momento no hago nada", Type.TRAY_NOTIFICATION));
        Button ordago = new Button("Órdago");
        apuesto.addClickListener(event -> Notification.show("De momento no hago nada", Type.TRAY_NOTIFICATION));
        Button mus = new Button("Mus");
        apuesto.addClickListener(event -> Notification.show("De momento no hago nada", Type.TRAY_NOTIFICATION));
        Button noMus = new Button("No Mus");
        apuesto.addClickListener(event -> Notification.show("De momento no hago nada", Type.TRAY_NOTIFICATION));
        VerticalLayout botones=new VerticalLayout();
        botones.addComponents(apuesto,paso,envido,ordago);
		
		addComponent(tapete1, 1, 2);
		addComponent(tapete2, 1, 0);
		addComponent(tapete3, 0, 1);
		addComponent(tapete4, 2, 1);
		addComponent(botones,0,2);
		
		
		
	}
	
	
	
}
